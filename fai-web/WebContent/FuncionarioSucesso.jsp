<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="fai.domain.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Cliente f = (Cliente)request.getAttribute("cli");%>


<h1>

O Cliente <%=f.getNome() %> foi cadastrado com sucesso.

O endereço é <%=f.getEndereco().getLogradouro() %>
</h1>

</body>
</html>