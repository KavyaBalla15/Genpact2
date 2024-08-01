package System.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import System.model.Employee;

public class EmployeeDetailsDAO {
    // Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bankdb"; // Make sure this matches your DB
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Honey@1510";

    // SQL query to select all employees
    private static final String SQL_SELECT_ALL_EMPLOYEES = "SELECT * FROM employee"; // Ensure table name matches

    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();

        try (
            // Connect to MySQL database
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            // Create prepared statement with the SQL query
            PreparedStatement pstmt = conn.prepareStatement(SQL_SELECT_ALL_EMPLOYEES);
            // Execute query and get results
            ResultSet rs = pstmt.executeQuery()) {

            // Iterate over the result set
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getString("Employee_id"));
                employee.setUsername(rs.getString("Username"));
                employee.setPassword(rs.getString("Password"));
                employee.setFullname(rs.getString("Fullname"));
                employee.setRole(rs.getString("Role"));
                employee.setEmail(rs.getString("Email"));
                employee.setPhoneNumber(rs.getString("PhoneNumber"));
                employee.setDob(rs.getString("Dob"));
                employee.setAddress(rs.getString("Address"));
                employee.setDateOfJoining(rs.getString("DateOfJoining"));
                employee.setManagerAlloted(rs.getString("ManagerAlloted"));

                employeeList.add(employee);
            }
        }

        return employeeList;
    }
}