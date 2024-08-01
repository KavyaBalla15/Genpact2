package System.Servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import System.DAO.EmployeeDAO;
import System.DAO.TaskDAO;
import System.model.Employee;
import System.model.Task;

@WebServlet("/EmployeeChartsServlet")
public class EmployeeChartsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EmployeeChartsServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String associateId = (String) session.getAttribute("username");

        if (associateId == null) {
            response.sendRedirect("Login.jsp");
            return;
        }

        String employeeId = request.getParameter("employeeId");

        if (employeeId == null) {
            // Fetch employees under the associate's supervision
            EmployeeDAO employeeDAO = new EmployeeDAO();
            List<Employee> employees = employeeDAO.getEmployeesByManager(associateId);

            request.setAttribute("employees", employees);
            request.getRequestDispatcher("selectEmployee.jsp").forward(request, response);
            return;
        }

        TaskDAO taskDAO = new TaskDAO();
        List<Task> tasks = taskDAO.getTasksByEmployeeId(employeeId);

        // Aggregate data for daily, weekly, and monthly charts
        Map<LocalDate, BigDecimal> dailyData = tasks.stream()
                .collect(Collectors.groupingBy(
                        task -> task.getTaskDate().toLocalDate(),
                        Collectors.mapping(Task::getDuration, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
                ));

        Map<Integer, BigDecimal> weeklyData = tasks.stream()
                .collect(Collectors.groupingBy(
                        task -> task.getTaskDate().toLocalDate().get(ChronoField.ALIGNED_WEEK_OF_YEAR),
                        Collectors.mapping(Task::getDuration, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
                ));

        Map<Integer, BigDecimal> monthlyData = tasks.stream()
                .collect(Collectors.groupingBy(
                        task -> task.getTaskDate().toLocalDate().getMonthValue(),
                        Collectors.mapping(Task::getDuration, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
                ));

        request.setAttribute("dailyData", dailyData);
        request.setAttribute("weeklyData", weeklyData);
        request.setAttribute("monthlyData", monthlyData);
        request.getRequestDispatcher("employeeCharts.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}