package System.Servlet;

import System.DAO.AssignProjectDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/AssignProjectServlet")
public class AssignProjectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AssignProjectServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Extract parameters from the request
            int projectId = Integer.parseInt(request.getParameter("projectId"));
            String projectName = request.getParameter("projectName");
            String employeeId = request.getParameter("employeeId");
            String description = request.getParameter("description");

            // Validate and parse the deadline
            String deadlineStr = request.getParameter("deadline");
            Date deadline = null;
            if (deadlineStr != null && !deadlineStr.trim().isEmpty()) {
                try {
                    deadline = Date.valueOf(deadlineStr); // Directly parse yyyy-MM-dd
                } catch (IllegalArgumentException e) {
                    request.setAttribute("errorMessage", "Invalid date format. Please use yyyy-MM-dd.");
                    request.getRequestDispatcher("assignProject.jsp").forward(request, response);
                    return;
                }
            } else {
                request.setAttribute("errorMessage", "Deadline cannot be empty.");
                request.getRequestDispatcher("assignProject.jsp").forward(request, response);
                return;
            }

            // Create DAO object and assign project
            AssignProjectDAO dao = new AssignProjectDAO();
            boolean success = dao.assignProject(projectId, projectName, employeeId, description, deadline);

            // Redirect based on success or failure
            if (success) {
                response.sendRedirect("assignProjectSuccess.jsp");
            } else {
                response.sendRedirect("assignProjectSuccess.jsp");
            }

        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid input format.");
            request.getRequestDispatcher("assignProject.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while assigning the project.");
            request.getRequestDispatcher("assignProject.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect GET requests to the form page
        response.sendRedirect("assignProject.jsp");
    }
}
