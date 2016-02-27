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
	Este comentário vai para o browser (Comentário HTML)
-->

<%--Este é um comentário JSP (não vai para o browser) --%>
<%--uso de Scriptlet --%>
<h1><%
	String mensagem = "Hello World";
	out.print(mensagem);
%></h1>

<%--uso de Exressão   --%>
<h3><%="Teste123" %></h3>


</body>
</html>