package MyAllEntities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Student {//	student_id	first_name	last_name	date_of_birth	email	phone_number	gender	
	private int stdid;
	private String 	fnme;
	private String 	lnme;
	private String dob;
	private String email;
	private String phnenmbr;
	private String gender;
	
	public Student() {
	    // Default constructor
      }
	public Student(int stdid, String fnme,String lnme, String dob,String email,String phnenmbr,String gender) {
		super();
		this.stdid=stdid;
		this.fnme=fnme;
		this.lnme=lnme;
		this.dob=dob;
		this.email=email;
		this.phnenmbr=phnenmbr;
		this.gender=gender;
		}
	
	public int getStdid() {
		return stdid;
	}
	public void setStdid(int stdid) {
		this.stdid = stdid;
	}
	public String getFnme() {
		return fnme;
	}
	public void setFnme(String fnme) {
		this.fnme = fnme;
	}
	public String getLnme() {
		return lnme;
	}
	public void setLnme(String lnme) {
		this.lnme = lnme;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void makeconnection() {
	}
		public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/graduate_student_management";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO student(first_name,	last_name,	date_of_birth,	email,	phone_number, gender) VALUES (?,?,?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       //preparedStatement.setString(1, this.actid);
	     
	       preparedStatement.setString(1, this.fnme);
	       preparedStatement.setString(2, this.lnme);
	       preparedStatement.setString(3, this.dob);
	       preparedStatement.setString(4, this.email);
	       preparedStatement.setString(5, this.phnenmbr);
	       preparedStatement.setString(6, this.gender);
	       
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

	        String sql = "SELECT * FROM student";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	public void update(int inputstdid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/graduate_student_management";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE student SET first_name=?,	last_name=?,	date_of_birth=?,	email=?,	phone_number=?, gender=? WHERE student_id	=?";

	    try (   
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	          stm.setString(1, this.getFnme());
	          stm.setString(2, this.getLnme());
	          stm.setString(3, this.getDob()); // Assuming there is a column named 'id' for the WHERE clause
	          stm.setString(4, this.getEmail());
	          stm.setString(5, this.getPhnenmbr());
	          stm.setString(6, this.getGender());
	          
	          stm.setInt(7, inputstdid);

	         
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
	public void delete(int inputstdid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/graduate_student_management";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM student WHERE student_id =?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputstdid); // Assuming there is a column named 'id' for the WHERE clause

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


