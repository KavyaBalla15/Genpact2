package System.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import System.model.Employee;

public class CreateEmployeeDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/bankdb";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Honey@1510";

    protected Connection connect() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        }
    }

    public boolean insertEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO employee (Employee_id, Username, Password, Fullname, Role, Email, PhoneNumber, Dob, Address, DateOfJoining, ManagerAlloted) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, employee.getEmployeeId());
            statement.setString(2, employee.getUsername());
            statement.setString(3, employee.getPassword());
            statement.setString(4, employee.getFullname());
            statement.setString(5, employee.getRole());
            statement.setString(6, employee.getEmail());
            statement.setString(7, employee.getPhoneNumber());
            statement.setDate(8, Date.valueOf(employee.getDob())); // Converting LocalDate to java.sql.Date
            statement.setString(9, employee.getAddress());
            statement.setDate(10, Date.valueOf(employee.getDateOfJoining())); // Converting LocalDate to java.sql.Date
            statement.setString(11, employee.getManagerAlloted());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            // Log the exception message for debugging purposes
            System.err.println("Error inserting employee: " + e.getMessage());
            throw e;  // Rethrow the exception to be handled by the calling method
        }
    }
}