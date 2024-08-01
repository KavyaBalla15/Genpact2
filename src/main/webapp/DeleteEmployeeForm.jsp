<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Employee</title>
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
        }
        .form-container {
            width: 40%;
            margin: 0 auto;
            background-color: #f2f2f2;
            padding: 15px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-container label {
            display: block;
            text-align: left;
            margin-bottom: 5px;
        }
        .form-container input[type="text"] {
            width: calc(100% - 12px);
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .form-container input[type="submit"] {
            background-color: #ff4c4c;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .form-container input[type="submit"]:hover {
            background-color: #e60000;
        }
        .back-button {
            margin-top: 20px;
        }
        .back-button a {
            text-decoration: none;
            background-color: #4CAF50;
            padding: 10px 20px;
            color: white;
            border-radius: 4px;
        }
        .back-button a:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h2>Delete Employee</h2>

    <div class="form-container">
        <form action="DeleteEmployeeServlet" method="post">
            <label for="employee_id">Employee ID:</label>
            <input type="text" id="employee_id" name="employee_id" required><br>

            <input type="submit" value="Delete Employee">
        </form>
    </div>

    <div class="back-button">
        <a href="adminHome.jsp">Back</a>
    </div>
</body>
</html>