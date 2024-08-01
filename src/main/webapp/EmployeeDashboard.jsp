<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Dashboard</title>
    <style>
        /* Global Styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        /* Container Styles */
        .container {
            max-width: 800px;
            width: 100%;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }

        /* Header Styles */
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding-bottom: 10px;
            border-bottom: 1px solid #ddd;
            margin-bottom: 20px;
        }

        .header h2 {
            margin: 0;
            font-size: 24px;
        }

        /* Logout Button Styles */
        .logout-btn {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }

        .logout-btn:hover {
            background-color: #45a049;
        }

        /* Button Container Styles */
        .btn-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 10px;
        }

        /* Button Styles */
        .btn-container button {
            padding: 12px 20px;
            font-size: 16px;
            cursor: pointer;
            border: none;
            border-radius: 4px;
            background-color: #4CAF50;
            color: white;
            transition: background-color 0.3s ease;
        }

        .btn-container button:hover {
            background-color: #45a049;
        }

        .btn-container form {
            margin: 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h2>Welcome to Employee Dashboard</h2>
            <form action="LogoutServlet" method="get">
                <button class="logout-btn" type="submit">Logout</button>
            </form>
        </div>
        <div class="btn-container">
            <form action="ResetPassword.html" method="post">
                <button type="submit">Reset Password</button>
            </form>
            <form action="ViewProjectByEmployeeServlet" method="post">
                <button type="submit">Projects</button>
            </form>
            <form action="Request.html" method="post">
                <button type="submit">Request</button>
            </form>
            <form action="ListEmployeeForProjectsServlet" method="post">
                <button type="submit">View List</button>
            </form>
            <form action="EditOrDeleteServlet" method="post">
                <button type="submit">Edit or Delete My Work</button>
            </form>
            <form action="AddWork.html" method="post">
                <button type="submit">Add Work</button>
            </form>
        </div>
    </div>
</body>
</html>