<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta >
<title>Hello World</title>
</head>
<body>
<!--  
	Este coment�rio vai para o browser (Coment�rio HTML)
-->

<%--Este � um coment�rio JSP (n�o vai para o browser) --%>
<%--uso de Scriptlet --%>
<h1><%
	String mensagem = "Hello World";
	out.print(mensagem);
%></h1>

<%--uso de Exress�o   --%>
<h3><%="Teste123" %></h3>


</body>
</html>