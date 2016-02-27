<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/minhatag.tld" prefix="clarify"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="soma"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>
</title>
</head>
<body>
<clarify:usuario></clarify:usuario>

<soma:TagSoma></soma:TagSoma>

<p>${initParam.instrutor}</p>
${usuarioLogado.usuario}<br/>
<a href="<c:url value="/logoff"/>">Sair</a><br/>
<c:if test="${not empty cookie.ultimo_acesso}">
	<p>Ultimo acesso em ${ cookie.ultimo_acesso.value }</p><br/>
</c:if>

<a href="<c:url value="/contato/novo"/>">Novo Contato</a>
	<c:if test="${not empty contatos}">
		<table>
			<thead>
				<tr>
					<th>Nome</th>
					<th>Email</th>
					<th>Telefone</th>
					<th>Opção</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${contatos}" var="itens">
				 <tr>
				 	<td>${itens.nome}</td>
				 	<td>${itens.email}</td>
				 	<td>${itens.telefone}</td>
				 	<td><a href="<c:url value="/contato/editar?id=${itens.id}"/>">Editar</a>/<a href="<c:url value="/contato/remover?id=${itens.id}"/>">Remover</a></td>				 	
				 </tr>	
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<c:if test="${empty contatos}">
		<h1>Lista vazia</h1>
	</c:if>

</body>
</html>