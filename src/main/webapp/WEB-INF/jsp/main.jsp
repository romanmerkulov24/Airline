<%--
  Created by IntelliJ IDEA.
  User: Рома
  Date: 15.06.2018
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная страница</title>
</head>
<body>
<h2><centre>
    Вы успешно вошли!
    <a href="admin/registration">Добавить нового пользователя</a>
</centre></h2>

<br>
<c:forEach items='${test}' var="j">
    <c:out value='${j}'/>
</c:forEach>
</body>
</html>
