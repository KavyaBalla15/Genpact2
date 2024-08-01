package System.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import System.model.AssociateDetails;

public class AssociateDetailsDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/bankdb";
    private static final String USER = "root";
    private static final String PASSWORD = "Honey@1510";

    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public AssociateDetails getAssociateDetails(String employeeId) {
        AssociateDetails associateDetails = null;

        try (Connection connection = getConnection()) {
            String query = "SELECT Employee_id, Username, Password, Fullname, Role, Email, PhoneNumber, Dob, Address, DateOfJoining " +
                           "FROM employee WHERE Employee_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                associateDetails = new AssociateDetails();
                associateDetails.setEmployeeId(resultSet.getString("Employee_id"));
                associateDetails.setUsername(resultSet.getString("Username"));
                associateDetails.setPassword(resultSet.getString("Password"));
                associateDetails.setFullName(resultSet.getString("Fullname"));
                associateDetails.setRole(resultSet.getString("Role"));
                associateDetails.setEmail(resultSet.getString("Email"));
                associateDetails.setPhoneNumber(resultSet.getString("PhoneNumber"));
                
                // Handle potential NULL values for DATE fields
                java.sql.Date dob = resultSet.getDate("Dob");
                associateDetails.setDob(dob != null ? dob.toString() : "N/A");

                java.sql.Date dateOfJoining = resultSet.getDate("DateOfJoining");
                associateDetails.setDateOfJoining(dateOfJoining != null ? dateOfJoining.toString() : "N/A");

                associateDetails.setAddress(resultSet.getString("Address"));
            } else {
                System.out.println("No associate found with Employee_id: " + employeeId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return associateDetails;
    }
}