<%--
  Created by IntelliJ IDEA.
  User: HoaiTan
  Date: 21/09/2024
  Time: 1:59 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@taglib prefix="fn" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Forgot Password</title>
    <style>
        {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f5f7fa;
        }

        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #f5f7fa;
            width: 100%;
            height: 100%;
        }

        .reset-box {
            background-color: white;
            border-radius: 8px;
            padding: 40px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 350px;
            text-align: center;
        }

        .logo img {
            width: 50px;
            height: 50px;
        }

        h2 {
            margin-top: 10px;
            font-size: 24px;
            color: #333;
        }

        p {
            margin-bottom: 20px;
            color: #666;
            font-size: 14px;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        input {
            margin-bottom: 15px;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 14px;
        }

        button {
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }

    </style>
</head>
<body>
    <div class="container">
        <div class="reset-box">
            <div class="logo">
                <img src="https://via.placeholder.com/50" alt="Logo">
            </div>
            <h2>Reset Password</h2>
            <p>Reset your password if you forgot them,</p>
            <form action="/LTWebProject/forgotPassword" method="post">
                <c:if test="${alert !=null}">
                    <h3 class="alert alertdanger">${alert}</h3>
                </c:if>
                <input type="email" name="email" placeholder="Email" required>
                <input type="password" name="password" placeholder="Password" required>
                <input type="password" name="confirmPassword" placeholder="Confirm Password" required>
                <button type="submit">Reset Password</button>
            </form>
        </div>
    </div>
</body>
</html>
