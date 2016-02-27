<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ Attribute name="num1" required="true"  rtexprvalue="true" type="java.lang.String" %>
<%@ Attribute name="num2" required="true"  rtexprvalue="true" type="java.lang.String" %>

<%
Integer num1 = Integer.parseInt((String) jspContext.getAttribute("num1"));
Integer num2 = Integer.parseInt((String) jspContext.getAttribute("num2"));
Integer soma = num1+num2;

jspContext.setAttribute("somaNumero", soma);

%>
${somaNumero}
