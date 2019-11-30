<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="BASE" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>客户新增页面</title>
</head>
<body>
    <h3>客户信息</h3>
    <form method="post" action="${BASE}/cs03/toAdd">
        名称：<input type="text" name="name"/><br>
        联系人: <input type="text" name="contact"/><br>
        手机号码: <input type="text" name="telephone"/><br>
        邮件: <input type="text" name="email"/><br>
        备注: <input type="text" name="remark"/><br>
        <input type="submit" value="提交">
    </form>

</body>
</html>
