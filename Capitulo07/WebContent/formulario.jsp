<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario</title>
<style>
.erro{
	color: red;
}
input {
margin: 5px 5px 5px 5px;
}
</style>
</head>
<body>
<h1>${mensagem}</h1>
<form action="salvar" method="post">
	<input type="hidden" name="id"  value="${contato.id }"><br/>
	Nome <input type="text" name="nome"  value="${contato.nome }"><br/>
	<c:if test="${not empty nome_erro }">
	<p class="erro"> ${nome_erro }</p>
	</c:if>
	Email <input type="text" name="email"  value="${contato.email }"><br/>
	<c:if test="${not empty email_erro }">
	<p class="erro"> ${email_erro }</p>
	</c:if>
	Telefone <input type="text" name="telefone"  value="${contato.telefone }"><br/>
	<c:if test="${not empty telefone_erro }">
	<p class="erro"> ${telefone_erro }</p>
	</c:if>
	<input type="submit" value="Enviar">
</form>

</body>
<%session.removeAttribute("nome_erro"); %>
<%session.removeAttribute("email_erro"); %>
<%session.removeAttribute("telefone_erro"); %>
</html>