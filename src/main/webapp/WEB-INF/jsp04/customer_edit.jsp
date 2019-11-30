<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="BASE" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>客户编辑页面</title>
</head>
<body>
    <h3>客户信息</h3>
    <form method="post" action="${BASE}/cs04/toEdit">
            <input type="hidden" value="${customer.id}" name="id"/>
        名称：<input type="text" value="${customer.name}" name="name"/><br>
        联系人: <input type="text" value="${customer.contact}" name="contact"/><br>
        手机号码: <input type="text" value="${customer.telephone}"name="telephone"/><br>
        邮件: <input type="text" value="${customer.email}" name="email"/><br>
        备注: <input type="text" value="${customer.remark}" name="remark"/><br>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
