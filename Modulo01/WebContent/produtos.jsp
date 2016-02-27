<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="meucss.css">
<title>Produtos</title>
</head>
<body>


<form action="produtos" method="get">
 
	<h1>Lista de produtos</h1>
	<a href="index.html">Home</a><br/><br/><br/>	
	<a href="./novo">Novo</a><br/>
		
	<table>
		<thead>
			<tr>
				<th>Codigo</th>
				<th>Descrição</th>
				<th>Quantidade</th>
				<th>Preço</th>
				<th>Total</th>
				<th>Data</th>
				<th>Opção</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="produto" items="${produtos}">
				<tr>
					<td>${produto.id}</td>					
					<td><a href="<c:url value="/editar?id=${produto.id}"/>">${produto.descricao}</a></td>
					<td>${produto.quantidade}</td>
					<td>${produto.preco}</td>
					<td>${produto.total}</td>
					<td>${produto.data}</td>
					<td><a href="<c:url value="/remover?id=${produto.id}"/> "onclick="return confirm('Deseja excluir produto : ${produto.descricao}')">Excluir</a></td>					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</form>
</body>
</html>