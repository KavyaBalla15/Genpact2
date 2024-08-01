package System.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteEmployeeDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bankdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Honey@1510";

    /**
     * Checks if the employee exists in the database.
     *
     * @param employeeId the ID of the employee to check
     * @return true if the employee exists, false otherwise
     */
    public boolean checkEmployeeExists(String employeeId) {
        String sql = "SELECT COUNT(*) FROM employee WHERE Employee_id = ?";
        boolean exists = false;

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, employeeId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    exists = true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exists;
    }

    /**
     * Deletes the employee with the given ID from the database.
     *
     * @param employeeId the ID of the employee to delete
     * @return true if the deletion was successful, false otherwise
     */
    public boolean deleteEmployee(String employeeId) {
        String sql = "DELETE FROM employee WHERE Employee_id = ?";
        boolean success = false;

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, employeeId);
            int rowsAffected = pstmt.executeUpdate();
            success = rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }
}