<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<style>
.erro {
	color: red;
}

input {
	margin: 5px 5px 5px 5px;
}
</style>

</head>
<body>
<h1>Agenda de contatos</h1><br/>
<h3>Login</h3><br/>
	<form action="autentica" method="post">
	<c:if test="${not empty login_erro}">
			<p class="erro">${login_erro}</p>			
		</c:if>
		
		Login:<input type="text" name="usuario"><br/>	 
		Senha:<input type="password" name="senha"><br/>
		<input type="submit" value="Logar">		 
	</form>
</body>
<%
	session.removeAttribute("login_erro");
%>
</html>