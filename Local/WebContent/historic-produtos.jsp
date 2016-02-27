<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>Historico de Produto</title>	 
	<link rel="stylesheet" href="_css/estilo.css" />
</head>
<body>
	<div class="div">
		<a href="Home.jsp">Home</a>
		 
		<form  action="historic-produto" method="get">

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
					</tr>
					<c:forEach var="produto" items="${produtos}">
						<tr>
							<td>${produto.id}</td>
							<td>${produto.descricao}</td>
							<td>${produto.quantidade}</td>
							<td>R$ ${produto.valor}</td>
							<td>${produto.data}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>