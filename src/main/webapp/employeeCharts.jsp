<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Tasks Details</title>
    <style>
        .container {
            display: flex;
            justify-content: space-around;
            align-items: flex-start;
        }
        .chart-container {
            width: 35%;
        }
        .details-container {
            width: 50%;
            margin-left: 20px;
        }
        .button {
            display: inline-block;
            padding: 8px 12px;
            margin: 4px 2px;
            border-radius: 4px;
            background-color: #4CAF50;
            color: white;
            text-align: center;
            text-decoration: none;
            font-size: 14px;
        }
    </style>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
    <h2>Employee Tasks Details</h2>
    <div class="container">
        <div class="chart-container">
            <canvas id="taskPieChart"></canvas>
            <canvas id="taskBarChart" style="margin-top: 20px;"></canvas>
        </div>
        <div class="details-container" id="taskDetailsContainer">
            <h3>Task Details</h3>
            <!-- Task details table will be injected here -->
        </div>
    </div>

    <%
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Map<String, Integer> empidCountMap = new HashMap<>();
        List<String> empidList = new ArrayList<>();
        List<String> dateList = new ArrayList<>();
        List<String> startTimeList = new ArrayList<>();
        List<String> endTimeList = new ArrayList<>();
        StringBuilder labelsBuilder = new StringBuilder();
        StringBuilder dataBuilder = new StringBuilder();

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the database
            String url = "jdbc:mysql://localhost:3306/bankdb"; // Update with your database URL
            String user = "root"; // Update with your database username
            String password = "Honey@1510"; // Update with your database password
            conn = DriverManager.getConnection(url, user, password);

            // Create SQL statement
            stmt = conn.createStatement();
            String sql = "SELECT empid, date, start_time, end_time FROM employee_tasks"; // Use the correct table name
            rs = stmt.executeQuery(sql);

            // Iterate through the result set and count the occurrences of each empid
            while (rs.next()) {
                String empid = rs.getString("empid");
                String date = rs.getString("date");
                String startTime = rs.getString("start_time");
                String endTime = rs.getString("end_time");
                empidList.add(empid);
                dateList.add(date);
                startTimeList.add(startTime);
                endTimeList.add(endTime);
                empidCountMap.put(empid, empidCountMap.getOrDefault(empid, 0) + 1);
            }

            // Prepare data for the pie chart
            for (Map.Entry<String, Integer> entry : empidCountMap.entrySet()) {
                labelsBuilder.append("'").append(entry.getKey()).append("',");
                dataBuilder.append(entry.getValue()).append(",");
            }

            // Remove the last comma
            if (labelsBuilder.length() > 0) {
                labelsBuilder.setLength(labelsBuilder.length() - 1);
            }
            if (dataBuilder.length() > 0) {
                dataBuilder.setLength(dataBuilder.length() - 1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            out.println("<p>Error loading database driver: " + e.getMessage() + "</p>");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<p>SQL error: " + e.getMessage() + "</p>");
        } finally {
            // Close ResultSet, Statement, and Connection
            if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
            if (stmt != null) try { stmt.close(); } catch (SQLException ignore) {}
            if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
        }
    %>

    <script>
        document.addEventListener('DOMContentLoaded', function() {
            var ctxPie = document.getElementById('taskPieChart').getContext('2d');
            var ctxBar = document.getElementById('taskBarChart').getContext('2d');

            // Pie chart data
            var labelsPie = [<%= labelsBuilder.toString() %>];
            var dataPie = [<%= dataBuilder.toString() %>];

            var pieData = {
                labels: labelsPie,
                datasets: [{
                    label: 'Task Count by Employee',
                    data: dataPie,
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 1
                }]
            };

            new Chart(ctxPie, {
                type: 'pie',
                data: pieData,
                options: {
                    responsive: true,
                    plugins: {
                        legend: {
                            position: 'top',
                        },
                        title: {
                            display: true,
                            text: 'Employee Task Count Distribution'
                        }
                    }
                },
            });



            // Inject the task details table into the details container
            var taskDetailsContainer = document.getElementById('taskDetailsContainer');
            taskDetailsContainer.innerHTML += `<table border="1">
                <tr>
                    <th>Employee ID</th>
                    <th>Date</th>
                    <th>Start Time</th>
                    <th>End Time</th>
                </tr>
                <% for (int i = 0; i < empidList.size(); i++) { %>
                <tr>
                    <td><%= empidList.get(i) %></td>
                    <td><%= dateList.get(i) %></td>
                    <td><%= startTimeList.get(i) %></td>
                    <td><%= endTimeList.get(i) %></td>
                </tr>
                <% } %>
            </table>`;
        });
    </script>

    <a href="employeeDetails.jsp" class="button">Back to Employee Details</a>
</body>
</html>