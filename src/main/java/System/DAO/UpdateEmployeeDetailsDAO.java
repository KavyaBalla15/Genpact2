package System.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateEmployeeDetailsDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bankdb";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Honey@1510";

    // Method to update employee details
    public boolean updateEmployeeDetails(String employeeId, String fullname, String username, String email,
                                         String phoneNumber, String dob, String address, String dateOfJoining,
                                         String role, String managerAlloted) {
        boolean success = false;

        String sql = "UPDATE employee SET Fullname = ?, Username = ?, Email = ?, PhoneNumber = ?, Dob = ?, " +
                     "Address = ?, DateOfJoining = ?, Role = ?, ManagerAlloted = ? WHERE Employee_id = ?";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set parameters for the prepared statement
            stmt.setString(1, fullname);
            stmt.setString(2, username);
            stmt.setString(3, email);
            stmt.setString(4, phoneNumber);
            stmt.setString(5, dob);
            stmt.setString(6, address);
            stmt.setString(7, dateOfJoining);
            stmt.setString(8, role);
            stmt.setString(9, managerAlloted);
            stmt.setString(10, employeeId);

            // Execute update and check if any rows were affected
            int rowsUpdated = stmt.executeUpdate();
            success = rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            // Optionally log the exception or rethrow a custom exception
        }
        return success;
    }
}