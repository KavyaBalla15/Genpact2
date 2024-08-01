package System.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import System.model.Employee;
import System.util.DatabaseUtil;

public class ViewEmployeeDetailsDAO {

    public List<Employee> getEmployeesUnderManager(String managerId) {
        List<Employee> employees = new ArrayList<>();
        
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "SELECT * FROM employee WHERE ManagerAlloted = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, managerId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getString("employee_id"));
                employee.setFullname(rs.getString("name"));
                employee.setDepartment(rs.getString("department"));
                employee.setPosition(rs.getString("position"));
                employee.setEmail(rs.getString("email"));
                
                employees.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception (consider using a logger)
        }
        
        return employees;
    }

    public Employee getEmployeeDetails(String employeeId) {
        // Implementation for fetching details of a specific employee (if needed)
        return null;
    }
}
