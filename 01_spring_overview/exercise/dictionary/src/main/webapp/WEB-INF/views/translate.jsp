<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/9/2022
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Vietnamese Dictionary</h2>
<form method="post">
    <input type="text" name="english" placeholder="Nhập tiếng anh: "/><br><br>
    <input type="submit" id="submit" value="Search"/><br><br>
    <span style="">result : ${result}</span>
</form>
</body>
</html>
