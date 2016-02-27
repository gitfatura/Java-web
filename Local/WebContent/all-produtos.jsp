<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>Estoque de Produto</title>	 
	<link rel="stylesheet" href="_css/estilo.css" />
</head>
<body>
	<div class="div">
	
		<a href="Home.jsp">Home</a>
		<a href="./new-produto">Novo Produto</a><br/><br/>
		
		<form  action="get-produto" method="get">
			
			<input type="text" name="descricao" id="descricao" class="campo" size="40" placeholder="Digite a descrição do produto">
			
			<button type="submit" class="botao">Pesquisar</button><br/><br/>
			<table>
				<tbody>
					<tr>
						<th>ID</th>
						<th>DESCRIÇÃO</th>
						<th>QUANTIDADE</th>
						<th>VALOR</th>
						<th>DATA</th>
						<th>OPÇÃO</th>
					</tr>
					<c:forEach var="produto" items="${produtos}">
						<tr>
							<td>${produto.id}</td>
							<td class="a.tooltip"><a href="<c:url value="/id-produto?id=${produto.id}"/>">${produto.descricao}</a></td>
							<td>${produto.quantidade}</td>
							<td>R$ ${produto.valor}</td>
							<td>${produto.data}</td>
							<td><a class="a-a" href="<c:url value="/id-input-produto?id=${produto.id}"/>">Entrada</a>
							<a class="a-a" href="<c:url value="/id-decrease-produto?id=${produto.id}"/>">Baixa</a>
							<a class="a-a" href="<c:url value="/remove-produto?id=${produto.id}"/>" onclick="return confirm('Deseja excluir produto:  ${produto.descricao}')">Excluir</a></td>		
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>