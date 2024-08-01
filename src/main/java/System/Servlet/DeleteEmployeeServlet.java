package System.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import System.DAO.DeleteEmployeeDAO;

@WebServlet("/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DeleteEmployeeDAO deleteEmployeeDAO;

    @Override
    public void init() throws ServletException {
        deleteEmployeeDAO = new DeleteEmployeeDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect to DeleteEmployeeForm.jsp when the admin navigates to this servlet via GET request
        request.getRequestDispatcher("DeleteEmployeeForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employeeId = request.getParameter("employee_id");

        try {
            // Perform delete operation
            boolean deletionSuccess = deleteEmployeeDAO.deleteEmployee(employeeId);

            if (deletionSuccess) {
                // Redirect to a success page or show a success message
                response.sendRedirect("deletion-success.jsp");
            } else {
                // Redirect to an error page or show an error message
                response.sendRedirect("deletion-error.jsp");
            }
        } catch (Exception e) {
            // Handle any exceptions that are thrown
            e.printStackTrace();
            response.sendRedirect("deletion-error.jsp");
        }
    }
}