package System.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import System.DAO.UpdateEmployeeDetailsDAO;

@WebServlet("/UpdateEmployeeDetailsServlet")
public class UpdateEmployeeDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UpdateEmployeeDetailsDAO updateEmployeeDetailsDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        updateEmployeeDetailsDAO = new UpdateEmployeeDetailsDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        // Retrieve parameters from the request
        String employeeId = request.getParameter("employee_id");
        String fullname = request.getParameter("fullname");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String dateOfJoining = request.getParameter("dateOfJoining");
        String role = request.getParameter("role");
        String managerAlloted = request.getParameter("managerAlloted");

        // Validate the input parameters
        if (employeeId == null || fullname == null || username == null || email == null || phoneNumber == null ||
            dob == null || address == null || dateOfJoining == null || role == null || managerAlloted == null) {
            request.setAttribute("errorMessage", "All fields are required.");
            request.getRequestDispatcher("editEmployee.jsp").forward(request, response);
            return;
        }

        // Perform the update operation
        boolean updateSuccess = updateEmployeeDetailsDAO.updateEmployeeDetails(employeeId, fullname, username, email,
                phoneNumber, dob, address, dateOfJoining, role, managerAlloted);

        // Redirect based on the update result
        if (updateSuccess) {
            response.sendRedirect("updateEmployeeSuccess.jsp");
        } else {
            request.setAttribute("errorMessage", "Failed to update employee details. Please try again.");
            request.getRequestDispatcher("editEmployee.jsp").forward(request, response);
        }
    }
}