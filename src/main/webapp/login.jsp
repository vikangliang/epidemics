<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/2/27
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登入</title>
</head>
<body>
<div id="controller">
    <form action="${pageContext.request.contextPath}/user/login" method="post">
        账号：<input type="text" name="account"><br>
        密码：<input type="password" name="password"><br>
        <input type="submit" value="登录">
    </form>
    ${msg}
</div>
</body>
</html>
