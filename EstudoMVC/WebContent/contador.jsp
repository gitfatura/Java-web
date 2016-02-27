<%@page import="java.util.Date, java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta >
<title>contador</title>
</head>
<body>

<%! int contador = 0; 
    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
public String getMensagem(){
	return "Bem Vindo!";
}

%>

<h1><%=getMensagem() %> Você é o  visitante número <%= ++contador %></h1>
<%out.println(fmt.format(new Date())); %>


</body>
</html>