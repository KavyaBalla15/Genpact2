<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Successful</title>
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
        .container {
            width: 60%;
            margin: 0 auto; /* Center the container */
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Optional: Adds a shadow */
        }
        .success-message {
            color: green;
            font-size: 1.2em;
            margin-bottom: 20px;
        }
        .account-details {
            margin-top: 20px;
            font-size: 1.1em;
            color: #000000;
        }
        .redirect-link {
            display: inline-block;
            margin-top: 20px;
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
            padding: 10px 20px;
            border: 2px solid #007bff;
            border-radius: 5px;
            transition: all 0.3s ease;
        }
        .redirect-link:hover {
            background-color: #007bff;
            color: white;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="success-message">Registration Successful</h2>
        <p>Your account has been created successfully.</p>
                <a href="adminHome.jsp" class="redirect-link">Go to Home</a>
    </div>
</body>
</html>