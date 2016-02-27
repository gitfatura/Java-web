<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Lista de Contatos</title>
</head>
<style>
.table{
	width:100%;
}


.table tr th{
 text-align: left;
}
.table tr td{
 text-align: left;
}

</style>
<body>
<c:if test="${not empty cookie.ultimo_acessso }">
<p>${usuarioLogado.nome }</p>
<p>Último acesso em ${cookie.ultimo_acessso.value }</p>
<p><a href="<c:url value="logoff"/>">Sair</a></p>
</c:if>
<a href="<c:url value="/contato/novo"/>">Novo Contato</a>
<c:if test="${not empty contatos }">

<table class="table">
	<thead>
		<tr>
			<th>Nome</th>
			<th>Email</th>
			<th>Telefone</th>
			<th>Ações</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${contatos}" var="item">
			<tr>
				<td>${item.nome}</td>
				<td>${item.email}</td>
				<td>${item.telefone}</td>
				<td><a href="<c:url value="/contato/editar?id=${item.id }"/>">editar</a>/<a href="<c:url value="/contato/remover?id=${item.id}"/>">remover</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</c:if><c:if test="${empty contatos}">
<h1>Não existem contatos cadastrados</h1>
</c:if>
</body>
</html>