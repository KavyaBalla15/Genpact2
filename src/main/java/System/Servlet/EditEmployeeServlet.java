package System.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import System.DAO.EditEmployeeDAO;

@WebServlet("/EditEmployeeServlet")
public class EditEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String employee_id = request.getParameter("employee_id");

        if (employee_id == null || employee_id.isEmpty()) {
            // Redirect to enterEmployeeId.html to enter the employee ID
            response.sendRedirect("enterEmployeeId.html");
            return;
        }

        try {
            EditEmployeeDAO dao = new EditEmployeeDAO();
            ResultSet rs = dao.getEmployeeDetails(employee_id);

            if (rs.next()) {
                request.setAttribute("employee_id", rs.getString("employee_id"));
                request.setAttribute("username", rs.getString("username"));
                request.setAttribute("password", rs.getString("password")); // Assuming you need to display password
                request.setAttribute("fullname", rs.getString("fullname"));
                request.setAttribute("role", rs.getString("role"));
                request.setAttribute("email", rs.getString("email"));
                request.setAttribute("phoneNumber", rs.getString("phoneNumber"));
                request.setAttribute("dob", rs.getString("dob"));
                request.setAttribute("address", rs.getString("address"));
                request.setAttribute("dateOfJoining", rs.getString("dateOfJoining"));
                request.setAttribute("managerAlloted", rs.getString("managerAlloted"));

                request.getRequestDispatcher("/displayEmployeeDetails.jsp").forward(request, response);
            } else {
                out.println("<html><body><h2>No employee found for employee ID " + employee_id + "</h2></body></html>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            out.println("<html><body><h2>Error occurred: " + e.getMessage() + "</h2></body></html>");
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}