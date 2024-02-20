package MyAllEntities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class SemesterInfo {//semester_info_id	start_date	ending_date	student_id	semester_code	total_number_of_modules	failed_modules	
	
			private int smstinfoid;
			private String 	strtdate;
			private String enddate;
			private String stdid;
			private String smstcode;
			private String totnmbrmdls;
			private String failedmdls;
			
			public SemesterInfo() {
			    // Default constructor
		      }
			public SemesterInfo(int smstinfoid,String strtdate,String enddate, String stdid, String smstcode,String totnmbrmdls,String  failedmdls) {
				super();
				this.smstinfoid=smstinfoid;
				this.strtdate=strtdate;
				this.enddate=enddate;
				this.stdid=stdid;
				this.smstcode=smstcode;
				this.totnmbrmdls=totnmbrmdls;
				this.failedmdls=failedmdls;
				}
			
			public int getSmstinfoid() {
				return smstinfoid;
			}
			public void setSmstinfoid(int smstinfoid) {
				this.smstinfoid = smstinfoid;
			}
			public String getStrtdate() {
				return strtdate;
			}
			public void setStrtdate(String strtdate) {
				this.strtdate = strtdate;
			}
			public String getEnddate() {
				return enddate;
			}
			public void setEnddate(String enddate) {
				this.enddate = enddate;
			}
			public String getStdid() {
				return stdid;
			}
			public void setStdid(String stdid) {
				this.stdid = stdid;
			}
			public String getSmstcode() {
				return smstcode;
			}
			public void setSmstcode(String smstcode) {
				this.smstcode = smstcode;
			}
			public String getTotnmbrmdls() {
				return totnmbrmdls;
			}
			public void setTotnmbrmdls(String totnmbrmdls) {
				this.totnmbrmdls = totnmbrmdls;
			}
			public String getFailedmdls() {
				return failedmdls;
			}
			public void setFailedmdls(String failedmdls) {
				this.failedmdls = failedmdls;
			}
			public void makeconnection() {
			}
				public void insertData() {
				// JDBC URL, username, and password of MySQL server
			    String host = "jdbc:mysql://localhost/graduate_student_management";
			    String user = "root";
			    String password = "";

			    // SQL query to insert data
			    String sql = "INSERT INTO semester_info(start_date,	ending_date,	student_id,	semester_code,	total_number_of_modules,	failed_modules	) VALUES (?,?,?,?,?,?)";
				
			    try (
			        // Establish the connection
			        Connection con = DriverManager.getConnection(host, user, password);

			        // Create a prepared statement
			    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
			    	    ) {
			        // Set the values for the prepared statement
			       //preparedStatement.setString(1, this.actid);
			     
			       preparedStatement.setString(1, this.strtdate);
			       preparedStatement.setString(2, this.enddate);
			       preparedStatement.setString(3, this.stdid);
			       preparedStatement.setString(4, this.smstcode);
			       preparedStatement.setString(5, this.totnmbrmdls);
			       preparedStatement.setString(6, this.failedmdls);
			      
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

			        String sql = "SELECT * FROM semester_info";

			        try {
			            Connection con = DriverManager.getConnection(host, user, password);
			            PreparedStatement preparedStatement = con.prepareStatement(sql);
			            return preparedStatement.executeQuery();
			        } catch (SQLException e) {
			            e.printStackTrace();
			            return null;
			        }
			    }

			public void update(int inputsmstinfoid) {
				// JDBC URL, username, and password of MySQL server
			    String url = "jdbc:mysql://localhost/graduate_student_management";
			    String user = "root";
			    String password = "";

			    // SQL query to update data
			    String sql = "UPDATE semester_info SET start_date=?,	ending_date=?,	student_id=?,	semester_code=?,	total_number_of_modules=?,	failed_modules=? WHERE semester_info_id=?";

			    try (   
			        // Establish the con
			        Connection con = DriverManager.getConnection(url, user, password);

			        // Create a prepared statement
			        PreparedStatement stm = con.prepareStatement(sql);
			    ) {
			        // Set the new values for the update
			    	  
			         
			          stm.setString(1, this.getStrtdate());
			          stm.setString(2, this.getEnddate()); // Assuming there is a column named 'id' for the WHERE clause
			          stm.setString(3, this.getStdid());
			          stm.setString(4, this.getSmstcode());
			          stm.setString(5, this.getTotnmbrmdls());
			          stm.setString(6, this.getFailedmdls());
			          
			          stm.setInt(7, inputsmstinfoid);
			          

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
			public void delete(int inputsmstinfoid) {
				// JDBC URL, username, and password of MySQL server
			    String url = "jdbc:mysql://localhost/graduate_student_management";
			    String user = "root";
			    String password = "";

			    // SQL query to delete data
			    String sql = "DELETE FROM semester_info WHERE semester_info_id=?";

			    try (
			        // Establish the 
			        Connection con= DriverManager.getConnection(url, user, password);

			        // Create a prepared statement
			        PreparedStatement pl = con.prepareStatement(sql);
			    ) {
			        // Set the value for the WHERE clause
			        pl.setInt(1, inputsmstinfoid); // Assuming there is a column named 'id' for the WHERE clause

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




