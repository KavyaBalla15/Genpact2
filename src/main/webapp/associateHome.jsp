<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Associate Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 50px;
            background: linear-gradient(90deg, #a6a6a6, #ffffff);
            
            background-size: cover; /* Cover the entire background */
            background-position: center; /* Center the background image */
            background-repeat: no-repeat;
            background-attachment: fixed;
            /* Remove any extra margin-top here to ensure alignment */
        }
        .button-container {
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
            margin-top: 20px;
        }
        .button-container button {
            margin: 10px;
            padding: 10px 20px;
            font-size: 16px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .button-container button:hover {
            background-color: #0056b3;
        }
        .logout-button {
            position: fixed; /* Fix the position relative to the viewport */
            top: 10px;
            right: 10px;
            padding: 10px 20px;
            font-size: 16px;
            background-color: #f44336; /* Red background for logout button */
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            z-index: 1000; /* Ensure the button stays on top of other elements */
        }
        .logout-button:hover {
            background-color: #d32f2f;
        }
    </style>
</head>
<body>
    <button class="logout-button" onclick="location.href='LogoutServlet'">Logout</button>

    <h2>Welcome, Associate</h2>

    <div class="button-container">
        <button onclick="location.href='AssociateDetailsServlet'">Associate Details</button>
        <button onclick="location.href='ViewEmployeeDetailsServlet'">Employee Details</button>
        <button onclick="location.href='AssignProjectServlet'">Assign Project</button>
        <button onclick="location.href='WorkUpdateServlet'">Work Update</button>
        <button onclick="location.href='EmployeeChartsServlet'">Employee Charts</button>
    </div>
</body>
</html>