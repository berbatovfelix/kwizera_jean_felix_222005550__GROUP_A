package entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
public class vehicle {
	private int vehicle_id;
	private String vehicle_name;
	private String prake_name;
	
	public vehicle() {}
	public vehicle(int vehicle_id, String vehicle_name, String prake_name) {
		super();
		this.vehicle_id = vehicle_id;
		this.vehicle_name = vehicle_name;
		this.prake_name = prake_name;
		
		
	}


	public vehicle( String vehicle_name, String prake_name, String fuel_type) {
		this.vehicle_name = vehicle_name;
		this.prake_name = prake_name;
	

	}

	public int getvehicle_id() {
		return vehicle_id;
	}
	public void setvehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	public String getvehicle_name() {
		return vehicle_name;
	}
	public void setvehicle_name(String vehicle_name) {
		this.vehicle_name = vehicle_name;
	}
	public String getprake_name() {
		return prake_name;
	}
	public void setprake_name(String prake_name) {
		this.prake_name = prake_name;
	}



	public void makeconnnection() throws SQLException {
		
	}
	public void insertData(String vehicle_name,String adre, String type,String phon) {
		// JDBC URL, vehiclevehicle_name, and password of MySQL server
	    String host = "jdbc:mysql://localhost/kwizera_jean_felix_222005550";
	    String vehicle = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO vehicle (prake_name,vehicle_name, fuel_type) VALUES (?, ?, ?)";

	    try (
	        // Establish the connnection
	        Connection conn = DriverManager.getConnection(host, vehicle, password);

	        // Create a prepared statement
	        PreparedStatement vehicle1= conn.prepareStatement(sql);
	    ) {
	        // Set the values for the prepared statement
	       vehicle1.setString(1, vehicle_name);
	        vehicle1.setString(2, prake_name);
	        
	        // Execute the query
	        int rowsAffected = vehicle1.executeUpdate();

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
		// JDBC URL, vehiclevehicle_name, and password of MySQL server
	    String host = "jdbc:mysql://localhost/kwizera_jean_felix_222005550";
	    String vehicle = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO customer (vehicle_name,prake_name,fuel_type) VALUES (?, ?, ?)";

	    try (
	        // Establish the connection
	        Connection conn = DriverManager.getConnection(host, vehicle, password);

	        // Create a prepared statement
	        PreparedStatement vehicle1= conn.prepareStatement(sql);
	    ) {
	        // Set the values for the prepared statement
	       vehicle1.setString(1, this.vehicle_name);
	        vehicle1.setString(2, this.prake_name);
	       
	        
	        // Execute the query
	        int rowsAffected = vehicle1.executeUpdate();

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

	public void readwithvehicle_id(int inputcustomervehicle_id) {
		// JDBC URL, vehiclevehicle_name, and password of MySQL server
	    String url = "jdbc:mysql://localhost/kwizera_jean_felix_222005550";
	    String vehicle = "root";
	    String password = "";

	    // SQL query to select all columns from customer where vehicle_id = ?
	    String sql = "SELECT * FROM vehicle WHERE vehicle_id = ?";

	    try (
	        // Establish the connection
	        Connection connnection = DriverManager.getConnection(url, vehicle, password);

	        // Create a prepared statement
	        PreparedStatement preparedStatement = connnection.prepareStatement(sql);
	    ) {
	        // Set the value for the parameterized query
	        //int customervehicle_id = 1; // Replace with the desired customer vehicle_id
	        //if()
	    	preparedStatement.setInt(1, vehicle_id);

	        // Execute the query and get the result set
	        ResultSet resultSet = preparedStatement.executeQuery();

	        // Process the result set
	        while (resultSet.next()) {
	        	this.setvehicle_id(resultSet.getInt("vehicle_id"));
	           this.setvehicle_name(resultSet.getString("prake_name"));
	           this.setprake_name(resultSet.getString("vehicle_name"));
	          
	           
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void update(int inputvehicle_id) {
		// JDBC URL, vehiclevehicle_name, and password of MySQL server
	    String url = "jdbc:mysql://localhost/kwizera_jean_felix_222005550";
	    String vehicle = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE vehicle SET prake_name = ?,vehicle_name = ?,fuel_type = ? WHERE vehicle_id = ?";

	    try (
	        // Establish the conn
	        Connection conn = DriverManager.getConnection(url, vehicle, password);

	        // Create a prepared statement
	        PreparedStatement vehicle1 = conn.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	        vehicle1.setString(1, this.getvehicle_name());
	        vehicle1.setString(2, this.getprake_name());
	       
	       
	        vehicle1.setInt(7, vehicle_id);
	        // Execute the update
	        int rowsAffected = vehicle1.executeUpdate();

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

	public void delete(int inputcustomervehicle_id) {
		// JDBC URL, vehiclevehicle_name, and password of MySQL server
	    String url = "jdbc:mysql://localhost/kwizera_jean_felix_222005550";
	    String vehicle = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM customer WHERE vehicle_id = ?";

	    try (
	        // Establish the conn
	        Connection conn = DriverManager.getConnection(url, vehicle, password);

	        // Create a prepared statement
	        PreparedStatement vehicle1 = conn.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        vehicle1.setInt(1, vehicle_id); // Assuming there is a column vehicle_named 'vehicle_id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = vehicle1.executeUpdate();

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
