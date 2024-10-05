<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <style>
        * {box-sizing: border-box}

        /* Add padding to containers */
        .container {
            padding: 16px;
            width: 100%;
            max-width: 600px;
            margin: auto;
        }

        /* Full-width input fields */
        input[type=text], input[type=password] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 22px 0;
            display: inline-block;
            border: none;
            background: #f1f1f1;
        }

        input[type=text]:focus, input[type=password]:focus {
            background-color: #ddd;
            outline: none;
        }

        /* Overwrite default styles of hr */
        hr {
            border: 1px solid #f1f1f1;
            margin-bottom: 25px;
        }

        /* Set a style for the submit/register button */
        .registerbtn {
            background-color: #04AA6D;
            color: white;
            padding: 16px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
            opacity: 0.9;
        }

        .registerbtn:hover {
            opacity:1;
        }

        /* Add a blue text color to links */
        a {
            color: dodgerblue;
        }

        /* Set a grey background color and center the text of the "sign in" section */
        .signin {
            background-color: #f1f1f1;
            text-align: center;
        }
        .roles {
            display: flex;
            justify-content: space-between;
            flex-wrap: wrap;
        }

        .roles label {
            display: inline-block;
            margin-right: 10px;
            margin-bottom: 10px;
            padding: 5px 10px;
            background-color: #f0f0f0;
            border-radius: 5px;
        }

        input[type="checkbox"] {
            margin-right: 5px;
        }
    </style>
</head>
<body>
<form action="/LTWebProject/register" method="post">


    <div class="container">
        <h1>Đăng ký</h1>
        <p>Vui lòng điền vào mẫu này để tạo tài khoản.</p>
        <hr>
        <c:if test=
                      "${alert !=null}">
            <h3 class="alert alertdanger">${alert}</h3>
        </c:if>
        <label for="username"><b>User name</b></label>
        <input type="text" placeholder="Điền Username" name="username" id="username" required>
        <label for="username"><b>Họ và tên</b></label>
        <input type="text" placeholder="Điền Họ và tên" name="fullname" id="fullname" required>

        <label for="email"><b>Email</b></label>
        <input type="text" placeholder="Điền Email" name="email" id="email" required>

        <label for="psw"><b>Mật khẩu</b></label>
        <input type="password" placeholder="Enter Mật khẩu" name="psw" id="psw" required>

        <label for="psw-repeat"><b>Nhập lại mật khẩu</b></label>
        <input type="password" placeholder="Nhập lại mật khẩu" name="psw-repeat" id="psw-repeat" required>
        <hr>
        <hr>

        <p>Chọn nhiệm vụ:</p>
        <div class="roles">
            <label><input type="checkbox" name="roleid" value="1"> Admin</label>
            <label><input type="checkbox" name="roleid" value="2"> Manager</label>
            <label><input type="checkbox" name="roleid" value="3"> Seller</label>
            <label><input type="checkbox" name="roleid" value="4"> Shipper</label>
            <label><input type="checkbox" name="roleid" value="5"> User</label>
        </div>

        <hr>
        <button type="submit" class="registerbtn">Đăng ký</button>
    </div>

    <div class="container signin">
        <p>Bạn đã có tài khoản? <a href=${pageContext.request.contextPath }/login>Đăng nhập</a>.</p>
    </div>
</form>
</body>
</html>
