package entities.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class bankstest {


	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement fdm=null;
		ResultSet rs=null;
		String sql="SELECT * FROM banks ";
		String host="jdbc:mysql://localhost/kwizera_jean_felix_fdamp";
		String user="root";
		String pass="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection(host,user,pass);
			fdm=con.prepareStatement(sql);
			rs=fdm.executeQuery();
			while(rs.next()) {
				//int id =rs.getInt(0);
				String id =rs.getString("banks_id");
				String name=rs.getString("name");
				String address=rs.getString("address");
				String acc=rs.getString("phone_number");
				String phon=rs.getString("account_number");
				String rout=rs.getString("bankname");
				
				
				System.out.println(id+"\t"+name+"\t"+address+"\t"+acc+"\t"+phon+"\t"+rout);
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
