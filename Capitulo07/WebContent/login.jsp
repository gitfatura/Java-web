
<!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
<meta charset="iso-8859-1">

<link href="./meucss.css" rel="stylesheet">
<title>Login</title>

</head>
<body>
<h1>Agenda contatos</h1>
<h3>Login</h3>
${initParam.instrutor }
<form action="autenticar" method="post">
<c:if test="${not empty login_erro }">
<p class="erro">${login_erro}</p>
</c:if>
Nome: <input type="text" name="nome"><br/>
Senha: <input type="password" name="senha"><br/>
<input type="submit" value="Entrar"><br/>
</form>
</body>
<%session.removeAttribute("login_erro"); %>
</html>