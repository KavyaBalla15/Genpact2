<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background: linear-gradient(90deg, #a6a6a6, #ffffff);
            
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px; /* Space above the table */
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
            font-weight: normal; /* Default font weight for table cells */
        }
        th {
            background-color: #f4f4f4;
            font-weight: bold; /* Make table headers bold */
        }
        .form-container {
            margin-top: 20px;
            text-align: center;
        }
        .form-container input[type=text] {
            padding: 8px;
            margin: 0 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .form-container button {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .form-container button:hover {
            background-color: #45a049;
        }
        .bold-text {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <h2 class="bold-text">Employee Details</h2>

    <div class="form-container">
        <form action="GetEmployeeDetailsServlet" method="get">
            <label for="employee_id">Enter Employee ID:</label>
            <input type="text" id="employee_id" name="employee_id" required>
            <button type="submit">Get Details</button>
        </form>
    </div>

    <hr>

    <h3 class="bold-text">Employee Details</h3>

    <table>
        <thead>
            <tr>
                <th>Employee ID</th>
                <th>Username</th>
                <th>Full Name</th>
                <th>Role</th>
                <th>Email</th>
                <th>Phone Number</th>
                <th>Date of Birth</th>
                <th>Address</th>
                <th>Date of Joining</th>
                <th>Manager Alloted</th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${not empty employee}">
                <tr>
                    <td>${employee.employeeId}</td>
                    <td>${employee.username}</td>
                    <td>${employee.fullname}</td>
                    <td>${employee.role}</td>
                    <td>${employee.email}</td>
                    <td>${employee.phoneNumber}</td>
                    <td>${employee.dob}</td>
                    <td>${employee.address}</td>
                    <td>${employee.dateOfJoining}</td>
                    <td>${employee.managerAlloted}</td>
                </tr>
            </c:if>
        </tbody>
    </table>

    <div class="form-container">
        <button onclick="window.location.href='adminHome.jsp'">Back</button>
    </div>
</body>
</html>