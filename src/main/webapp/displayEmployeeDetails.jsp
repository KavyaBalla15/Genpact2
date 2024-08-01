<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Employee Details</title>
    <style>
        body {
            background-color: #f0f0f0;
            font-family: Arial, sans-serif;
            text-align: center;
            padding-top: 20px;
            margin: 0;
            background: linear-gradient(90deg, #a6a6a6, #ffffff);
            
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
        h2 {
            color: black;
            font-size: 24px;
            margin-bottom: 20px;
        }
        form {
            max-width: 400px; /* Set the maximum width of the form */
            margin: 0 auto;
            background-color: #fff;
            padding: 15px; /* Reduced padding */
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 0px; /* Adjusted margin-top to move container up */
        }
        label {
            display: block;
            margin-bottom: 5px; /* Reduced margin */
            color: #555;
            font-size: 14px; /* Reduced font size */
        }
        input[type="text"], input[type="email"], input[type="date"] {
            width: calc(100% - 20px);
            padding: 8px; /* Reduced padding */
            margin-bottom: 10px; /* Reduced margin */
            border: 1px solid #ccc;
            border-radius: 3px;
            font-size: 14px; /* Reduced font size */
            box-sizing: border-box;
        }
        button[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px; /* Adjusted padding */
            border: none;
            border-radius: 3px;
            cursor: pointer;
            font-size: 14px; /* Reduced font size */
        }
        button[type="submit"]:hover {
            background-color: #45a049;
        }
        .back-button {
            display: inline-block;
            margin-top: 20px;
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
    <h2>Edit Employee Details</h2>
    <br><br>
    <form action="UpdateEmployeeDetailsServlet" method="post">
        <input type="hidden" name="employee_id" value="${param.employee_id}">
        
        <label for="fullname">Full Name:</label>
        <input type="text" id="fullname" name="fullname" value="${requestScope.fullname}" required>
        
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" value="${requestScope.username}" required>
        
        <label for="email">Email ID:</label>
        <input type="email" id="email" name="email" value="${requestScope.email}" required>
        
        <label for="phoneNumber">Phone Number:</label>
        <input type="text" id="phoneNumber" name="phoneNumber" value="${requestScope.phoneNumber}" required>
        
        <label for="dob">Date of Birth:</label>
        <input type="date" id="dob" name="dob" value="${requestScope.dob}" required>
        
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" value="${requestScope.address}" required>
        
        <label for="dateOfJoining">Date of Joining:</label>
        <input type="date" id="dateOfJoining" name="dateOfJoining" value="${requestScope.dateOfJoining}" required>
        
        <label for="role">Role:</label>
        <input type="text" id="role" name="role" value="${requestScope.role}" required>
        
        <label for="managerAlloted">Manager Alloted:</label>
        <input type="text" id="managerAlloted" name="managerAlloted" value="${requestScope.managerAlloted}" required>
        
        <button type="submit">Update Details</button>
    </form>
    <a href="employeeHome.jsp" class="back-button">Back</a>
</body>
</html>