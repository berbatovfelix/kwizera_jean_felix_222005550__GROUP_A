package entities.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class vehicletest {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement stm=null;
		ResultSet rs=null;
		String sql="SELECT * FROM vehicle ";
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
				String id =rs.getString("vehicle_id");
				String vn=rs.getString("vehicle_name");
				String pk=rs.getString("prake_name");
				
				
				System.out.println(id+"\t"+vn+"\t"+pk+"\t");
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



		// TODO Auto-generated method stub

	
