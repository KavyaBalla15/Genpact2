<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Error</title>
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
        .error-message {
            color: red;
            font-size: 1.2em;
            margin-bottom: 20px;
        }
        .redirect-link {
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
        }
        .redirect-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="error-message">
        <p>Registration failed!</p>
        <p>There was an error processing your registration. Please try again later.</p>
    </div>
    <a href="index.jsp" class="redirect-link">Go back to Home</a>
</body>
</html>