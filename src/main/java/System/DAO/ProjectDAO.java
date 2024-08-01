package System.DAO;

import System.model.Project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bankdb";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Honey@1510";

    public List<Project> getProjectsForEmployee(String employeeId) {
        List<Project> projects = new ArrayList<>();
        String query = "SELECT Project_id, Project_name, Description, Deadline FROM projects WHERE Employee_id = ?";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, employeeId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Project project = new Project();
                project.setProjectId(rs.getInt("Project_id"));
                project.setProjectName(rs.getString("Project_name"));
                project.setDescription(rs.getString("Description"));
                project.setDeadline(rs.getDate("Deadline"));

                projects.add(project);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return projects;
    }
}