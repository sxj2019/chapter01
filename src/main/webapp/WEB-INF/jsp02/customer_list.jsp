<%--
  Created by IntelliJ IDEA.
  User: Victor
  Date: 2019/11/28
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="BASE" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>客户列表</title>

</head>
<body>
    <table border="1">
        <caption>客户列表</caption>
        <tr>
            <th>客户名称</th>
            <th>联系人</th>
            <th>手机号码</th>
            <th>邮件</th>
            <th>备注</th>
            <th>操作</th>
        </tr>
        <c:forEach var="cs" items="${customers}">
            <tr>
                <td>${cs.name}</td>
                <td>${cs.contact}</td>
                <td>${cs.telephone}</td>
                <td>${cs.email}</td>
                <td>${cs.remark}</td>
                <td><a href="${BASE}/cs?action=toEdit&id=${cs.id}">编辑</a>
                    <a href="${BASE}/cs?action=delData&id=${cs.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <button onclick="javascript: window.location.href='${BASE}/cs?action=toAdd'">新增</button>
</body>
</html>
