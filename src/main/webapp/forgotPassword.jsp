<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Forgot Password</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0; /* Light grey background */
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
            background-color: #fff; /* White background for the form */
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            color: #333; /* Dark grey color for headings */
        }
        label {
            display: block;
            text-align: left;
            margin-bottom: 10px;
            color: #555; /* Medium grey color for labels */
        }
        input[type="email"] {
            width: calc(100% - 20px);
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4CAF50; /* Green button background */
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049; /* Darker green on hover */
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Forgot Password</h2>
        <form action="resetPassword.jsp" method="post">
            <label for="email">Enter your email:</label>
            <input type="email" id="email" name="email" required><br><br>
            <input type="submit" value="Reset Password">
        </form>
    </div>
</body>
</html>
