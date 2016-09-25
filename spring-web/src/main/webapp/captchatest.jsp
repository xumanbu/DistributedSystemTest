<%--
  Created by IntelliJ IDEA.
  User: team11
  Date: 2016/9/4
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>验证码测试</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/captcha/doLogin" method="post">

    <input name="captcha" type="text">

    <img src="captcha" onclick="this.src='captcha?d='+new Date().getTime()"/>

    <button type="submit">Login</button>

</form>

</body>
</html>
