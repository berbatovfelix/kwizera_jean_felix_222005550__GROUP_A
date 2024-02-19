package entities.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class userconnectiontest {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement fdm=null;
		ResultSet rs=null;
		String sql="SELECT * FROM user1 ";
		String host="jdbc:mysql://localhost/kwizera_jean_felix_222005550";
		String user="root";
		String pass="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection(host,user,pass);
			fdm=con.prepareStatement(sql);
			rs=fdm.executeQuery();
			while(rs.next()) {
				//int id =rs.getInt(0);
				String id =rs.getString("user1_id");
				String fname=rs.getString("first_name");
				String lname=rs.getString("last_name");
				String phone=rs.getString("phone_number");
				String email=rs.getString("email");
				String role=rs.getString("role");
				
				
				System.out.println(id+"\t"+fname+"\t"+lname+"\t"+phone+"t"+email+"\t"+role);
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





		// TODO Auto-generated method stub

	}


