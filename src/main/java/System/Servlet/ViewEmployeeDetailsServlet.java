package System.Servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import System.DAO.ViewEmployeeDetailsDAO;
import System.model.Employee;

@WebServlet("/ViewEmployeeDetailsServlet")
public class ViewEmployeeDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ViewEmployeeDetailsServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String managerId = (String) session.getAttribute("username"); // Assuming username is used as employee ID

        if (managerId == null || managerId.isEmpty()) {
            response.sendRedirect("login.jsp"); // Redirect to login if not authenticated
            return;
        }

        ViewEmployeeDetailsDAO dao = new ViewEmployeeDetailsDAO();
        List<Employee> employees = dao.getEmployeesUnderManager(managerId);

        request.setAttribute("employees", employees);
        request.getRequestDispatcher("viewemployeeDetails.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response); // Handle POST requests the same way as GET requests
    }
}
