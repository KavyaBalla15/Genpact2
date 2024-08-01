<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin: 0;
            padding: 0;
            background: linear-gradient(90deg, #a6a6a6, #ffffff);
            
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
        .container {
            margin-top: 50px; /* Reduced margin-top to move the container up */
        }
        .button-wrapper {
            display: flex;
            justify-content: center; /* Center the button container horizontally */
            padding: 20px;
        }
        .button-container {
            display: flex;
            flex-direction: row; /* Arrange buttons horizontally */
            align-items: center; /* Center buttons vertically */
            gap: 10px; /* Space between buttons */
            max-width: 100%; /* Set a maximum width for the container */
            margin: auto; /* Center the button container within the wrapper */
            background-color: rgba(255, 255, 255, 0.8); /* Set the background color to white with transparency */
            padding: 20px; /* Add some padding around the buttons */
            border-radius: 8px; /* Slightly rounded corners for the container */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Add a subtle shadow */
        }
        .button-container button {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #28a745; /* Change button color to green */
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: auto; /* Set button width to auto for horizontal alignment */
        }
        .button-container button:hover {
            background-color: #218838; /* Darker green on hover */
        }
        .logout-button {
            position: fixed;
            top: 10px;
            right: 10px;
            padding: 10px 20px;
            font-size: 16px;
            background-color: #f44336;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            z-index: 1000;
        }
        .logout-button:hover {
            background-color: #d32f2f;
        }
    </style>
</head>
<body>
    <button class="logout-button" onclick="location.href='LogoutServlet'">Logout</button>

    <div class="container">
        <h2>Welcome, Admin</h2>
        <div class="button-wrapper">
            <div class="button-container">
                <button onclick="location.href='CreateEmployeeServlet'">Create Employee ID</button>
                <button onclick="location.href='EditEmployeeServlet'">Edit Employee ID</button>
                <button onclick="location.href='ViewEmployeeServlet'">View Employee ID</button>
                <button onclick="location.href='DeleteEmployeeServlet'">Delete Employee ID</button>
            </div>
        </div>
    </div>
</body>
</html>