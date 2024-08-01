package System.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import System.DAO.CreateEmployeeDAO;
import System.model.Employee;

@WebServlet("/CreateEmployeeServlet")
public class CreateEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CreateEmployeeDAO createEmployeeDAO;

    public CreateEmployeeServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
        createEmployeeDAO = new CreateEmployeeDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employee_id = request.getParameter("employee_id");
        String username = request.getParameter("username");
        String fullname = request.getParameter("fullname");
        String role = request.getParameter("role");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String dateOfJoining = request.getParameter("dateOfJoining");
        String managerAlloted = request.getParameter("managerAlloted");
        String password = request.getParameter("password");

        String errorMessage = null;

        // Basic null checks
        if (employee_id == null || username == null || fullname == null || role == null ||
            email == null || phoneNumber == null || dob == null || address == null ||
            dateOfJoining == null || managerAlloted == null || password == null) {
            errorMessage = "All fields are required.";
        }

        // Validate phone number length
        if (errorMessage == null && (phoneNumber.length() != 10 || !phoneNumber.matches("\\d+"))) {
            errorMessage = "Phone number must be exactly 10 digits.";
        }

        // Parse dates and validate
        LocalDate dobDate = null;
        LocalDate dojDate = null;
        if (errorMessage == null) {
            try {
                dobDate = LocalDate.parse(dob);
                dojDate = LocalDate.parse(dateOfJoining);
            } catch (DateTimeParseException e) {
                errorMessage = "Invalid date format. Use YYYY-MM-DD.";
            }
        }

        if (errorMessage == null && dobDate.equals(dojDate)) {
            errorMessage = "Date of birth and date of joining cannot be the same.";
        }

        if (errorMessage != null) {
            request.setAttribute("errorMessage", errorMessage);
            request.setAttribute("employee_id", employee_id);
            request.setAttribute("username", username);
            request.setAttribute("fullname", fullname);
            request.setAttribute("role", role);
            request.setAttribute("email", email);
            request.setAttribute("phoneNumber", phoneNumber);
            request.setAttribute("dob", dob);
            request.setAttribute("address", address);
            request.setAttribute("dateOfJoining", dateOfJoining);
            request.setAttribute("managerAlloted", managerAlloted);
            request.setAttribute("password", password);
            request.getRequestDispatcher("createEmployee.jsp").forward(request, response);
            return;
        }

        Employee employee = new Employee();
        employee.setEmployeeId(employee_id);
        employee.setUsername(username);
        employee.setFullname(fullname);
        employee.setRole(role);
        employee.setEmail(email);
        employee.setPhoneNumber(phoneNumber);
        employee.setDob(dob);
        employee.setAddress(address);
        employee.setDateOfJoining(dateOfJoining);
        employee.setManagerAlloted(managerAlloted);
        employee.setPassword(password);

        try {
            boolean result = createEmployeeDAO.insertEmployee(employee);
            if (result) {
                response.sendRedirect("registration-success.jsp");
            } else {
                request.setAttribute("errorMessage", "Failed to create employee. Please try again.");
                request.getRequestDispatcher("createEmployee.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Database error. Please try again.");
            request.getRequestDispatcher("createEmployee.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("createEmployee.jsp");
    }
}