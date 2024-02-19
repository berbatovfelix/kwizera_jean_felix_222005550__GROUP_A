package entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
public class user1 {
	private int user1_id;
	private String first_name;
	private String last_name;
	private String phone_number;
	private String email;
	private String role;

	public user1() {}
	public user1(int user1_id, String fname, String lname, String phone_number, String email,String role) {
		super();
		this.user1_id = user1_id;
		this.first_name = fname;
		this.last_name = lname;
		this.phone_number = phone_number;
		this.email = email;
	
		this.role=role;
		
	}
	
	
	public user1( String first_name, String last_name, String phone_number, String email,String role) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone_number = phone_number;
	this.phone_number = phone_number;
	this.role = role;
	}

	public int getuser1_id() {
		return user1_id;
	}
	public void setuser1_id(int user1_id) {
		this.user1_id = user1_id;
	}
	public String getFname() {
		return first_name;
	}
	public void setFname(String fname) {
		this.first_name = fname;
	}
	public String getLname() {
		return last_name;
	}
	public void setLname(String lname) {
		this.last_name = lname;
	}
	public String getphone_number() {
		return phone_number;
	}
	public void setphone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getrole() {
		return role;
	}
	public void setrole(String role) {
		this.role = role;
	}
	public void makeconnnection() {
		
	}
	public void insertData(String f_name,String l_name, String phone_number,String email,String role) {
		// JDBC URL, user1name, and password of MySQL server
	    String host = "jdbc:mysql://localhost/kwizera_jean_felix_fdamp";
	    String user1 = "222005550";
	    String password = "222005550";

	    // SQL query to insert data
	    String sql = "INSERT INTO user1 (first_name, last_name, phone_number, email, role) VALUES (?, ?, ?, ?, ?)";

	    try (
	        // Establish the connection
	        Connection conn = DriverManager.getConnection(host, user1, password);

	        // Create a prepared statement
	        PreparedStatement user11= conn.prepareStatement(sql);
	    ) {
	        // Set the values for the prepared statement
	      user11.setString(1, first_name);
	       user11.setString(2, last_name);
	       user11.setString(3, phone_number);
	       user11.setString(4, email);
	       user11.setString(5, role);
	    

	        // Execute the query
	        int rowsAffected =user11.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data inserted successfully!");
	            JOptionPane.showMessageDialog(null, "Data inserted successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to insert data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }	
	}

	public void insertData() {
		// JDBC URL, user1name, and password of MySQL server
	    String host = "jdbc:mysql://localhost/kwizera_jean_felix_fdamp";
	    String user1 = "222005550";
	    String password = "222005550";

	    // SQL query to insert data
	    String sql = "INSERT INTO user1 ( first_name, last_name, phone_number, email, role) VALUES (?, ?, ?, ?, ?)";

	    try (
	        // Establish the connection
	        Connection conn = DriverManager.getConnection(host, user1, password);

	        // Create a prepared statement
	        PreparedStatement user11= conn.prepareStatement(sql);
	    ) {
	        // Set the values for the prepared statement
	      user11.setString(1, this.first_name);
	       user11.setString(2, this.last_name);
	       user11.setString(3, this.phone_number);
	       user11.setString(4, this.email);
	       user11.setString(5, this.role);
	        

	        // Execute the query
	        int rowsAffected =user11.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data inserted successfully!");
	            JOptionPane.showMessageDialog(null, "Data inserted successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to insert data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }	
	}

	public void readWithuser1Id(int inputuser1Id) {
	    // JDBC URL, user1name, and password of MySQL server
	    String url = "jdbc:mysql://localhost/kwizera_jean_felix_fdamp";
	    String user1 = "222005550";
	    String password = "222005550";

	    // SQL query to select all columns from user1 where user1_id = ?
	    String sql = "SELECT * FROM user1 WHERE user1_id = ?";

	    try (
	        // Establish the connection
	        Connection connection = DriverManager.getConnection(url, user1, password);

	        // Create a prepared statement
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    ) {
	        // Set the value for the parameterized query
	        preparedStatement.setInt(1, inputuser1Id);

	        // Execute the query and get the result set
	        ResultSet resultSet = preparedStatement.executeQuery();

	        // Process the result set
	        if (resultSet.next()) {
	            this.setuser1_id(resultSet.getInt("user1_id"));
	            this.setFname(resultSet.getString("first_name"));
	            this.setLname(resultSet.getString("last_name"));
	            this.setphone_number(resultSet.getString("phone_number"));
	            this.setemail(resultSet.getString("email"));
	            this.setrole(resultSet.getString("role"));
	        } else {
	            System.out.println("No user1 found with the given user1_id.");
	            // You might want to handle this case appropriately, e.g., show a message to the user1.
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void update(int inputuser1_id) {
		// JDBC URL, user1name, and password of MySQL server
	    String url = "jdbc:mysql://localhost/kwizera_jean_felix_fdamp";
	    String user1 = "222005550";
	    String password = "222005550";

	    // SQL query to update data
	    String sql = "UPDATE user1 SET first_name = ?, last_name = ?, phone_number = ?, email = ?, role = ? WHERE user1_id = ?";


	    try (
	        // Establish the conn
	        Connection conn = DriverManager.getConnection(url, user1, password);

	        // Create a prepared statement
	        PreparedStatement user11 = conn.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	user11.setString(1, this.getFname());
	    	user11.setString(2, this.getLname());
	    	user11.setString(3, this.getphone_number());
	    	user11.setString(4, this.getemail());
	    	user11.setString(5, this.getrole());
	    	user11.setInt(6, inputuser1_id);
	        // Execute the update
	        int rowsAffected =user11.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data updated successfully!");
	        } else {
	            System.out.println("Failed to update data. No matching record found.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }   
	}

	public void delete(int inputuser1_id) {
		// JDBC URL, user1name, and password of MySQL server
	    String url = "jdbc:mysql://localhost/kwizera_jean_felix_fdamp";
	    String user1 = "222005550";
	    String password = "222005550";

	    // SQL query to delete data
	    String sql = "DELETE FROM user1 WHERE user1_id = ?";

	    try (
	        // Establish the conn
	    		Connection conn = DriverManager.getConnection(url, user1, password);

	        // Create a prepared statement
	        PreparedStatement user11 = conn.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	       user11.setInt(1, inputuser1_id); // Assuming there is a column named 'user1_id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = user11.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data deleted successfully!");
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


}
