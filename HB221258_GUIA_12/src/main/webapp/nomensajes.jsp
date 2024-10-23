<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><fmt:message key="nohaymensajes" /></title>
</head>
<body>
<center>
    <h2><fmt:message key="nomensajes" /> <c:out value="${nombre}"/> </h2>
    <br><br><br>
    <a href="inicio.jsp"><fmt:message key="inicio" /></a>
</center>
</body>
</html>