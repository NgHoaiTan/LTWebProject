<%--
  Created by IntelliJ IDEA.
  User: HoaiTan
  Date: 19/09/2024
  Time: 11:10 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@taglib prefix="fn" uri="jakarta.tags.functions"%>
<html>
<head>
    <title>Registration</title>
    <style>
        /* Global Styles */
        body {
            margin: 0;
            padding: 0;
            font-family: 'Arial', sans-serif;
            background: linear-gradient(to right, #7f00ff, #e100ff);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
            padding: 40px;
            width: 500px;
        }

        .registration-box h2 {
            margin-bottom: 20px;
            font-size: 24px;
            color: #333;
            text-align: center;
        }

        .form-row {
            display: flex;
            justify-content: space-between;
        }

        .form-group {
            width: 48%;
        }

        .form-group-role {
            display: flex;
            justify-content: space-around; /* Căn đều khoảng cách giữa các radio button */
            align-items: center;
            margin-top: 10px;
        }

        .role-group {
            display: flex;
            flex-direction: column;
            justify-content: center;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            color: #333;
            font-weight: bold;
        }

        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
            margin-bottom: 15px;
        }

        .form-group-role label {
            display: flex;
            align-items: center;
        }

        .form-group-role input {
            margin-right: 5px;
        }

        .register-btn {
            width: 100%;
            padding: 10px;
            background: linear-gradient(to right, #7f00ff, #e100ff);
            border: none;
            color: white;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 15px;
        }

        .register-btn:hover {
            opacity: 0.9;
        }

    </style>
</head>
<body>
<form action="/LTWebProject/register" method="post">
    <c:if test="${alert !=null}">
        <h3 class="alert alertdanger">${alert}</h3>
    </c:if>

    <div class="container">
        <div class="registration-box">
            <h2>Registration</h2>
            <form>
                <div class="form-row">
                    <div class="form-group">
                        <label for="fullname">Full Name</label>
                        <input type="text" id="fullname" name="fullname" placeholder="Enter your name" required>
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" id="email" name="email" placeholder="Enter your email" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group">
                        <label for="phone">Phone Number</label>
                        <input type="text" id="phone" name="phone" placeholder="Enter your number" required>
                    </div>
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type="text" id="username" name="username" placeholder="Enter your username" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" id="password" name="password" placeholder="Enter your password" required>
                    </div>
                    <div class="form-group">
                        <label for="confirm-password">Confirm Password</label>
                        <input type="password" id="confirm-password" name="cPassword" placeholder="Confirm your password" required>
                    </div>
                </div>
                <div class="form-group role-group">
                    <%--@declare id="role"--%><label for="role">Role</label>
                    <div class="form-group-role">
                        <label><input type="radio" name="role" value="user" required> <b>User</b></label>
                        <label><input type="radio" name="role" value="admin"> <b>Admin</b></label>
                        <label><input type="radio" name="role" value="manager"> <b>Manager</b></label>
                        <label><input type="radio" name="role" value="seller"> <b>Seller</b></label>
                        <label><input type="radio" name="role" value="shipper"> <b>Shipper</b></label>
                    </div>
                </div>
                <button type="submit" class="register-btn">Register</button>
            </form>
        </div>
    </div>

</form>
</body>
</html>
