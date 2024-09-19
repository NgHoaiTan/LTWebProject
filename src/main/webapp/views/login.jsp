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
    <div class="container">
        <%--@declare id="uname"--%><%--@declare id="psw"--%>
        <label for="uname"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="uname" required>

        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" required>

        <button type="submit">Login</button>
        <label>
            <input type="checkbox" checked="checked" name="remember"> Remember me
        </label>
    </div>

    <div class="container" style="background-color:#f1f1f1">
        <button type="button" class="cancelbtn">Cancel</button>
        <span class="psw">Forgot <a href="#">password?</a></span>
    </div>
</form>

</body>
</html>
