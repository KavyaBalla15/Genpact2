package System.Servlet;

import System.DAO.ViewProfileDAO;
import System.model.EmployeeDetails;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ViewProfileServlet")
public class ViewProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ViewProfileServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("username") != null) {
            String employeeId = (String) session.getAttribute("username");

            ViewProfileDAO employeeDetailsDAO1 = new ViewProfileDAO();
            EmployeeDetails employeeDetails = employeeDetailsDAO1.getEmployeeDetails(employeeId);

            if (employeeDetails != null) {
                request.setAttribute("employeeDetails", employeeDetails);
                request.getRequestDispatcher("viewProfile.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Unable to retrieve employee details.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("Login.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}