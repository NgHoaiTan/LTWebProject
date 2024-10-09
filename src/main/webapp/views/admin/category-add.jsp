<%--
  Created by IntelliJ IDEA.
  User: NguyenHoaiTan
  Date: 30/09/2024
  Time: 9:07 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/commons/taglib.jsp"%>

<form action="<c:url value="/admin/category/insert"/>" method="post" enctype="multipart/form-data">
  <label for="categoryname">Category name</label><br>
  <input type="text" id="categoryname" name="categoryname"><br>
  <label for="images">Upload file:</label><br>
  <img height="150" width="200" src="" id="imagess"/>
  <input type="file" onchange="chooseFile(this)" id="images" name="images"> <br>

  <label for="status">Status:</label><br>
  <input type="radio" id=statuson" name="status" value="1">
  <label for="status">Hoạt động</label><br>
  <input type="radio" id=statusoff" name="status" value="0">
  <label for="status">Khóa</label><br>
  <input type="submit" value="Insert">
</form>
