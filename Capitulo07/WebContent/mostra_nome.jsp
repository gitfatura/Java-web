
<!DOCTYPE html >
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostra Nome</title>
</head>
<body>
<%=request.getParameter("nome") %><br/>
Aqui vamos mostrar seu nome: ${param.nome } <br/>
Aqui vamos mostrar seu nome: ${requestScope.batatinha } <br/>
Seu curso é: ${sessionScope.curso } <br/>
Segundo Curso: ${applicationScope.curso2 } <br/>

Outra forma de mostrar as informações é : ${curso } -  ${batatinha } <br/>

Foo.bar é : ${requestScope["foo.bar"] } <br/>

${requestScope["batatinha"] } <br/>
${sessionScope["curso"] } <br/>
${applicationScope["curso2"] } <br/>

${requestScope.nomes[0] } <br/>

${requestScope.pessoa.nome } <br/>
${requestScope.pessoa.idade } <br/>
${pessoa.dog.nome } <br/>

${dados["nome"][0]} <br/>

${dados.endereco} <br/>

${nota1 + nota2} <br/>

${(nota1 + nota2 + nota3)/3} <br/>

nota1 &lt; nota2 = ${nota1 > nota2 }<br/>
nota1 &lt; nota2 = ${nota1 gt nota2 }<br/>

nota2 == nota3 = ${nota2 eq nota3 }<br/>

${empty curso3 }

</body>
</html>