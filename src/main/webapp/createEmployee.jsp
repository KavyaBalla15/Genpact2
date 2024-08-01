<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Employee</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(90deg, #a6a6a6, #ffffff);
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            overflow: hidden;
        }

        .container {
            width: 90%; /* Reduced width for a more compact container */
            max-width: 360px; /* Further reduced maximum width */
            padding: 10px; /* Reduced padding */
            background-color: rgba(249, 249, 249, 0.9);
            box-shadow: 0 0 6px rgba(0, 0, 0, 0.1); /* Smaller shadow */
            border-radius: 6px; /* Smaller border radius */
            box-sizing: border-box;
        }

        h2 {
            font-size: 18px; /* Reduced font size */
            margin-bottom: 10px; /* Reduced margin */
        }

        .form-group {
            margin-bottom: 8px; /* Reduced margin */
        }

        label {
            display: block;
            margin-bottom: 2px; /* Further reduced margin */
            font-size: 12px; /* Smaller font size */
            font-weight: bold;
        }

        input[type="text"],
        input[type="password"],
        input[type="email"],
        input[type="date"],
        select {
            width: calc(100% - 12px); /* Adjusted width */
            padding: 4px; /* Further reduced padding */
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 12px; /* Smaller font size */
        }

        input[type="submit"],
        input[type="button"] {
            width: 100%;
            padding: 6px; /* Reduced padding */
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 12px; /* Smaller font size */
            cursor: pointer;
            margin-top: 6px; /* Reduced margin-top */
        }

        input[type="submit"]:hover,
        input[type="button"]:hover {
            background-color: #45a049;
        }

        .error-message {
            color: red;
            font-size: 12px; /* Smaller font size */
            margin-bottom: 8px; /* Reduced margin */
        }

        .back-button-container {
            position: absolute;
            top: 10px; /* Reduced top position */
            right: 10px; /* Reduced right position */
        }

        .back-button {
            background-color: #f44336;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 14px; /* Slightly increased font size for readability */
            cursor: pointer;
            padding: 8px 16px; /* Adjusted padding */
            text-align: center;
            text-decoration: none;
        }

        .back-button:hover {
            background-color: #d32f2f;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Create Employee</h2>
        <% if (request.getAttribute("errorMessage") != null) { %>
            <p class="error-message"><%= request.getAttribute("errorMessage") %></p>
        <% } %>
        <form action="CreateEmployeeServlet" method="post">
            <div class="form-group">
                <label for="employee_id">Employee ID</label>
                <input type="text" id="employee_id" name="employee_id" value="<%= request.getAttribute("employee_id") != null ? request.getAttribute("employee_id") : "" %>" required>
            </div>
            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" value="<%= request.getAttribute("username") != null ? request.getAttribute("username") : "" %>" required>
            </div>
            <div class="form-group">
                <label for="fullname">Full Name</label>
                <input type="text" id="fullname" name="fullname" value="<%= request.getAttribute("fullname") != null ? request.getAttribute("fullname") : "" %>" required>
            </div>
            <div class="form-group">
                <label for="role">Role</label>
                <select id="role" name="role" required>
                    <option value="associate" <%= "associate".equals(request.getAttribute("role")) ? "selected" : "" %>>Associate</option>
                    <option value="employee" <%= "employee".equals(request.getAttribute("role")) ? "selected" : "" %>>Employee</option>
                    <option value="admin" <%= "admin".equals(request.getAttribute("role")) ? "selected" : "" %>>Admin</option>
                </select>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" value="<%= request.getAttribute("email") != null ? request.getAttribute("email") : "" %>" required>
            </div>
            <div class="form-group">
                <label for="phoneNumber">Phone Number</label>
                <input type="text" id="phoneNumber" name="phoneNumber" value="<%= request.getAttribute("phoneNumber") != null ? request.getAttribute("phoneNumber") : "" %>" required>
            </div>
            <div class="form-group">
                <label for="dob">Date of Birth</label>
                <input type="date" id="dob" name="dob" value="<%= request.getAttribute("dob") != null ? request.getAttribute("dob") : "" %>" required>
            </div>
            <div class="form-group">
                <label for="address">Address</label>
                <input type="text" id="address" name="address" value="<%= request.getAttribute("address") != null ? request.getAttribute("address") : "" %>" required>
            </div>
            <div class="form-group">
                <label for="dateOfJoining">Date of Joining</label>
                <input type="date" id="dateOfJoining" name="dateOfJoining" value="<%= request.getAttribute("dateOfJoining") != null ? request.getAttribute("dateOfJoining") : "" %>" required>
            </div>
            <div class="form-group">
                <label for="managerAlloted">Manager Allotted</label>
                <input type="text" id="managerAlloted" name="managerAlloted" value="<%= request.getAttribute("managerAlloted") != null ? request.getAttribute("managerAlloted") : "" %>" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" value="<%= request.getAttribute("password") != null ? request.getAttribute("password") : "" %>" required>
            </div>
            <input type="submit" value="Create Employee">
        </form>
    </div>
    <div class="back-button-container">
        <button class="back-button" onclick="window.location.href='adminHome.jsp'">Back</button>
    </div>
</body>
</html>
