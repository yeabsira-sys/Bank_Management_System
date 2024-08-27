<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Footer</title>
    <!-- Add your CSS links here -->
</head>
<body>
    <div class="footercontainer">
        <div class="userinfo">
            <div class="logout">
                <form action="" method="post">
                    <input type="submit" name="logout" value="Logout" class="logoutbtn">
                </form>
                <% 
                if (request.getParameter("logout") != null) {
                    response.sendRedirect("Home");
                }
                %>
            </div>
            <div class="username">
                <% 
                String username = (String) session.getAttribute("username");
                if (username != null) {
                    out.println(username);
                }
                %>
            </div>
            <dix class="user">
                <form action="" method="post">
                    <input type="submit" class="userbtn" name="updpass" value="update password">
                </form>
            </dix>
        </div>
        <div class="datetime">
            <div class="jsdate">
                <span id="day">day</span>,
                <span id="date">00</span>
                <span id="month">month</span>,
                <span id="year">0000</span>
            </div>
            <div class="jstime">
                <span id="hour">00</span>:
                <span id="minute">00</span>:
                <span id="seconds">00</span>:
                <span id="ampm">00</span>
            </div>
        </div>
    </div>
    <!-- Add your JavaScript links here -->
</body>
</html>
