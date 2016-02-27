<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="salvar" method="post">
		<input type="hidden" name="id" value="${contato.id}"><br />
		Nome:<input type="text" name="nome" value="${contato.nome}"><br/>
		<c:if test="${not empty nome_erro}">
			<p>${nome_erro}</p>
		</c:if>
		Email:<input type="text" name="email" value="${contato.email}"><br />
		<c:if test="${not empty email_erro}">
			<p>${email_erro}</p>
		</c:if>
		Telefone:<input type="text" name="telefone" value="${contato.telefone}"><br />
		<c:if test="${not empty telefone_erro}">
			<p>${telefone_erro}</p>
		</c:if>

		<input type="submit" value="Salvar">
	</form>
</body>
<%
	session.removeAttribute("nome_erro");
%>
<%
	session.removeAttribute("email_erro");
%>
<%
	session.removeAttribute("telefone_erro");
%>
</html>