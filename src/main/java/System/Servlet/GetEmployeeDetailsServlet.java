package System.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import System.DAO.GetEmployeeDetailsDAO;
import System.model.Employee;

@WebServlet("/GetEmployeeDetailsServlet")
public class GetEmployeeDetailsServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
 private GetEmployeeDetailsDAO getEmployeeDetailsDAO;

 @Override
 public void init() throws ServletException {
     super.init();
     getEmployeeDetailsDAO = new GetEmployeeDetailsDAO();
 }

 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String employeeId = request.getParameter("employee_id");
     Employee employee = getEmployeeDetailsDAO.getEmployeeById(employeeId);

     request.setAttribute("employee", employee);
     request.getRequestDispatcher("employee-details.jsp").forward(request, response);
 }
}