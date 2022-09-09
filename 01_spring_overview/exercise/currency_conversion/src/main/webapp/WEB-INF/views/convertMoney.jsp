<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/9/2022
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Currency Converter</h2>
<form method="get" action="/result">
    <label>USD: </label>
    <input type="number" name="usd" placeholder="USD" value="${usd}" /><br/><br/>
    <label>VND: </label>
    <input type="number" name="convertMoney" value="${convertMoney}"  placeholder="VND"><br><br/>
    <input type = "submit" id = "submit" value = "Converter"/>
</form>
</body>
</html>
