<%--
  Created by IntelliJ IDEA.
  User: HoaiTan
  Date: 19/09/2024
  Time: 11:10 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        /* Thiết lập chung cho toàn bộ trang */
        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(to right, #6a11cb, #2575fc);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            color: #fff;
        }

        /* Container chứa form */
        .form-container {
            background-color: #fff;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
            width: 400px;
            color: #333;
        }

        /* Tiêu đề của form */
        .form-container h2 {
            text-align: center;
            color: #2575fc;
            font-size: 24px;
            margin-bottom: 20px;
        }

        /* Style cho các nhãn label */
        .form-container label {
            font-size: 14px;
            font-weight: bold;
            color: #666;
            margin-bottom: 5px;
            display: inline-block;
        }

        /* Style cho các trường nhập liệu */
        .form-container input[type="text"],
        .form-container input[type="password"],
        .form-container input[type="email"],
        .form-container input[type="tel"] {
            width: 100%;
            padding: 12px;
            margin: 8px 0;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 14px;
            color: #333;
        }

        /* Hiệu ứng khi người dùng focus vào trường nhập liệu */
        .form-container input[type="text"]:focus,
        .form-container input[type="password"]:focus,
        .form-container input[type="email"]:focus,
        .form-container input[type="tel"]:focus {
            border-color: #6a11cb;
            box-shadow: 0 0 8px rgba(106, 17, 203, 0.2);
            outline: none;
        }

        /* Style cho nút Submit */
        .form-container input[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: #2575fc;
            border: none;
            color: white;
            font-size: 16px;
            font-weight: bold;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            margin-top: 10px;
        }

        /* Hiệu ứng khi di chuột qua nút Submit */
        .form-container input[type="submit"]:hover {
            background-color: #6a11cb;
        }

        /* Thêm khoảng cách giữa các phần tử */
        .form-container input {
            margin-bottom: 20px;
        }

    </style>
</head>
<body>
<form action="/LTWebProject/register" method="post">
    <c:if test=
                  "${alert !=null}">
        <h3 class="alert alertdanger">${alert}</h3>
    </c:if>
    <label for="username">Username:</label><br>
    <input type="text" id="username" name="username" required><br><br>

    <label for="password">Password:</label><br>
    <input type="password" id="password" name="password" required><br><br>

    <label for="email">Email:</label><br>
    <input type="email" id="email" name="email" required><br><br>

    <label for="fullname">Full Name:</label><br>
    <input type="text" id="fullname" name="fullname" required><br><br>

    <label for="phone">Phone Number:</label><br>
    <input type="tel" id="phone" name="phone" required><br><br>

    <input type="submit" value="Register">
</form>
</body>
</html>
