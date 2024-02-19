package entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
public class driver {
private int driver_id;
private String first_name;
private String last_name;
private String phone;
private String licence_number;
private String vehicle_id;
public driver() {}
public driver(int driver_id, String first_name, String last_name, String phone, String licence_number, String vehicle_id) {
    super();
    this.driver_id = driver_id;
    this.first_name = first_name;
    this.last_name = last_name;
    this.phone = phone;
    this.licence_number = licence_number;
    this.vehicle_id = vehicle_id;
}



public int getDriver_id() {
	return driver_id;
}
public void setDriver_id(int driver_id) {
	this.driver_id = driver_id;
}
public String getFirst_name() {
	return first_name;
}
public void setFirst_name(String first_name) {
	this.first_name = first_name;
}
public String getLast_name() {
	return last_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getLicence_number() {
	return licence_number;
}
public void setLicence_number(String licence_number) {
	this.licence_number = licence_number;
}
public String getVehicle_id() {
	return vehicle_id;
}
public void setVehicle_id(String vehicle_id) {
	this.vehicle_id = vehicle_id;
}
public driver( String first_name, String last_name, String phone, String licence_number,String vehicle_id) {
	this.first_name = first_name;
	this.last_name = last_name;
	this.phone = phone;
this.licence_number = licence_number;
this.vehicle_id =vehicle_id;
}

public void insertData(String f_n,String l_n, String phone,String licence_number,String vehicle_id) {
	// JDBC URL, driverfirst_name, and password of MySQL server
    String host = "jdbc:mysql://localhost/kwizera_jean_felix_fdamp";
    String driver = "222005550";
    String password = "222005550";

    // SQL query to insert data
    String sql = "INSERT INTO driver (first_name, first_name, phone, licence_number, vehicle_id) VALUES (?, ?,?, ?, ?)";

    try (
        // Establish the connnection
        Connection conn = DriverManager.getConnection(host, driver, password);

        // Create a prepared statement
        PreparedStatement driver1= conn.prepareStatement(sql);
    ) {
        // Set the values for the prepared statement
       driver1.setString(1, f_n);
        driver1.setString(2, l_n);
        driver1.setString(3, phone);
        driver1.setString(4,licence_number );
        driver1.setString(5, vehicle_id);
        

        // Execute the query
        int rowsAffected = driver1.executeUpdate();

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
	String host = "jdbc:mysql://localhost/kwizera_jean_felix_fdamp";
	String driver = "222005550";
	String password = "222005550";

    // SQL query to insert data
    String sql = "INSERT INTO driver (first_name, last_name, phone, licence_number, vehicle_id) VALUES (?, ?,?, ?, ?)";
    try (
        // Establish the connnection
        Connection conn = DriverManager.getConnection(host, driver, password);

        // Create a prepared statement
        PreparedStatement driver1= conn.prepareStatement(sql);
    ) {
        // Set the values for the prepared statement
       driver1.setString(1, this.first_name);
        driver1.setString(2, this.last_name);
        driver1.setString(3, this.phone);
        driver1.setString(4, this.licence_number);
        driver1.setString(5, this.vehicle_id);
        

        // Execute the query
        int rowsAffected = driver1.executeUpdate();

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

public void readwithdriver_id(int inputdriver_id) {
	// JDBC URL, driverfirst_name, and password of MySQL server
    String url = "jdbc:mysql://localhost/kwizera_jean_felix_fdamp";
    String driver = "222005550";
    String password = "222005550";

    // SQL query to select all columns from customer where driver_id = ?
    String sql = "SELECT * FROM driver WHERE driver_id = ?";

    try (
        // Establish the connection
        Connection connnection = DriverManager.getConnection(url, driver, password);

        // Create a prepared statement
        PreparedStatement preparedStatement = connnection.prepareStatement(sql);
    ) {
        // Set the value for the parameterized query
        //int customerdriver_id = 1; // Replace with the desired customer driver_id
        //if()
    	preparedStatement.setInt(1, inputdriver_id);

        // Execute the query and get the result set
        ResultSet resultSet = preparedStatement.executeQuery();

        // Process the result set
        while (resultSet.next()) {
        	this.setDriver_id(resultSet.getInt("driver_id"));
           this.setFirst_name(resultSet.getString("first_name"));
           this.setLast_name(resultSet.getString("last_name"));
           this.setLicence_number(resultSet.getString("phone"));
            this.setPhone(resultSet.getString("licence_number"));
            this.setVehicle_id(resultSet.getString("vehicle_id"));
            
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
public void update(int inputdriver_id) {
    // JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/kwizera_jean_felix_fdamp";
    String username = "222005550";
    String password = "222005550";

    // SQL query to update data
    String sql = "UPDATE driver SET first_name = ?, last_name = ?, phone = ?, licence_number = ?, vehicle_id = ? WHERE driver_id= ?";

    try (
        // Establish the connection
        Connection connection = DriverManager.getConnection(url, username, password);

        // Create a prepared statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ) {
        // Set the new values for the update
        preparedStatement.setString(1, this.getFirst_name());
        preparedStatement.setString(2, this.getLast_name());
        preparedStatement.setString(3, this.getPhone());
        preparedStatement.setString(4, this.getLicence_number());
        preparedStatement.setString(5, this.getVehicle_id());
        
        preparedStatement.setInt(6, inputdriver_id);

        // Execute the update
        int rowsAffected = preparedStatement.executeUpdate();

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
public void delete(int inputdriver_id) {
    // JDBC URL, driverfirst_name, and password of MySQL server
    String url = "jdbc:mysql://localhost/kwizera_jean_felix_fdamp";
    String driver = "222005550";
    String password = "222005550";

    // SQL query to delete data
    String sql = "DELETE FROM driver WHERE driver_id= ?";

    try (
            // Establish the connection
            Connection conn = DriverManager.getConnection(url, driver, password);

            // Create a prepared statement
            PreparedStatement driver1 = conn.prepareStatement(sql);
        ) {
            // Set the value for the WHERE clause
            driver1.setInt(1, inputdriver_id);

            // Execute the delete
            int rowsAffected = driver1.executeUpdate();

            // Check the result
            if (rowsAffected > 0) {
                System.out.println("Data deleted successfully!");
            } else {
                System.out.println("Failed to delete data. No matching record found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
}}
	









