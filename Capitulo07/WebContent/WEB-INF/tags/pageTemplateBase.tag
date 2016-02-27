<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@attribute name="title" required="true" %>
<%@attribute name="message" required="false" %>
<!DOCTYPE html>

<html lang="pt">

<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Felipe da Rosa Oliveira">
	<title>${title}</title>
	
	<%@include file="/WEB-INF/linkscss.jsp" %>
	<%@include file="/WEB-INF/scriptsjs.jsp" %>
	<style>
		body{
			margin-left: 20px;
		}
	</style>
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>


<%@include file="/WEB-INF/header.jsp" %>
<jsp:doBody/>




</body>
</html>
