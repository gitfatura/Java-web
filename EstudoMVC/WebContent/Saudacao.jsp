<%--Diretiva --%>
<%@page import="java.util.Calendar, java.util.Date, java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta >
<title>contador</title>
</head>
<body>

<%--Declaração --%>
<%! 
    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy hh:mm");
public String getMensagem(JspWriter out){
	try{
	out.print("teste");
	}catch(Exception e){}
	return "Bem Vindo!";
}

%>


<%--Scriptlet --%>
<%
	Calendar calendar = Calendar.getInstance();
	int hora = calendar.get(Calendar.HOUR_OF_DAY);
	String mensagem = "";
	if(hora > 18){
		mensagem = "Boa noite ";
	}else if(hora >12){
		mensagem = "Boa tarde";
	}else {
		mensagem = "Bom dia";
	}
%>
<%--Expressão --%>
<h1><%=getMensagem(out) %></h1>
<h3><%=mensagem %></h3>
<p><%out.println("Agora são "+fmt.format(calendar.getTime())); %></p>


</body>
</html>