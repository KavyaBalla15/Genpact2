package System.Servlet;

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

@WebServlet("/WorkUpdateServlet")
public class WorkUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public WorkUpdateServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String associateId = (String) session.getAttribute("username"); // Assuming associate ID is stored in session with key "username"

        if (associateId == null) {
            response.sendRedirect("Login.jsp"); // Redirect to login if not logged in
            return;
        }

        TaskDAO taskDAO = new TaskDAO();
        List<Task> tasks = taskDAO.getTasksForSupervisedEmployees(associateId);

        request.setAttribute("tasks", tasks);
        request.getRequestDispatcher("workupdate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String associateId = (String) session.getAttribute("username");

        if (associateId == null) {
            response.sendRedirect("Login.jsp");
            return;
        }

        String[] taskIds = request.getParameterValues("taskId");
        String[] approvalStatuses = request.getParameterValues("approvalStatus");

        if (taskIds == null || approvalStatuses == null || taskIds.length != approvalStatuses.length) {
            response.sendRedirect("error.jsp");
            return;
        }

        TaskDAO taskDAO = new TaskDAO();
        boolean allUpdatesSuccessful = true;

        for (int i = 0; i < taskIds.length; i++) {
            String taskIdStr = taskIds[i];
            String approvalStatus = approvalStatuses[i];

            int taskId;
            try {
                taskId = Integer.parseInt(taskIdStr);
            } catch (NumberFormatException e) {
                allUpdatesSuccessful = false;
                continue; // Skip this task if parsing fails
            }

            if (taskDAO.isTaskUnderSupervision(taskId, associateId)) {
                boolean success = taskDAO.updateTaskApprovalStatus(taskId, approvalStatus);

                if (!success) {
                    allUpdatesSuccessful = false;
                }
            } else {
                allUpdatesSuccessful = false;
            }
        }

        if (allUpdatesSuccessful) {
            response.sendRedirect("WorkUpdateServlet"); // Redirect to the same servlet to refresh the list
        } else {
            response.sendRedirect("error.jsp"); // Redirect to error page if any update failed
        }
    }
}