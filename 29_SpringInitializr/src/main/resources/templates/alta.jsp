<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PÁGINA DE ALTA</title>
</head>
<body>
<h1>PÁGINA DE ALTA</h1>
<form:form action="Alta" modelAttribute="persona" method="post" >
<form:errors  element="span"/>
<form:label path="id"/><form:input path="id"/><form:errors path="id"/>
<form:input path="nombre"/>
<form:input path="edad"/>
<form:input path="altura"/>
<form:select path="genero" items="${generos}"/>
<form:button value="Enviar" />
</form:form>
</body>
</html>