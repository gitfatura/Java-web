<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Entrada de produto</title>
<link rel="stylesheet" href="_css/file.css"/>
<script type="text/javascript" src="_js/validacao.js"></script>
</head>
<body>
<div>

 <section id="des" class="grid clearfix">
    <a href="Home.jsp">Home</a>    
	<a href="./new-produto" class="arf">Novo produto</a>
	<a href="./all-produto">Lista de Produto</a>
  <header>
    <i class="icon-rocket"></i>

    <h1>Entrada de Produto</h1>
  </header>
 
 
  <form action="input-produto" method="post">
   <input type="hidden" name="id" value="${produto.id}"/>
    <div class="field-container">
      <label>Descri��o</label>
      <input type="text" name="descricao" value="${produto.descricao}" placeholder="Pesquise produto pra dar entrada" disabled="disabled" required/>
    </div>
	
	 <div class="field-container">
      <label>Quantidade</label>
       <input type="text" name="quantidade" value="${produto.quantidade}" required/>
      <i class="icon-user"></i>
    </div> 
    
    <div class="controls-container">
      <input type="submit" value="Inserir" />
    </div>
  </form>
   
</section><br/><br/>

<section id="dess" class="grid clearfix">
    
  <header>
    <i class="icon-rocket"></i>
    <c:if test="${not empty erro_formato}">			
		<a>${erro_formato} :(</a><br/>			
    </c:if>		
  </header>
 
</section> 

</div>
</body>
<%session.removeAttribute("erro_formato"); %>
</html>