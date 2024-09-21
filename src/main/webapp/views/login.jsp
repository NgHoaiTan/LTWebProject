<%--
  Created by IntelliJ IDEA.
  User: HoaiTan
  Date: 19/09/2024
  Time: 12:53 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@taglib prefix="fn" uri="jakarta.tags.functions"%>
<html>
<head>
    <title>Title</title>
    <style>
        /* Global Styles */
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background: url('https://www.w3schools.com/w3images/mountains.jpg') no-repeat center center fixed;
            background-size: cover;
        }

        .login-container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .login-box {
            background-color: rgba(0, 0, 0, 0.7);
            padding: 40px;
            border-radius: 10px;
            text-align: center;
            width: 350px;
            color: white;
        }

        .login-box h2 {
            margin-bottom: 20px;
            font-size: 26px;
        }

        .input-box {
            position: relative;
            margin-bottom: 20px;
        }

        .input-box input {
            width: 100%;
            padding: 10px 35px;
            background-color: rgba(255, 255, 255, 0.1);
            border: none;
            border-radius: 5px;
            color: white;
            font-size: 16px;
        }

        .input-box .icon {
            position: absolute;
            left: 10px;
            top: 50%;
            transform: translateY(-50%);
            color: white;
            font-size: 20px;
        }

        .options {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }

        .options label {
            font-size: 14px;
        }

        .options .forgot-password {
            color: white;
            text-decoration: none;
            font-size: 14px;
        }

        .btn-login {
            background-color: #f63535;
            color: white;
            padding: 10px;
            width: 100%;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        .btn-login:hover {
            background-color: #ff4545;
        }

        .social-login {
            margin-top: 20px;
        }

        .social-login p {
            color: white;
            margin-bottom: 10px;
        }

        .social-buttons {
            display: flex;
            justify-content: space-around;
        }

        .social-buttons button {
            background-color: #4267B2;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        .btn-facebook {
            background-color: #4267B2;
        }

        .btn-twitter {
            background-color: #1DA1F2;
        }

        .social-buttons button:hover {
            opacity: 0.8;
        }

    </style>
</head>
<body>
<form action="/LTWebProject/login" method="post">
    <%--<div class="imgcontainer">
        <img src="img_avatar2.png" alt="Avatar" class="avatar">
    </div>
--%>
        <c:if test=
                      "${alert !=null}">
            <h3 class="alert alertdanger">${alert}</h3>
        </c:if>
        <div class="login-container">
            <div class="login-box">
                <h2>Login</h2>
                <form>
                    <div class="input-box">
                        <i class="fa fa-user icon"></i>
                        <input type="text" name="username" placeholder="User name" required>
                    </div>
                    <div class="input-box">
                        <i class="fa fa-lock icon"></i>
                        <input type="password" name="password" placeholder="Password" required>
                    </div>
                    <div class="options">
                        <label>
                            <input type="checkbox" name="remember"> Remember me
                        </label>
                        <a href="#" class="forgot-password">Forgot Password?</a>
                    </div>
                    <button type="submit" class="btn-login">Login</button>
                </form>
                <div class="social-login">
                    <p>or</p>
                    <div class="social-buttons">
                        <button class="btn-facebook">Facebook</button>
                        <button class="btn-twitter">Twitter</button>
                    </div>
                </div>
            </div>
        </div>
</form>

</body>
</html>
