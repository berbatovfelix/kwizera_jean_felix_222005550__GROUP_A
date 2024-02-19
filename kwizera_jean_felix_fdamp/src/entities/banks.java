package entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
public class banks {
	private int banks_id;
	private String name;
	private String address;
	private String phone_number;
	private String account_number;
	private String bankname;

	public banks() {}
	public banks(int banks_id, String name, String address, String phone_number, String account_number,String bankname) {
		super();
		this.banks_id = banks_id;
		this.name = name;
		this.address = address;
		this.phone_number = phone_number;
		this.account_number = account_number;
	
		this.bankname=bankname;
		
	}
	public banks( String name, String address, String phone_number, String account_number,String bankname) {
		this.name = name;
		this.address = address;
		this.phone_number = phone_number;
	this.account_number = account_number;
	this.bankname = bankname;
	}

	public int getbanks_id() {
		return banks_id;
	}
	public void setbanks_id(int banks_id) {
		this.banks_id = banks_id;
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
	public String getphone_number() {
		return phone_number;
	}
	public void setphone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getaccount_number() {
		return account_number;
	}
	public void setaccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getbankname() {
		return bankname;
	}
	public void setbankname(String bankname) {
		this.bankname = bankname;
	}
	public void makeconnnection() {
		
	}


	public void insertData() {
		// JDBC URL, banks, and password of MySQL server
	    String host = "jdbc:mysql://localhost:3306/kwizera_jean_felix_fdamp";
	    String banks = "222005550";
	    String password = "222005550";

	    // SQL query to insert data
	    String sql = "INSERT INTO banks (name,address,phone_number,account_number,bankname) VALUES (?,?,?,?,?)";

	    try (
	        // Establish the connection
	        Connection conn = DriverManager.getConnection(host, banks, password);

	        // Create a prepared statement
	        PreparedStatement banks1= conn.prepareStatement(sql);
	    ) {
	        // Set the values for the prepared statement
	       banks1.setString(1, this.name);
	        banks1.setString(2, this.address);
	        banks1.setString(3, this.phone_number);
	        banks1.setString(4, this.account_number);
	        banks1.setString(5, this.bankname);
	        

	        // Execute the query
	        int rowsAffected = banks1.executeUpdate();

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

	public void readwithbanks_id(int inputbanks_id) {
		// JDBC URL, banksname, and password of MySQL server
	    String url = "jdbc:mysql://localhost:3306/kwizera_jean_felix_fdamp";
	    String banks = "222005550";
	    String password = "222005550";

	    // SQL query to select all columns from banks where banks_id = ?
	    String sql = "SELECT * FROM banks WHERE banks_id = ?";

	    try (
	        // Establish the connection
	        Connection connnection = DriverManager.getConnection(url, banks, password);

	        // Create a prepared statement
	        PreparedStatement preparedStatement = connnection.prepareStatement(sql);
	    ) {
	        // Set the value for the parameterized query
	        //int banksbanks_id = 1; // Replace with the desired banks banks_id
	        //if()
	    	preparedStatement.setInt(1, inputbanks_id);

	        // Execute the query and get the result set
	        ResultSet resultSet = preparedStatement.executeQuery();

	        // Process the result set
	        while (resultSet.next()) {
	        	this.setbanks_id(resultSet.getInt("banks_id"));
	           this.setname(resultSet.getString("name"));
	           this.setaddress(resultSet.getString("address"));
	           this.setphone_number(resultSet.getString("phone_number"));
	            this.setaccount_number(resultSet.getString("account_number"));
	            this.setbankname(resultSet.getString("bankname"));
	            
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void update(int inputbanks_id) {
		// JDBC URL, banksname, and password of MySQL server
	    String url = "jdbc:mysql://localhost:3306/kwizera_jean_felix_fdamp";
	    String banks = "222005550";
	    String password = "222005550";

	    // SQL query to update data
	    String sql = "UPDATE banks SET name = ?, address = ?, phone_number = ?, account_number = ?, bankname = ? WHERE banks_id = ?";

	    try (
	        // Establish the conn
	        Connection conn = DriverManager.getConnection(url, banks, password);

	        // Create a prepared statement
	        PreparedStatement banks1 = conn.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	banks1.setString(1, this.getname());
	    	banks1.setString(2, this.getaddress());
	    	banks1.setString(3, this.getphone_number());
	    	banks1.setString(4, this.getaccount_number());
	    	banks1.setString(5, this.getbankname());
	    	banks1.setInt(6, inputbanks_id); // Ensure that banks_id is set correctly
	        // Execute the update
	        int rowsAffected = banks1.executeUpdate();

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

	public void delete(int inputbanks_id) {
		// JDBC URL, banksname, and password of MySQL server
	    String url = "jdbc:mysql://localhost:3306/kwizera_jean_felix_fdamp";
	    String banks = "222005550";
	    String password = "222005550";

	    // SQL query to delete data
	    String sql = "DELETE FROM banks WHERE banks_id = ?";

	    try (
	        // Establish the conn
	        Connection conn = DriverManager.getConnection(url, banks, password);

	        // Create a prepared statement
	        PreparedStatement banks1 = conn.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        banks1.setInt(1, inputbanks_id); // Assuming there is a column named 'banks_id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = banks1.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data deleted successfully!");
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }}}
	


	


