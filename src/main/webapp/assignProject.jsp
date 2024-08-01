<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Assign Project</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background: linear-gradient(90deg, #a6a6a6, #ffffff);
            
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
        .form-container {
            width: 60%;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input, .form-group textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        .form-group textarea {
            height: 100px;
        }
        .submit-button {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .submit-button:hover {
            background-color: #0056b3;
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
            background-color: #d32f2f;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Assign Project</h2>
        <form action="AssignProjectServlet" method="post">
            <div class="form-group">
                <label for="projectId">Project ID:</label>
                <input type="number" id="projectId" name="projectId" required>
            </div>
            <div class="form-group">
                <label for="projectName">Project Name:</label>
                <input type="text" id="projectName" name="projectName" required>
            </div>
            <div class="form-group">
                <label for="employeeId">Employee ID:</label>
                <input type="text" id="employeeId" name="employeeId" required>
            </div>
            <div class="form-group">
                <label for="description">Description:</label>
                <textarea id="description" name="description"></textarea>
            </div>
            <div class="form-group">
                <label for="deadline">Deadline (DD-MM-YYYY):</label>
                <input type="date" id="deadline" name="deadline" required>
            </div>
            <button type="submit" class="submit-button">Assign Project</button>
        </form>
    </div>
    <a href="associateHome.jsp" class="back-button">Back</a> <!-- Adjust href as needed -->
</body>
</html>