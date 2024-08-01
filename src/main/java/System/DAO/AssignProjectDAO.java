package System.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AssignProjectDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/bankdb";
    private static final String USER = "root";
    private static final String PASSWORD = "Honey@1510";

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  // Log the error
            throw new SQLException("Database driver not found.", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public boolean assignProject(int projectId, String projectName, String employeeId, String description, java.sql.Date deadline) {
        String projectQuery = "INSERT INTO projects (Project_id, Project_name, Employee_id, Description, Deadline) VALUES (?, ?, ?, ?, ?)";
        String taskQuery = "INSERT INTO tasks (Employee_id, Project_id, Project_name, Task_date, Start_time, End_time, Task_category, Description, Approval_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement projectStatement = connection.prepareStatement(projectQuery);
             PreparedStatement taskStatement = connection.prepareStatement(taskQuery)) {

            // Insert into Projects table
            projectStatement.setInt(1, projectId);
            projectStatement.setString(2, projectName);
            projectStatement.setString(3, employeeId);
            projectStatement.setString(4, description);
            projectStatement.setDate(5, deadline);

            int projectResult = projectStatement.executeUpdate();

            if (projectResult > 0) {
                // Insert into Tasks table
                taskStatement.setString(1, employeeId);
                taskStatement.setInt(2, projectId);
                taskStatement.setString(3, projectName);
                // Set default values for task_date, start_time, end_time, task_category, description, and approval_status
                taskStatement.setDate(4, new java.sql.Date(System.currentTimeMillis())); // current date as default
                taskStatement.setTime(5, java.sql.Time.valueOf("00:00:00")); // default start time
                taskStatement.setTime(6, java.sql.Time.valueOf("00:00:00")); // default end time
                taskStatement.setString(7, "N/A"); // default category
                taskStatement.setString(8, description); // use the same description as the project
                taskStatement.setString(9, "Pending"); // default approval status

                int taskResult = taskStatement.executeUpdate();
                return taskResult > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Log the error
        }
        return false;
    }
}
