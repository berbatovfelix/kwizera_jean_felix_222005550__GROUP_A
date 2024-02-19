package entities.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class driver {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM driver";
        String host = "jdbc:mysql://localhost/kwizera_jean_felix_222005550";
        String user = "root";
        String pass = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(host, user, pass);
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                String driverId = rs.getString("driver_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String phone = rs.getString("phone");
                String licenceNumber = rs.getString("licence_number");
                String vehicleId = rs.getString("vehicle_id");

                System.out.println(driverId + "\t" + firstName + "\t" + lastName + "\t" + phone + "\t" + licenceNumber + "\t" + vehicleId + "\t");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("An error occurred while loading the JDBC driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("There was an error accessing the database.");
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("There was an error closing the database connection.");
                e.printStackTrace();
            }
        }
    }
}

