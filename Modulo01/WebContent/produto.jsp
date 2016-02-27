<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="meucss.css"/>
<script type="text/javascript" src="moeda.js"></script>
<title>Produto</title>
</head>
<body>
<form action="salvar" method="post">
<a href="index.html">Home</a>
	
	<input type="hidden" name="id"  value="${produto.id}"><br/>
	<input type="text" name="descricao" value="${produto.descricao}" placeholder="descricao" required="required"/><br/>
	<input type="text" name="quantidade" value="${produto.quantidade}" placeholder="quantidade" required="required"/><br/>
	<input type="text" name="preco" value="${produto.preco}" placeholder="preco" required="required"/><br/>
	<input type="text" name="total" value="${produto.total}" placeholder="total" required="required"/><br/>
	<input type="submit" value="Salvar"><br/>
		
</form>
</body>
</html>