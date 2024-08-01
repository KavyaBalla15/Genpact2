<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="System.model.Task" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Task</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(90deg, #a6a6a6, #ffffff);
            text-align: center;
        }
        form {
            display: inline-block;
            text-align: left;
            margin-top: 20px;
        }
        label, input {
            display: block;
            margin: 10px;
        }
        .submit-button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .submit-button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h2>Edit Task</h2>
    <%
        Task task = (Task) request.getAttribute("task");
        if (task != null) {
            // Format the date and time for HTML input compatibility
            String taskDate = task.getTaskDate() != null ? new java.text.SimpleDateFormat("yyyy-MM-dd").format(task.getTaskDate()) : "";
            String startTime = task.getStartTime() != null ? new java.text.SimpleDateFormat("HH:mm:ss").format(task.getStartTime()) : "";
            String endTime = task.getEndTime() != null ? new java.text.SimpleDateFormat("HH:mm:ss").format(task.getEndTime()) : "";
    %>
    <form action="TaskServlet" method="post">
        <input type="hidden" name="taskId" value="<%= task.getTaskId() %>">
        
        <label for="taskDate">Task Date:</label>
        <input type="date" id="taskDate" name="taskDate" value="<%= taskDate %>">
        
        <label for="startTime">Start Time:</label>
        <input type="time" id="startTime" name="startTime" value="<%= startTime %>">
        
        <label for="endTime">End Time:</label>
        <input type="time" id="endTime" name="endTime" value="<%= endTime %>">
        
        <label for="taskCategory">Task Category:</label>
        <input type="text" id="taskCategory" name="taskCategory" value="<%= task.getTaskCategory() %>">
        
        <button type="submit" class="submit-button">Save Changes</button>
    </form>
    <%
        } else {
    %>
    <p>No task data available to edit.</p>
    <%
        }
    %>
</body>
</html>
