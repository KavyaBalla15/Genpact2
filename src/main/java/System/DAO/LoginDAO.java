package System.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    public boolean validate(String username, String password, String role) {
        boolean status = false;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "Honey@1510");

            // Prepare SQL query based on the role
            if ("Associate".equalsIgnoreCase(role) || "Employee".equalsIgnoreCase(role) || "Admin".equalsIgnoreCase(role)) {
                String query = "SELECT * FROM employee WHERE Employee_id=? AND Password=? AND Role=?";
                ps = con.prepareStatement(query);
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, role);
            } else {
                // If role is not recognized, no need to prepare the statement
                return false;
            }

            if (ps != null) {
                // Execute query
                rs = ps.executeQuery();
                status = rs.next(); // true if there's at least one result (i.e., valid credentials)
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return status;
    }
}