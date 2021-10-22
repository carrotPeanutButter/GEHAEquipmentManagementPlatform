<%--
  User: Yemao Luo
  Date: 2021/10/22
  Time: 9:38
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>BRCRUD</title>
</head>
<body>
<button id="back">返回</button>
<hr>
<h1>借设备</h1>
<form action="/br/bEquipment" method="post">
    <select name="id">
        <c:forEach items="${NotInUseList}" var="equipment">
            <option value="${equipment.id}">${equipment.id}.${equipment.name}</option>
        </c:forEach>
    </select>
    <input type="submit" value="借用">
    <span style="color: red">${msg_bEquipment.message}</span>
</form>
<br>
<hr>

<div style="position: fixed; bottom: 1px;">
    <span style="font-size: 20px; text-align: center">@CopyRight GEHA GDSYZX 2021</span>
</div>
</body>
</html>
<script>
    window.onload = function () {
        document.getElementById("back").onclick = function () {
            location.href = "/equipment/toHome";
        }
    }
</script>
