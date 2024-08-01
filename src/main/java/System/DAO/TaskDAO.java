package System.DAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import System.model.Task;

public class TaskDAO {
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

    public List<Task> getTasksByEmployeeId(String employeeId) {
        List<Task> tasks = new ArrayList<>();
        String query = "SELECT * FROM tasks WHERE Employee_id = ?";
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Task task = new Task();
                task.setTaskId(resultSet.getInt("Task_id"));
                task.setEmployeeId(resultSet.getString("Employee_id"));
                task.setProjectId(resultSet.getInt("Project_id"));
                task.setProjectName(resultSet.getString("Project_name"));
                task.setTaskDate(resultSet.getDate("Task_date"));
                task.setStartTime(resultSet.getTime("Start_time"));
                task.setEndTime(resultSet.getTime("End_time"));
                task.setDuration(resultSet.getBigDecimal("Duration"));
                task.setTaskCategory(resultSet.getString("Task_category"));
                task.setDescription(resultSet.getString("Description"));
                task.setApprovalStatus(resultSet.getString("Approval_status"));
                tasks.add(task);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public Task getTaskById(int taskId) {
        Task task = null;
        String query = "SELECT * FROM tasks WHERE Task_id = ?";
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, taskId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                task = new Task();
                task.setTaskId(resultSet.getInt("Task_id"));
                task.setEmployeeId(resultSet.getString("Employee_id"));
                task.setProjectId(resultSet.getInt("Project_id"));
                task.setProjectName(resultSet.getString("Project_name"));
                task.setTaskDate(resultSet.getDate("Task_date"));
                task.setStartTime(resultSet.getTime("Start_time"));
                task.setEndTime(resultSet.getTime("End_time"));
                task.setTaskCategory(resultSet.getString("Task_category"));
                task.setDescription(resultSet.getString("Description"));
                task.setApprovalStatus(resultSet.getString("Approval_status"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;
    }

    public boolean updateTask(int taskId, Date taskDate, Time startTime, Time endTime, String taskCategory) {
        String query = "UPDATE tasks SET Task_date = ?, Start_time = ?, End_time = ?, Task_category = ? WHERE Task_id = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDate(1, taskDate);
            preparedStatement.setTime(2, startTime);
            preparedStatement.setTime(3, endTime);
            preparedStatement.setString(4, taskCategory);
            preparedStatement.setInt(5, taskId);

            int result = preparedStatement.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Updated method to update task approval status
    public boolean updateTaskApprovalStatus(int taskId, String approvalStatus) {
        String query = "UPDATE tasks SET Approval_status = ? WHERE Task_id = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, approvalStatus);
            preparedStatement.setInt(2, taskId);

            int result = preparedStatement.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Updated method to get tasks for supervised employees
    public List<Task> getTasksForSupervisedEmployees(String associateId) {
        List<Task> tasks = new ArrayList<>();
        // Ensure the table name is correct; e.g., Employees if that's the correct name
        String query = "SELECT * FROM tasks WHERE Employee_id IN (SELECT Employee_id FROM employee WHERE ManagerAlloted = ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, associateId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Task task = new Task();
                task.setTaskId(resultSet.getInt("Task_id"));
                task.setEmployeeId(resultSet.getString("Employee_id"));
                task.setProjectId(resultSet.getInt("Project_id"));
                task.setProjectName(resultSet.getString("Project_name"));
                task.setTaskDate(resultSet.getDate("Task_date"));
                task.setStartTime(resultSet.getTime("Start_time"));
                task.setEndTime(resultSet.getTime("End_time"));
                
                // Fetch duration as BigDecimal
                BigDecimal duration = resultSet.getBigDecimal("Duration");
                task.setDuration(duration);
                
                task.setTaskCategory(resultSet.getString("Task_category"));
                task.setDescription(resultSet.getString("Description"));
                task.setApprovalStatus(resultSet.getString("Approval_status"));
                tasks.add(task);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    // Updated method to check if a task is under supervision
    public boolean isTaskUnderSupervision(int taskId, String associateId) {
        // Ensure the table name is correct; e.g., Employees if that's the correct name
        String query = "SELECT COUNT(*) FROM tasks to JOIN Employees e ON t.Employee_id = e.Employee_id WHERE t.Task_id = ? AND e.ManagerAlloted = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, taskId);
            preparedStatement.setString(2, associateId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

	public List<Task> getTasksForEmployee(String employeeId) {
		// TODO Auto-generated method stub
		return null;
	}
}