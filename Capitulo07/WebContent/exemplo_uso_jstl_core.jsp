<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:import url="/header.html"></c:import>
<c:catch>
<%
 int valor = 10/0;
out.print(valor);
%>
</c:catch>

<c:catch>
<%
 int valor = 10/3;
out.print(valor);
%>
</c:catch>

<c:out value="${param.nome }"></c:out>
<br/>
${param.nome }


<c:if test="${empty param.nome }">
	<b>Nome não Informado</b>
</c:if>
<c:if test="${not empty param.nome }">
	${param.nome }
</c:if>
</body>
</html>