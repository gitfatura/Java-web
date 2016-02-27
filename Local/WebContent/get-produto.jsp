<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>Estoque de Produto</title>	 
	<link rel="stylesheet" href="_css/estilo.css" />
	<script type="text/javascript" src="_js/validacao.js"></script>
	
</head>
<body>
	<div>
		<a href="Home.jsp">Home</a><br/><br/>
	 

		<form  action="get-id-produto" method="get" name="formulario" onsubmit="return(validaInputProdutoPesquisa());">
			
			
			<a class="link-a" id="ldescricao"></a>
			
			<c:if test="${not empty erro_id}">
			<a class="link-a">${erro_id}</a>
			</c:if><br/>
			
			<input type="text" name="id" id="id"  class="campo" size="40" 
			placeholder="Digite o id do produto" onclick="return(limpaInput());">
						
			<button type="submit" class="botao">Pesquisar</button><br/><br/>

			<a class="link-a">Id:</a><br/>
			<input type="text" name="idd" class="campo" value="${produto.id}" disabled="disabled"><br/>
			<a class="link-a">Descrição:</a><br/>
			<input type="text" name="descricao" class="campo" value="${produto.descricao}"><br/>
			<a class="link-a">Quantidade:</a><br/>
			<input type="text" name="quantidade" class="campo" value="${produto.quantidade}"><br/>
			<a class="link-a">Valor:</a><br/>  
			<input type="text" name="valor" class="campo" value="${produto.valor}"><br/>
			<a class="link-a">Data:</a><br/>    
			<input type="text" name="data" class="campo" value="${produto.data}"><br/>    
		</form>
	</div>
</body>
<% session.removeAttribute("erro_id");%>
</html>