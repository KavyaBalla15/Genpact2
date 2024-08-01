<!DOCTYPE html>
<html>
<head>
    <title>Update Successful</title>
    <style>
        body {
            background-color: #f0f0f0; /* Light gray background */
            font-family: Arial, sans-serif;
            text-align: center;
            padding-top: 50px;
            background: linear-gradient(90deg, #a6a6a6, #ffffff);
            
            background-size: cover; /* Cover the entire background */
            background-position: center; /* Center the background image */
            background-repeat: no-repeat;
            background-attachment: fixed; /* Provides space from the top */
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
        h2 {
            color: #333; /* Dark text color */
            font-size: 24px; /* Larger font size for heading */
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="success-message">Employee details updated successfully.</h2>
        <a href="adminHome.jsp" class="redirect-link">Go to Home</a>
    </div>
</body>
</html>