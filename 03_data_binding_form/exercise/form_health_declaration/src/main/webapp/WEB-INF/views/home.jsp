<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="shortcut icon"
          href="https://tokhaiyte.vn/upload/2001432/Image/logoboyte.png">
    <title>Danh sách tờ khai y tế</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
    <link rel="stylesheet" href="../../../bootstrap-5.0.2-dist/css/bootstrap.css">

    <link rel="stylesheet" href="../bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap5.css"/>

    <style>
        td {
            text-align: center;
        }

        th {
            text-align: center;
        }

        body {
            background-image: url("https://salt.tikicdn.com/ts/product/64/93/6f/c8053c849a71a0e69c43d937d99666e3.jpg");
            font-family: Arial, sans-serif;

        }
    </style>
</head>
<body>
<h2 class="text-center" style="transform: translateY(30%)">DANH SÁCH TỜ KHAI Y TẾ</h2>
<a href="/show-create">
    <button class="btn btn-info">
        Thêm mới
    </button>
</a>
<table id="tableStudent" class="table table-striped  table-bordered">
    <thead>
    <tr class="bg-info">
        <th style="text-align: center;">STT</th>
        <th style="text-align: center;">Họ tên</th>
        <th style="text-align: center;">Năm sinh</th>
        <th style="text-align: center;">Giới tính</th>
        <th style="text-align: center;">Quốc gia</th>
        <th style="text-align: center;">Số CMND</th>
        <th style="text-align: center;">Phương tiện</th>
        <th style="text-align: center;">Số hiệu</th>
        <th style="text-align: center;">Số chỗ ngồi</th>
<%--        <th style="text-align: center;">Ngày khởi hành</th>--%>
<%--        <th style="text-align: center;">Tháng khởi hành</th>--%>
<%--        <th style="text-align: center;">Năm khởi hành</th>--%>
<%--        <th style="text-align: center;">Ngày kết thúc</th>--%>
<%--        <th style="text-align: center;">Tháng kết thúc</th>--%>
<%--        <th style="text-align: center;">Năm kết thúc</th>--%>
        <th style="text-align: center;">Thông tin di chuyển</th>
        <th style="text-align: center;">Chỉnh sửa</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${medicalDeclarationList}" var="medical" varStatus="stt">
        <tr>
            <td>${stt.count}</td>
            <td>${medical.name}</td>
            <td>${medical.birthday}</td>
            <td>${medical.gender}</td>
            <td>${medical.country}</td>
            <td>${medical.identity}</td>
            <td>${medical.render}</td>
            <td>${medical.vehicleNumber}</td>
            <td>${medical.seats}</td>
<%--            <td>${medical.starDay}</td>--%>
<%--            <td>${medical.starMonth}</td>--%>
<%--            <td>${medical.starYear}</td>--%>
<%--            <td>${medical.endDay}</td>--%>
<%--            <td>${medical.endMonth}</td>--%>
<%--            <td>${medical.endYear}</td>--%>
            <td>${medical.information}</td>
            <td>
                <a href="/update?identity=${medical.identity}">
                    <button class="btn btn-info">
                        <i class="fa-solid fa-file-pen"></i>
                    </button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script src="../jquery/jquery-3.5.1.min.js"></script>
<script src="../datatables/js/jquery.dataTables.min.js"></script>
<script src="../datatables/js/dataTables.bootstrap5.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

<script>
    $(document).ready(function () {
        $('#tableStudent').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</body>
</html>