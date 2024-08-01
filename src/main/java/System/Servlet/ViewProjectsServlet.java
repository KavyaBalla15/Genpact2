package System.Servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import System.DAO.ProjectDAO;
import System.model.Project;

@WebServlet("/ViewProjectsServlet")
public class ViewProjectsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ViewProjectsServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String employeeId = (String) session.getAttribute("username"); // Get the employee ID from the session

        if (employeeId == null) {
            response.sendRedirect("Login.jsp"); // Redirect to login if not logged in
            return;
        }

        ProjectDAO projectDAO = new ProjectDAO();
        List<Project> projects = projectDAO.getProjectsForEmployee(employeeId); // Correct method name

        request.setAttribute("projects", projects);
        request.getRequestDispatcher("viewprojects.jsp").forward(request, response);
    }
}