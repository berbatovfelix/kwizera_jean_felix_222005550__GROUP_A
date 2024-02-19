package entities.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Testconnection {
	public static void main(String[] args) {
			Connection con=null;
			PreparedStatement stm=null;
			ResultSet rs=null;
			String sql="SELECT * FROM customers ";
			String host="jdbc:mysql://localhost/kwizera_jean_felix_222005550";
			String user="root";
			String pass="";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				con=DriverManager.getConnection(host,user,pass);
				stm=con.prepareStatement(sql);
				rs=stm.executeQuery();
				while(rs.next()) {
					//int id =rs.getInt(0);
					String id =rs.getString("customers_id");
					String last_name=rs.getString("last_name");
					String first_name=rs.getString("first_name");
					String emai=rs.getString("emai");
					String phone=rs.getString("phone");
					String address=rs.getString("address");
					String method_payment=rs.getString("payment_method");
					
					System.out.println(id+"\t"+last_name+"\t"+first_name+"\t"+emai+"\t"+phone+"\t"+address+"\t"+method_payment);
				}
			}catch (ClassNotFoundException e) {
				System.out.println("An error occurred while loading the JDBC driver");
			} catch (SQLException e) {
				System.out.println("There was an error accessing the database.");
			}finally {
				try {
					if (con != null) {
						con.close();
					}
				} catch (SQLException e) {
					System.out.println("There was an error accessing the database.");
				}
			}
			
		}

	}


