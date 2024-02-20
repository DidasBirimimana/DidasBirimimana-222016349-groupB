package MyAllEntities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class CourseInfo {
//course_id	student_id	course_title	department	credits_number	semester_offered	grade
	private int crsid;
	private String 	stdid;
	private String 	crstittle;
	private String dprtmnt;
	private String crdtnmbr;
	private String smstroffrd;
	private String grade;
	
	public CourseInfo() {
	    // Default constructor
      }
	public CourseInfo(int crsid, String stdid,String crstittle, String dprtmnt,String crdtnmbr,String smstroffrd,String  grade) {
		super();
		this.crsid=crsid;
		this.stdid=stdid;
		this.crstittle=crstittle;
		this.dprtmnt=dprtmnt;
		this.crdtnmbr=crdtnmbr;
		this.smstroffrd=smstroffrd;
		this. grade= grade;
		}
	
	public int getCrsid() {
		return crsid;
	}
	public void setCrsid(int crsid) {
		this.crsid = crsid;
	}
	public String getStdid() {
		return stdid;
	}
	public void setStdid(String stdid) {
		this.stdid = stdid;
	}
	public String getCrstittle() {
		return crstittle;
	}
	public void setCrstittle(String crstittle) {
		this.crstittle = crstittle;
	}
	public String getDprtmnt() {
		return dprtmnt;
	}
	public void setDprtmnt(String dprtmnt) {
		this.dprtmnt = dprtmnt;
	}
	public String getCrdtnmbr() {
		return crdtnmbr;
	}
	public void setCrdtnmbr(String crdtnmbr) {
		this.crdtnmbr = crdtnmbr;
	}
	public String getSmstroffrd() {
		return smstroffrd;
	}
	public void setSmstroffrd(String smstroffrd) {
		this.smstroffrd = smstroffrd;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public void makeconnection() {
	}
		public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/graduate_student_management";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO course_info(student_id,	course_title,	department,	credits_number,	semester_offered,	grade) VALUES (?,?,?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       //preparedStatement.setString(1, this.actid);
	     
	       preparedStatement.setString(1, this.stdid);
	       preparedStatement.setString(2, this.crstittle);
	       preparedStatement.setString(3, this.dprtmnt);
	       preparedStatement.setString(4, this.crdtnmbr);
	       preparedStatement.setString(5, this.smstroffrd);
	       preparedStatement.setString(6, this.grade);
	      
			
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

	        String sql = "SELECT * FROM course_info";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	public void update(int inputcrsid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/graduate_student_management";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE course_info SET student_id=?,	course_title=?,	department=?,	credits_number=?,	semester_offered=?,	grade=? WHERE course_id	=?";

	    try (   
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	          stm.setString(1, this.getStdid());
	          stm.setString(2, this.getCrstittle());
	          stm.setString(3, this.getDprtmnt()); // Assuming there is a column named 'id' for the WHERE clause
	          stm.setString(4, this.getCrdtnmbr());
	          stm.setString(5, this.getSmstroffrd());
	          stm.setString(6, this.getGrade());
	          
	          stm.setInt(7, inputcrsid);
	          
	         
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
	public void delete(int inputcrsid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/graduate_student_management";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM course_info WHERE course_id	=?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputcrsid); // Assuming there is a column named 'id' for the WHERE clause

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



