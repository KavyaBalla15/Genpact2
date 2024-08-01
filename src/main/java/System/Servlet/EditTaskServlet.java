package System.Servlet;

import System.DAO.TaskDAO;
import System.model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EditTaskServlet")
public class EditTaskServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EditTaskServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("taskId"));
        
        TaskDAO taskDAO = new TaskDAO();
        Task task = taskDAO.getTaskById(taskId);
        
        request.setAttribute("task", task);
        request.getRequestDispatcher("editTask.jsp").forward(request, response);
    }
}