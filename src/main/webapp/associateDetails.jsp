<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Associate Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 50px;
            background: linear-gradient(90deg, #a6a6a6, #ffffff);
            
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
        .details-container {
            width: 60%;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .detail-item {
            margin: 10px 0;
        }
        .detail-item span {
            font-weight: bold;
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
    <div class="details-container">
        <h2>Associate Details</h2>
        <div class="detail-item">
            <span>Employee ID:</span> ${associateDetails.employeeId}
        </div>
        <div class="detail-item">
            <span>Username:</span> ${associateDetails.username}
        </div>
        <div class="detail-item">
            <span>Password:</span> ${associateDetails.password}
        </div>
        <div class="detail-item">
            <span>Full Name:</span> ${associateDetails.fullName}
        </div>
        <div class="detail-item">
            <span>Role:</span> ${associateDetails.role}
        </div>
        <div class="detail-item">
            <span>Email:</span> ${associateDetails.email}
        </div>
        <div class="detail-item">
            <span>Phone Number:</span> ${associateDetails.phoneNumber}
        </div>
        <div class="detail-item">
            <span>Date of Birth:</span> ${associateDetails.dob}
        </div>
        <div class="detail-item">
            <span>Address:</span> ${associateDetails.address}
        </div>
        <div class="detail-item">
            <span>Date of Joining:</span> ${associateDetails.dateOfJoining}
        </div>
    </div>
    <a href="associateHome.jsp" class="back-button">Back</a> <!-- Adjust href as needed -->
</body>
</html>