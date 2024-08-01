<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="System.model.Project" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Projects</title>
    <style>
    body {
            font-family: Arial, sans-serif;
            background: linear-gradient(90deg, #a6a6a6, #ffffff);
            text-align: center;
            
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
    
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .back-button-container {
            text-align: center; /* Center the container horizontally */
            margin-top: 20px;
        }
        .back-button {
            display: inline-block;
            padding: 10px 20px;
            color: white;
            background-color: #f44336;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        .back-button:hover {
            background-color: #d32f2f;
        }
    </style>
</head>
<body>
    <h2>Projects List</h2>
    <table>
        <thead>
            <tr>
                <th>Project ID</th>
                <th>Project Name</th>
                <th>Description</th>
                <th>Deadline</th>
            </tr>
        </thead>
        <tbody>
            <% 
                Object obj = request.getAttribute("projects");
                if (obj instanceof List<?>) {
                    List<?> list = (List<?>) obj;
                    if (!list.isEmpty() && list.get(0) instanceof Project) {
                        @SuppressWarnings("unchecked")
                        List<Project> projects = (List<Project>) list;
                        for (Project project : projects) {
            %>
                <tr>
                    <td><%= project.getProjectId() %></td>
                    <td><%= project.getProjectName() %></td>
                    <td><%= project.getDescription() %></td>
                    <td><%= project.getDeadline() %></td>
                </tr>
            <% 
                        }
                    }
                }
            %>
        </tbody>
    </table>
    <div class="back-button-container">
        <a href="employeeHome.jsp" class="back-button">Back</a>
    </div>
</body>
</html>