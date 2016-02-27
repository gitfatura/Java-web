<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta >
<title>contador</title>
<%@ include file="css.html" %>
</head>
<body>

<%@ include file="header.html" %>

<%!
public String getNome(HttpServletRequest request){
	return request.getParameter("nome");
}%>


<%String nome = getNome(request); %>
<h2>Bem vindo <%=nome %>!</h2>
<% if("google".equals(nome)){
	response.sendRedirect("http://google.com.br");
	System.out.println("==> LOG teste");
	}else{
		%>
		
		<%@ include file="header.html" %>
		
		<%
	}
	%>


</body>
</html>