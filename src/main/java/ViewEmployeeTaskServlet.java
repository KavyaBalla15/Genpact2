import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import System.DAO.TaskDAO;
import System.model.Task;

@WebServlet("/ViewEmployeeTaskServlet")
public class ViewEmployeeTaskServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ViewEmployeeTaskServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String employeeId = request.getParameter("employeeId");

        if (employeeId == null || employeeId.isEmpty()) {
            response.sendRedirect("error.jsp"); // Redirect to an error page if the employeeId is missing
            return;
        }

        TaskDAO taskDAO = new TaskDAO();
        List<Task> tasks = taskDAO.getTasksForEmployee(employeeId);

        request.setAttribute("tasks", tasks);
        request.getRequestDispatcher("viewEmployeeTasks.jsp").forward(request, response);
    }
}
