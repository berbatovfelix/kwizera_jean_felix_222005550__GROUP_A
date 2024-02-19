package entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
public class fuel_station {private int fuelsta_id;
private String name;
private String address;
private String phone;
private String fuel_type;


public fuel_station() {}
public fuel_station(int fuelsta_id, String name, String address, String phone, String fuel_type) {
	super();
	this.fuelsta_id = fuelsta_id;
	this.name = name;
	this.address = address;
	this.phone =phone;
	this.fuel_type = fuel_type;
	

	
	
}


public fuel_station( String name, String address, String fuel_type, String phone,String routing_number) {
	this.name = name;
	this.address = address;
	this.phone =phone;
	this.fuel_type = fuel_type;


}

public int getfuelsta_id() {
	return fuelsta_id;
}
public void setfuelsta_id(int fuelsta_id) {
	this.fuelsta_id = fuelsta_id;
}
public String getname() {
	return name;
}
public void setname(String name) {
	this.name = name;
}
public String getaddress() {
	return address;
}
public void setaddress(String address) {
	this.address = address;

}

public String getphone() {
	return phone;
}
public void setphone(String phone) {
	this.phone =phone;
}
public String getfuel_type() {
	return fuel_type;
}
public void setfuel_type(String fuel_type) {
	this.fuel_type = fuel_type;
}


public void makeconnnection() {
	
}
public void insertData(String name,String adre, String type,String phon) {
	// JDBC URL, fuel_stationname, and password of MySQL server
    String host = "jdbc:mysql://localhost/kwizera_jean_felix_fdamp";
    String fuel_station = "222005550";
    String password = "222005550";

    // SQL query to insert data
    String sql = "INSERT INTO fuel_station (name,address, phone,fuel_type) VALUES (?,?,?,?)";

    try (
        // Establish the connnection
        Connection conn = DriverManager.getConnection(host, fuel_station, password);

        // Create a prepared statement
        PreparedStatement fuel_station1= conn.prepareStatement(sql);
    ) {
        // Set the values for the prepared statement
       fuel_station1.setString(1, name);
        fuel_station1.setString(2, address);
        fuel_station1.setString(3, phone);
        fuel_station1.setString(4, fuel_type);
        

        // Execute the query
        int rowsAffected = fuel_station1.executeUpdate();

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
	// JDBC URL, fuel_stationname, and password of MySQL server
    String host = "jdbc:mysql://localhost/kwizera_jean_felix_fdamp";
    String fuel_station = "222005550";
    String password = "222005550";

    // SQL query to insert data
    String sql = "INSERT INTO fuel_station (name,address, phone,fuel_type) VALUES (?,?,?,?)";

    try (
        // Establish the connection
        Connection conn = DriverManager.getConnection(host, fuel_station, password);

        // Create a prepared statement
        PreparedStatement fuel_station1= conn.prepareStatement(sql);
    ) {
        // Set the values for the prepared statement
       fuel_station1.setString(1, this.name);
        fuel_station1.setString(2, this.address);
        fuel_station1.setString(3, this.phone);
        fuel_station1.setString(4, this.fuel_type);
        
        

        // Execute the query
        int rowsAffected = fuel_station1.executeUpdate();

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

public void readwithfuelsta_id(int inputfuelsta_id) {
	// JDBC URL, fuel_stationname, and password of MySQL server
    String url = "jdbc:mysql://localhost/kwizera_jean_felix_fdamp";
    String fuel_station = "222005550";
    String password = "222005550";

    // SQL query to select all columns from customer where fuelsta_id = ?
    String sql = "SELECT * FROM fuel_station WHERE fuelsta_id = ?";

    try (
        // Establish the connection
        Connection connnection = DriverManager.getConnection(url, fuel_station, password);

        // Create a prepared statement
        PreparedStatement preparedStatement = connnection.prepareStatement(sql);
    ) {
        // Set the value for the parameterized query
        //int customerfuelsta_id = 1; // Replace with the desired customer fuelsta_id
        //if()
    	preparedStatement.setInt(1, inputfuelsta_id);

        // Execute the query and get the result set
        ResultSet resultSet = preparedStatement.executeQuery();

        // Process the result set
        while (resultSet.next()) {
        	this.setfuelsta_id(resultSet.getInt("fuelsta_id"));
           this.setname(resultSet.getString("name"));
           this.setaddress(resultSet.getString("address"));
           this.setphone(resultSet.getString("phone"));
            this.setfuel_type(resultSet.getString("fuel_type"));
            
            
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
public void update(int inputcustomerfuelsta_id) {
	// JDBC URL, fuel_stationname, and password of MySQL server
    String url = "jdbc:mysql://localhost/kwizera_jean_felix_fdamp";
    String fuel_station = "222005550";
    String password = "222005550";

    // SQL query to update data
    String sql = "UPDATE  fuel_station SET name = ?, address = ?,phone = ? WHERE fuelsta_id = ?";

    try (
        // Establish the conn
        Connection conn = DriverManager.getConnection(url, fuel_station, password);

        // Create a prepared statement
        PreparedStatement fuel_station1 = conn.prepareStatement(sql);
    ) {
        // Set the new values for the update
        fuel_station1.setString(1, this.getname());
        fuel_station1.setString(2, this.getaddress());
         // Assuming there is a column named 'fuelsta_id' for the WHERE clause
        fuel_station1.setString(3, this.getphone());
        //fuel_station1.setString(4, this.getfuel_type());
        
       
        fuel_station1.setInt(4, inputcustomerfuelsta_id);
        // Execute the update
        int rowsAffected = fuel_station1.executeUpdate();

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

public void delete(int inputfuelsta_id) {
	// JDBC URL, fuel_stationname, and password of MySQL server
    String url = "jdbc:mysql://localhost/kwizera_jean_felix_fdamp";
    String fuel_station = "222005550";
    String password = "222005550";

    // SQL query to delete data
    String sql = "DELETE FROM  fuel_station WHERE fuelsta_id = ?";

    try (
        // Establish the conn
        Connection conn = DriverManager.getConnection(url, fuel_station, password);

        // Create a prepared statement
        PreparedStatement fuel_station1 = conn.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        fuel_station1.setInt(1, inputfuelsta_id); // Assuming there is a column named 'fuelsta_id' for the WHERE clause

        // Execute the delete
        int rowsAffected = fuel_station1.executeUpdate();

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





