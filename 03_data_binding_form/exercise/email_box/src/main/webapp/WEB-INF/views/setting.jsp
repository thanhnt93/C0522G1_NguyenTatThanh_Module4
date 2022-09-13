<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 05/05/2022
  Time: 10:26 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <style>
        body {
            background-color: #e3e3ff;
            font-family: Arial, sans-serif
        }
    </style>

</head>
<body>
<form:form modelAttribute="mail" method="post" action="/update">
    <table class="table" style="border: #e3e3ff solid 2px">
        <tr>
            <td><h2>Settings</h2></td>
            <td></td>
        </tr>
        <tr>
            <td><b>Languages : </b></td>
            <td style="transform: translateX(-400px);">
                <form:select path="languages">
                    <form:option value="English" label="English"/>
                    <form:option value="Vietnamese" label="Vietnamese"/>
                    <form:option value="Korea" label="Korea"/>
                </form:select>
            </td>
        </tr>

        <tr>
            <td><b> Page Size: </b></td>
            <td style="transform: translateX(-400px)">
                <label>Show</label>
                <form:select path="pageSize">
                    <form:option value="5" label="5"/>
                    <form:option value="10" label="10"/>
                    <form:option value="15" label="15"/>
                    <form:option value="25" label="25"/>
                    <form:option value="50" label="50"/>
                    <form:option value="100" label="100"/>
                </form:select>
                emails per page
            </td>
        </tr>
        <tr>
            <td>
                <b> Spams filter: </b>
            </td>
            <td style="transform: translateX(-400px)">
                <form:checkbox path="spamsFilter" value="spamsFilter"/>
                Enable spams filter
            </td>
        </tr>
        <tr>
            <td>
                <b> Signature: </b>
            </td>
            <td style="transform: translateX(-400px)">
                <form:textarea path="signature"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td style="transform: translateX(-400px)">
                <button type="submit" style="border-radius: 10px; height: 25px; background-color: aqua">Update</button>
                <button type="reset" style="border-radius: 10px; height: 25px;transform: translateX(20px) ">Cancel</button>
            </td>
        </tr>
    </table>
</form:form>
<table class="table" style="border: #e3e3ff solid 2px">
    <tr>
        <h6> Language : ${mail.languages}</h6>

        <h6> PageSize : ${mail.pageSize}</h6>

        <h6> SpamsFilter : ${mail.spamsFilter}</h6>

        <h6> Signature : ${mail.signature}</h6>
    </tr>
</table>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

</body>
</html>