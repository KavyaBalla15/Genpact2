package System.Servlet;

import System.DAO.TaskDAO;
import System.model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/TaskServlet")
public class TaskServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm");

    public TaskServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String employeeId = (String) session.getAttribute("username"); // Assuming employee ID is stored in session with key "username"

        if (employeeId == null) {
            response.sendRedirect("login.jsp"); // Redirect to login if not logged in
            return;
        }

        TaskDAO taskDAO = new TaskDAO();
        List<Task> tasks = taskDAO.getTasksByEmployeeId(employeeId);

        request.setAttribute("tasks", tasks);
        request.getRequestDispatcher("tasks.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String employeeId = (String) session.getAttribute("username"); // Assuming employee ID is stored in session with key "username"

        if (employeeId == null) {
            response.sendRedirect("Login.jsp"); // Redirect to login if not logged in
            return;
        }

        int taskId = Integer.parseInt(request.getParameter("taskId"));
        Date taskDate = Date.valueOf(request.getParameter("taskDate"));

        Time startTime = null;
        Time endTime = null;

        try {
            startTime = new Time(TIME_FORMAT.parse(request.getParameter("startTime")).getTime());
            endTime = new Time(TIME_FORMAT.parse(request.getParameter("endTime")).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Handle parsing error
            return;
        }

        String taskCategory = request.getParameter("taskCategory");

        TaskDAO taskDAO = new TaskDAO();
        boolean success = taskDAO.updateTask(taskId, taskDate, startTime, endTime, taskCategory);

        if (success) {
            response.sendRedirect("TaskServlet");
        } else {
            response.sendRedirect("error.jsp"); // Handle error appropriately
        }
    }
}