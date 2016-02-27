<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- For  percorre de 5 ate 10  -->
	<c:forEach var="number" begin="5" end="10">
		<!-- if se number menor que 6 redireciona-->
		<c:if test="${number < 6}">
			<!-- redireciona para menu -->
			<c:redirect url="Menu.jsp"/>
			<!-- imprimi -->
			<c:out value="Menor que 6"/>
		</c:if>

		<c:out value="${number}" />

	</c:forEach>
</body>
</html>