package System.DAO;

import System.model.EmployeeDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewProfileDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/bankdb";
    private static final String USER = "root";
    private static final String PASSWORD = "Honey@1510";

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }

    public EmployeeDetails getEmployeeDetails(String employeeId) {
        EmployeeDetails employeeDetails = null;

        String query = "SELECT Employee_id, Username, Password, Fullname, Role, Email, PhoneNumber, Dob, Address, DateOfJoining " +
                       "FROM employee WHERE Employee_id = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                employeeDetails = new EmployeeDetails();
                employeeDetails.setEmployeeId(resultSet.getString("Employee_id"));
                employeeDetails.setUsername(resultSet.getString("Username"));
                employeeDetails.setPassword(resultSet.getString("Password"));
                employeeDetails.setFullName(resultSet.getString("Fullname"));
                employeeDetails.setRole(resultSet.getString("Role"));
                employeeDetails.setEmail(resultSet.getString("Email"));
                employeeDetails.setPhoneNumber(resultSet.getString("PhoneNumber"));

                java.sql.Date dob = resultSet.getDate("Dob");
                employeeDetails.setDob(dob != null ? dob.toString() : "N/A");

                java.sql.Date dateOfJoining = resultSet.getDate("DateOfJoining");
                employeeDetails.setDateOfJoining(dateOfJoining != null ? dateOfJoining.toString() : "N/A");

                employeeDetails.setAddress(resultSet.getString("Address"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeDetails;
    }
}