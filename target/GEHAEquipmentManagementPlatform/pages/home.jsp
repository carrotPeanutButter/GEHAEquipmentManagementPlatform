<%--
  User: Yemao Luo
  Date: 2021/10/18
  Time: 16:52
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    function findAllUser() {
        window.location.href = "${pageContext.request.contextPath}/user/findAllUser"
    }

    function userCRUD() {
        let role = ${user.role};
        if (role === "管理员") {
            window.location.href = "${pageContext.request.contextPath}/user/userCRUD"
        } else {
            document.getElementById("CRUD_msg").innerText = "您没有权限";
        }
    }
</script>
<html>
<head>
    <title>home</title>
</head>
<body>
<h1>this is home hello ${user.name} !</h1>
<hr>
<button onclick="findAllUser()">查询所有用户</button>
<span style="color: red">${msg_findAllUser.message}</span>
<hr>
<button onclick="userCRUD()">用户CRUD</button>
<span style="color: red" id="CRUD_msg"></span>
</body>
</html>