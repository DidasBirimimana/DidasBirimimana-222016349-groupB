package MyAllEntities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ApplicantInfo {//applicant_info_id	father_name	mother_name	email	phone	address	age	
	private int aplinfoid;
	private String 	fathername;
	private String 	mothername;
	private String email;
	private String phnenmbr;
	private String address;
	private String age;
	
	public ApplicantInfo() {
	    // Default constructor
      }
	public ApplicantInfo(int aplinfoid, String fathername,String mothername, String email,String phnenmbr,String address,String age) {
		super();
		this.aplinfoid=aplinfoid;
		this.fathername=fathername;
		this.mothername= mothername;
		this.email=email;
		this.phnenmbr=phnenmbr;
		this.address=address;
		this.age=age;
		}
	
	public int getAplinfoid() {
		return aplinfoid;
	}
	public void setAplinfoid(int aplinfoid) {
		this.aplinfoid = aplinfoid;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public String getMothername() {
		return mothername;
	}
	public void setMothername(String mothername) {
		this.mothername = mothername;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhnenmbr() {
		return phnenmbr;
	}
	public void setPhnenmbr(String phnenmbr) {
		this.phnenmbr = phnenmbr;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public void makeconnection() {
	}
		public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/graduate_student_management";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO applicant_info(	father_name,	mother_name,	email,	phone,	address,	age	) VALUES (?,?,?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       //preparedStatement.setString(1, this.actid);
	     
	       preparedStatement.setString(1, this.fathername);
	       preparedStatement.setString(2, this.mothername);
	       preparedStatement.setString(3, this.email);
	       preparedStatement.setString(4, this.phnenmbr);
	       preparedStatement.setString(5, this.address);
	       preparedStatement.setString(6, this.age);
	       
	      
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

	        String sql = "SELECT * FROM applicant_info";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	public void update(int inputaplinfoid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/graduate_student_management";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE applicant_info SET father_name=?,	mother_name=?,	email=?,	phone=?,	address=?,	age=? WHERE applicant_info_id=?";

	    try (   
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	          stm.setString(1, this.getFathername());
	          stm.setString(2, this.getMothername());
	         // Assuming there is a column named 'id' for the WHERE clause
	          stm.setString(3, this.getEmail());
	          stm.setString(4, this.getPhnenmbr());
	          stm.setString(5, this.getAddress());
	          stm.setString(6, this.getAge()); 
	          
	          stm.setInt(7, inputaplinfoid);
	         
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
	public void delete(int inputaplinfoid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/graduate_student_management";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM applicant_info WHERE applicant_info_id=?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputaplinfoid); // Assuming there is a column named 'id' for the WHERE clause

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




