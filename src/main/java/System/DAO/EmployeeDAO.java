package System.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import System.model.Employee;

public class EmployeeDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bankdb";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Honey@1510";

    public List<Employee> getEmployeesByManager(String managerId) {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employee WHERE ManagerAlloted = ?";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, managerId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getString("Employee_id"));
                employee.setFullname(rs.getString("Fullname"));
                // Set other fields if necessary
                employees.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

	public boolean updateEmployeeDetails(String employeeId, String fullname, String department, String position,
			String email) {
		// TODO Auto-generated method stub
		return false;
	}
}