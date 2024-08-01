<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Details</title>
</head>
<body>
    <h2>Employee Details</h2>
    <table border="1">
        <tr>
            <th>Employee ID</th>
            <th>Name</th>
            <th>Department</th>
            <th>Position</th>
            <th>Email</th>
        </tr>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.employeeId}</td>
                <td>${employee.name}</td>
                <td>${employee.department}</td>
                <td>${employee.position}</td>
                <td>${employee.email}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
