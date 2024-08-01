<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="System.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Select Employee</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(90deg, #a6a6a6, #ffffff);
            text-align: center;
            margin: 20px;
            
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            font-size: 18px;
            text-align: left;
            background-color: rgba(255, 255, 255, 0.9); /* White with 90% opacity */
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        .select-button {
            background-color: #007bff; /* Blue background */
            color: white;
            border: none;
            padding: 8px 16px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }
        .select-button:hover {
            background-color: #0056b3; /* Darker blue on hover */
        }
        .back-button {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            color: white;
            background-color: #f44336; /* Light red color */
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        .back-button:hover {
            background-color: #d32f2f; /* Darker red on hover */
        }
    </style>
</head>
<body>
    <h2>Select an Employee</h2>
    <table>
        <tr>
            <th>Employee ID</th>
            <th>Full Name</th>
            <th>Action</th>
        </tr>
        <%
            Object employeesObj = request.getAttribute("employees");
            if (employeesObj instanceof List<?>) {
                List<?> employeesList = (List<?>) employeesObj;
                if (!employeesList.isEmpty() && employeesList.get(0) instanceof Employee) {
                    @SuppressWarnings("unchecked")
                    List<Employee> employees = (List<Employee>) employeesList;
                    for (Employee employee : employees) {
        %>
        <tr>
            <td><%= employee.getEmployeeId() %></td>
            <td><%= employee.getFullname() %></td>
            <td><a href="EmployeeChartsServlet?employeeId=<%= employee.getEmployeeId() %>" class="select-button">Select</a></td>
        </tr>
        <%
                    }
                } else {
        %>
        <tr>
            <td colspan="3">No employees found under your supervision.</td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="3">No employees found under your supervision.</td>
        </tr>
        <%
            }
        %>
    </table>
    <a href="associateHome.jsp" class="back-button">Back</a>
</body>
</html>