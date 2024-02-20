package MyAllEntities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Financial_issues_info {//financial_info_id	school_fees	library_status	student_id
	private int fininfoid;
	private String 	schlfees;
	private String 	libstats;
	private String stdid;
	
	public Financial_issues_info() {
	    // Default constructor
      }
	public Financial_issues_info(int fininfoid,String schlfees, String libstats,String stdid) {
		super();
		this.fininfoid=fininfoid;
		this.schlfees=schlfees;
		this.libstats=libstats;
		this.stdid=stdid;
		}
	
	public int getFininfoid() {
		return fininfoid;
	}
	public void setFininfoid(int fininfoid) {
		this.fininfoid = fininfoid;
	}
	public String getSchlfees() {
		return schlfees;
	}
	public void setSchlfees(String schlfees) {
		this.schlfees = schlfees;
	}
	public String getLibstats() {
		return libstats;
	}
	public void setLibstats(String libstats) {
		this.libstats = libstats;
	}
	public String getStdid() {
		return stdid;
	}
	public void setStdid(String stdid) {
		this.stdid = stdid;
	}
	public void makeconnection() {
	}
		public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/graduate_student_management";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO financial_issues_info(school_fees,	library_status,	student_id) VALUES (?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       //preparedStatement.setString(1, this.actid);
	     
	       preparedStatement.setString(1, this.schlfees);
	       preparedStatement.setString(2, this.libstats);
	       preparedStatement.setString(3, this.stdid);
	      
	      // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data insert successfully!");
	            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }}
	 
		public static ResultSet viewData() {
	        String host = "jdbc:mysql://localhost/graduate_student_management";
	        String user = "root";
	        String password = "";

	        String sql = "SELECT * FROM financial_issues_info";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	public void update(int inputfininfoid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/graduate_student_management";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE financial_issues_info SET school_fees=?,	library_status=?,	student_id=? WHERE financial_info_id	=?";

	    try (   
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	          stm.setString(1, this.getSchlfees());
	          stm.setString(2, this.getLibstats());
	          stm.setString(3, this.getStdid()); // Assuming there is a column named 'id' for the WHERE clause
	         
		      stm.setInt(4, inputfininfoid);
	         
	          // Execute the update
	        int rowsAffected = stm.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data updated successfully!");
	            JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to update data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }   
	}
	public void delete(int inputfininfoid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/graduate_student_management";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM project_research_info WHERE financial_info_id	=?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputfininfoid); // Assuming there is a column named 'id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = pl.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data deleted successfully!");
	            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
	}
}





