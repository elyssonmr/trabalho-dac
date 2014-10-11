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
<%Emprestimo f = (Emprestimo)request.getAttribute("emp");%>


<h1>

O Emprestimo de <%=f.getValor() %> foi cadastrado com sucesso.

O cliente é <%=f.getCliente().getNome() %>
</h1>

</body>
</html>