<%--
  Created by IntelliJ IDEA.
  User: Victor
  Date: 2019/11/28
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户编辑页面</title>
</head>
<body>
    <h3>客户信息</h3>
    <form method="post" action="customer_edit">
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
