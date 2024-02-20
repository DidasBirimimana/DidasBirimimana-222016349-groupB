package MyAllEntities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ProjectResearchInfo {//	project_id	project_name	project_purpose	student_id	project_invigilator_name	
	
			private int prjctid;
			private String 	prjctname;
			private String 	prjctprpse;
			private String stdid;
			private String prjctinvgltrname;
			
			public ProjectResearchInfo() {
			    // Default constructor
		      }
			public ProjectResearchInfo(int prjctid, String prjctname,String prjctprpse, String stdid,String prjctinvgltrname) {
				super();
				this.prjctid=prjctid;
				this.prjctname=prjctname;
				this.prjctprpse=prjctprpse;
				this.stdid=stdid;
				this.prjctinvgltrname=prjctinvgltrname;
				}
			
			public int getPrjctid() {
				return prjctid;
			}
			public void setPrjctid(int prjctid) {
				this.prjctid = prjctid;
			}
			public String getPrjctname() {
				return prjctname;
			}
			public void setPrjctname(String prjctname) {
				this.prjctname = prjctname;
			}
			public String getPrjctprpse() {
				return prjctprpse;
			}
			public void setPrjctprpse(String prjctprpse) {
				this.prjctprpse = prjctprpse;
			}
			public String getStdid() {
				return stdid;
			}
			public void setStdid(String stdid) {
				this.stdid = stdid;
			}
			public String getPrjctinvgltrname() {
				return prjctinvgltrname;
			}
			public void setPrjctinvgltrname(String prjctinvgltrname) {
				this.prjctinvgltrname = prjctinvgltrname;
			}
			public void makeconnection() {
			}
				public void insertData() {
				// JDBC URL, username, and password of MySQL server
			    String host = "jdbc:mysql://localhost/graduate_student_management";
			    String user = "root";
			    String password = "";

			    // SQL query to insert data
			    String sql = "INSERT INTO project_research_info(project_name,	project_purpose,	student_id,	project_invigilator_name) VALUES (?,?,?,?)";
				
			    try (
			        // Establish the connection
			        Connection con = DriverManager.getConnection(host, user, password);

			        // Create a prepared statement
			    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
			    	    ) {
			        // Set the values for the prepared statement
			       //preparedStatement.setString(1, this.actid);
			     
			       preparedStatement.setString(1, this.prjctname);
			       preparedStatement.setString(2, this.prjctprpse);
			       preparedStatement.setString(3, this.stdid);
			       preparedStatement.setString(4, this.prjctinvgltrname);
			      
					
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

			        String sql = "SELECT * FROM project_research_info";

			        try {
			            Connection con = DriverManager.getConnection(host, user, password);
			            PreparedStatement preparedStatement = con.prepareStatement(sql);
			            return preparedStatement.executeQuery();
			        } catch (SQLException e) {
			            e.printStackTrace();
			            return null;
			        }
			    }

			public void update(int inputprjctid) {
				// JDBC URL, username, and password of MySQL server
			    String url = "jdbc:mysql://localhost/graduate_student_management";
			    String user = "root";
			    String password = "";

			    // SQL query to update data
			    String sql = "UPDATE project_research_info SET project_name=?,	project_purpose=?,	student_id=?,	project_invigilator_name=? WHERE project_id	=?";

			    try (   
			        // Establish the con
			        Connection con = DriverManager.getConnection(url, user, password);

			        // Create a prepared statement
			        PreparedStatement stm = con.prepareStatement(sql);
			    ) {
			        // Set the new values for the update
			    	  
			          stm.setString(1, this.getPrjctname());
			          stm.setString(2, this.getPrjctprpse());
			          stm.setString(3, this.getStdid()); // Assuming there is a column named 'id' for the WHERE clause
			          stm.setString(4, this.getPrjctinvgltrname());
			          
				      stm.setInt(5, inputprjctid);
			          
			         
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
			public void delete(int inputprjctid) {
				// JDBC URL, username, and password of MySQL server
			    String url = "jdbc:mysql://localhost/graduate_student_management";
			    String user = "root";
			    String password = "";

			    // SQL query to delete data
			    String sql = "DELETE FROM project_research_info WHERE project_id	=?";

			    try (
			        // Establish the 
			        Connection con= DriverManager.getConnection(url, user, password);

			        // Create a prepared statement
			        PreparedStatement pl = con.prepareStatement(sql);
			    ) {
			        // Set the value for the WHERE clause
			        pl.setInt(1, inputprjctid); // Assuming there is a column named 'id' for the WHERE clause

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




