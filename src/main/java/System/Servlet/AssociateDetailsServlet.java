package System.Servlet;

import System.DAO.AssociateDetailsDAO;
import System.model.AssociateDetails;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/AssociateDetailsServlet")
public class AssociateDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AssociateDetailsServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("username") != null) {
            String employeeId = (String) session.getAttribute("username");

            AssociateDetailsDAO associateDetailsDAO = new AssociateDetailsDAO();
            AssociateDetails associateDetails = associateDetailsDAO.getAssociateDetails(employeeId);

            if (associateDetails != null) {
                request.setAttribute("associateDetails", associateDetails);
                request.getRequestDispatcher("associateDetails.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Unable to retrieve associate details.");
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