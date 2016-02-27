<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@page import="javax.servlet.http.*,javax.servlet.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<sql:setDataSource var="produto" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/base" user="root" password="sysdba" />

	<sql:update dataSource="${produto}" var="resultado">	
	INSERT INTO Employees VALUES(100,100,'dasdsa','sdadsa');
	</sql:update>

	<sql:query dataSource="${produto}" var="resultado">
	SELECT * FROM Employees;
	</sql:query>


	<table border="1" width="100%">
		<tr>
			<th>ID</th>
			<th>DESCRICAO</th>
			<th>QUANTIDADE</th>
			<th>VALOR</th>
			<th>TOTAL</th>
			<th>DATA</th>
		</tr>
		<c:forEach var="row" items="${resultado.rows}">
			<tr>
				<td><c:out value="${row.id}"></c:out>
				<td><c:out value="${row.age}"></c:out>
				<td><c:out value="${row.firt}"></c:out>
				<td><c:out value="${row.last}"></c:out>
				<td><c:out value="${row.total}"></c:out>
				<td><c:out value="${row.data}"></c:out>
			</tr>
		</c:forEach>
	</table>
</body>
</html>