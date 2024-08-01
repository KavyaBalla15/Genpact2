package System.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import System.DAO.LoginDAO;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Role: " + role);

        LoginDAO loginDAO = new LoginDAO();
        boolean valid = loginDAO.validate(username, password, role);
        System.out.println("Valid: " + valid);

        if (valid) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("role", role);
            
            

            // Redirect based on role
            if ("Associate".equalsIgnoreCase(role)) {
                response.sendRedirect("associateHome.jsp");
            } else if ("Employee".equalsIgnoreCase(role)) {
                response.sendRedirect("employeeHome.jsp");
            } else if ("Admin".equalsIgnoreCase(role)) {
                response.sendRedirect("adminHome.jsp");
            } else {
                response.sendRedirect("loginfailure.jsp"); // Redirect to failure page if role is not recognized
            }
        } else {
            response.sendRedirect("loginfailure.jsp");
        }
        
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Optionally handle GET requests if needed
        response.sendRedirect("Login.jsp"); // Redirect to the login page if GET is requested
    }
}