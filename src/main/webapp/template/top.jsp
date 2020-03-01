<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/2/28
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div class="row" style="background: #2aabd2; margin-bottom: 3px">
    <div class="col-md-6 logo" style="background-color: #8a6d3b">疫情发布系统后台管理</div>
    <div class="col-md-2 col-md-offset-4">
        <span>欢迎您：<span class="label label-info">${loginuser.userName}</span></span><br>
        <a href="${pageContext.request.contextPath}/user/logout" class="btn btn-danger">退出</a>
    </div>
</div>