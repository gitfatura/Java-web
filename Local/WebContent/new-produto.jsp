<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Home</title>
<link rel="stylesheet" href="_css/file.css"/>
<script type="text/javascript" src="_js/validacao.js"></script>
</head>
<body>
<div>

<section id="des" class="grid clearfix">
    <a href="Home.jsp">Home</a>
    <a href="./all-produto">Lista de Produto</a>
  <header>
    <i class="icon-rocket"></i>

    <h1>Cadastro de Produto</h1>
  </header>
 
  <form action="save-produto" method="post">
    <div class="field-container">
      <label>Descri��o</label>
     <input type="text" name="descricao"  placeholder="Digite o produto" required/>
    </div>
	
	 <div class="field-container">
      <label>Quantidade</label>
      <input type="text" name="quantidade" placeholder="Digite a quantidade" required/>
      <i class="icon-user"></i>
    </div>
	

    <div class="field-container">
      <label>Valor</label>
       <input type="text" name="valor"  placeholder="Digite o pre�o" required/>
      <i class="icon-envelope-alt"></i>
    </div>
        
    <div class="controls-container">
      <input type="submit" value="Gravar" />
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
<% session.removeAttribute("erro_formato");%>
</html>