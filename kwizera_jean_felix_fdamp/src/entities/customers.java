package entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
public class customers {
private int customers_id;
private String last_name;
private String  first_name;
private String emai;
private String phone;
private String address;
private String payment_method;
public customers() {}
public customers(int customers_id, String last_name, String  first_name, String emai, String phone,String address,String payment_method) {
	super();
	this.customers_id = customers_id;
	this.last_name = last_name;
	this. first_name =  first_name;
	this.emai = emai;
	this.phone = phone;
	this.address=address;
	this.payment_method=payment_method;
	
}
public void setpayment_method(String object) {
	this.payment_method=object;
}
public String getpayment_method() {
	return payment_method;
}
public customers( String last_name, String  first_name, String emai, String phone,String address) {
	this.last_name = last_name;
	this. first_name =  first_name;
	this.emai = emai;
this.phone = phone;
this.address = address;
}

public int getcustomers_id() {
	return customers_id;
}
public void setcustomers_id1(int customers_id) {
	this.customers_id = customers_id;
}
public String getlast_name() {
	return last_name;
}
public void setlast_name(String last_name) {
	this.last_name = last_name;
}
public String getfirst_name() {
	return  first_name;
}
public void setfirst_name(String  first_name) {
	this. first_name =  first_name;
}
public String getemai() {
	return emai;
}
public void setemai(String emai) {
	this.emai = emai;
}
public String getphone() {
	return phone;
}
public void setphone(String phone) {
	this.phone = phone;
}
public String getaddress() {
	return address;
}
public void setaddress(String address) {
	this.address = address;
}
public void makeconnnection() {
	
}

public void insertDataa() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/kwizera_jean_felix_fdamp";
    String user = "222005550";
    String password = "222005550";

    // SQL query to insert data
    String sql = "INSERT INTO customers (last_name,first_name, emai,phone,address,payment_method) VALUES (?, ?, ?, ?,?,?)";

    try (
        // Establish the connection
        Connection conn = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
        PreparedStatement custm= conn.prepareStatement(sql);
    ) {
        // Set the values for the prepared statement
       custm.setString(1, this.last_name);
        custm.setString(2, this. first_name);
        custm.setString(3, this.emai);
        custm.setString(4, this.phone);
        custm.setString(5, this.address);
        custm.setString(6, this.payment_method);

        // Execute the query
        int rowsAffected = custm.executeUpdate();

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

public void readwithcustomers_id(int inputcustomers_id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/kwizera_jean_felix_fdamp";
    String user = "222005550";
    String password = "222005550";

    // SQL query to select all columns from customers where customers_id = ?
    String sql = "SELECT * FROM customers WHERE customers_id = ?";

    try (
        // Establish the connnection
        Connection connnection = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement preparedStatement = connnection.prepareStatement(sql);
    ) {
        // Set the value for the parameterized query
        //int  customers_id = 1; // Replace with the desired customers customers_id
        //if()
    	preparedStatement.setInt(1, inputcustomers_id);

        // Execute the query and get the result set
        ResultSet resultSet = preparedStatement.executeQuery();

        // Process the result set
        while (resultSet.next()) {
        	this.setcustomers_id1(resultSet.getInt("customers_id"));
           this.setlast_name(resultSet.getString("last_name"));
           this.setfirst_name(resultSet.getString("first_name"));
           this.setemai(resultSet.getString("emai"));
            this.setphone(resultSet.getString("phone"));
            this.setpayment_method(resultSet.getString("payment_method"));
            this. setaddress(resultSet.getString("address"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
} 
public void update1(int inputcustomers_id) {
    // JDBC URL, fuel_delivery_app_management_project, and password of MySQL server
    String url = "jdbc:mysql://localhost/kwizera_jean_felix_fdamp";
    String user = "222005550";
    String password = "222005550";

    // SQL query to update data
    String sql = "UPDATE customers SET last_name = ?, first_name = ?, emai = ?, phone = ?, address = ?, payment_method = ? WHERE customers_id = ?";

    try (
        // Establish the conn
        Connection conn = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement custm = conn.prepareStatement(sql);
    ) {
        // Set the new values for the update
        custm.setString(1, this.getlast_name());
        custm.setString(2, this.getfirst_name());
        custm.setString(3, this.getemai());
        custm.setString(4, this.getphone());
        custm.setString(5, this.getaddress());

        // Set the payment_method field
        custm.setString(6, this.getpayment_method());

        custm.setInt(7, inputcustomers_id);


        // Execute the update
        int rowsAffected = custm.executeUpdate();

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
public void delete(int inputcustomers_id) {
    // JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/kwizera_jean_felix_fdamp";
    String user = "222005550";
    String password = "222005550";

    // SQL query to delete data
    String sql = "DELETE FROM customers WHERE customers_id = ?";

    try (
        // Establish the connection
        Connection conn = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement custm = conn.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        custm.setInt(1, inputcustomers_id);

        // Execute the delete
        int rowsAffected = custm.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
            System.out.println("Data deleted successfully!");
        } else {
            System.out.println("Failed to delete data. No matching record found.");
        }

    } catch (SQLException e) {
        // Print or log the exception details
        e.printStackTrace();
    }
}}


