package entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class fuel_suppler {
	private int fuelsup_id;
	private String last_name;
	private String first_name;
	private String email;
	private String address;
	private String phone_number;
	public fuel_suppler() {}
	public fuel_suppler(int fuelsup_id, String last_name, String first_name, String email, String address,String phone_number) {
		super();
		this.fuelsup_id = fuelsup_id;
		this.last_name = last_name;
		this.first_name = first_name;
		this.address = address;
		this.email = email;
	
		this.phone_number=phone_number;
		
	}
	
	
	public fuel_suppler( String last_name, String first_name, String address, String email,String phone_number) {
		this.last_name = last_name;
		this.first_name = first_name;
		this.address = address;
	this.email = email;
	this.phone_number =phone_number;
	}

	public int getfuelsup_id() {
		return fuelsup_id;
	}
	public void setfuelsup_id(int fuelsup_id) {
		this.fuelsup_id = fuelsup_id;
	}
	public String getlast_name() {
		return last_name;
	}
	public void setlast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getfirst_name() {
		return first_name;
	}
	public void setfirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getaddress() {
		return address;
	}
	public void setaddress(String address) {
		this.address = address;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getphone_number() {
		return phone_number;
	}
	public void setphone_number(String phone_number) {
		this.phone_number =phone_number;
	}
	public void makeconnnection() {
	
	}
	public void insertData(String f_n,String l_n, String addr,String email,String phone,String me_pay) {
		// JDBC URL, fuel_supplerlast_name, and password of MySQL server
	    String host = "jdbc:mysql://localhost/kwizera_jean_felix_fdamp";
	    String fuel_suppler = "222005550";
	    String password = "222005550";

	    // SQL query to insert data
	    String sql = "INSERT INTO fuel_suppler (last_name, first_name, email, address, phone_number) VALUES (?, ?,?, ?, ?)";

	    try (
	        // Establish the connnection
	        Connection conn = DriverManager.getConnection(host, fuel_suppler, password);

	        // Create a prepared statement
	        PreparedStatement fuel_suppler1= conn.prepareStatement(sql);
	    ) {
	        // Set the values for the prepared statement
	       fuel_suppler1.setString(1, f_n);
	        fuel_suppler1.setString(2, l_n);
	        fuel_suppler1.setString(3, addr);
	        fuel_suppler1.setString(4, email);
	        fuel_suppler1.setString(5, phone);
	        

	        // Execute the query
	        int rowsAffected = fuel_suppler1.executeUpdate();

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
		// JDBC URL, fuel_supplerlast_name, and password of MySQL server
	    String host = "jdbc:mysql://localhost/kwizera_jean_felix_fdamp";
	    String fuel_suppler = "222005550";
	    String password = "222005550";

	    // SQL query to insert data
	    String sql = "INSERT INTO fuel_suppler (last_name, first_name, email, address, phone_number) VALUES (?, ?,?, ?, ?)";
	    try (
	        // Establish the connnection
	        Connection conn = DriverManager.getConnection(host, fuel_suppler, password);

	        // Create a prepared statement
	        PreparedStatement fuel_suppler1= conn.prepareStatement(sql);
	    ) {
	        // Set the values for the prepared statement
	       fuel_suppler1.setString(1, this.last_name);
	        fuel_suppler1.setString(2, this.first_name);
	        fuel_suppler1.setString(3, this.email);
	        fuel_suppler1.setString(4, this.address);
	        fuel_suppler1.setString(5, this.phone_number);
	        

	        // Execute the query
	        int rowsAffected = fuel_suppler1.executeUpdate();

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

	public void readwithfuelsup_id(int inputfuelsup_id) {
		// JDBC URL, fuel_supplerlast_name, and password of MySQL server
	    String url = "jdbc:mysql://localhost/kwizera_jean_felix_fdamp";
	    String fuel_suppler = "222005550";
	    String password = "222005550";

	    // SQL query to select all columns from customer where fuelsup_id = ?
	    String sql = "SELECT * FROM fuel_suppler WHERE fuelsup_id = ?";

	    try (
	        // Establish the connection
	        Connection connnection = DriverManager.getConnection(url, fuel_suppler, password);

	        // Create a prepared statement
	        PreparedStatement preparedStatement = connnection.prepareStatement(sql);
	    ) {
	        // Set the value for the parameterized query
	        //int customerfuelsup_id = 1; // Replace with the desired customer fuelsup_id
	        //if()
	    	preparedStatement.setInt(1, inputfuelsup_id);

	        // Execute the query and get the result set
	        ResultSet resultSet = preparedStatement.executeQuery();

	        // Process the result set
	        while (resultSet.next()) {
	        	this.setfuelsup_id(resultSet.getInt("fuelsup_id"));
	           this.setlast_name(resultSet.getString("first_name"));
	           this.setfirst_name(resultSet.getString("last_name"));
	           this.setaddress(resultSet.getString("address"));
	            this.setemail(resultSet.getString("email"));
	            this.setphone_number(resultSet.getString("phone_number"));
	            
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void update(int inputfuelsup_id) {
	    // JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/kwizera_jean_felix_fdamp";
	    String username = "222005550";
	    String password = "222005550";

	    // SQL query to update data
	    String sql = "UPDATE fuel_suppler SET last_name = ?, first_name = ?, address = ?, email = ?, phone_number = ? WHERE fuelsup_id= ?";

	    try (
	        // Establish the connection
	        Connection connection = DriverManager.getConnection(url, username, password);

	        // Create a prepared statement
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	        preparedStatement.setString(1, this.getlast_name());
	        preparedStatement.setString(2, this.getfirst_name());
	        preparedStatement.setString(3, this.getaddress());
	        preparedStatement.setString(4, this.getemail());
	        preparedStatement.setString(5, this.getphone_number());
	        
	        preparedStatement.setInt(6, inputfuelsup_id);

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
	public void delete(int inputfuelsup_id) {
	    // JDBC URL, fuel_supplerlast_name, and password of MySQL server
	    String url = "jdbc:mysql://localhost/kwizera_jean_felix_fdamp";
	    String fuel_suppler = "222005550";
	    String password = "222005550";

	    // SQL query to delete data
	    String sql = "DELETE FROM fuel_suppler WHERE fuelsup_id= ?";

	    try (
	            // Establish the connection
	            Connection conn = DriverManager.getConnection(url, fuel_suppler, password);

	            // Create a prepared statement
	            PreparedStatement fuel_suppler1 = conn.prepareStatement(sql);
	        ) {
	            // Set the value for the WHERE clause
	            fuel_suppler1.setInt(1, inputfuelsup_id);

	            // Execute the delete
	            int rowsAffected = fuel_suppler1.executeUpdate();

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
	public void setemail1(String text) {
		// TODO Auto-generated method stub
		
	}

	



	

}


	
