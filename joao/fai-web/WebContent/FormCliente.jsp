<%@page import="fai.domain.EntidadeDominio"%>
 <%@page import="fai.domain.TipoCliente"%>
<%@page import="java.util.*"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

List<EntidadeDominio> tipos = 
	(List<EntidadeDominio>)getServletContext().getAttribute("tipos");

%>

<form action="SalvarCliente" method="post" />
	<label>Nome:</label>
	<input type="text" id="txtNome" name="txtNome"/></BR>
	<label>CPF:</label>
	<input type="text" id="txtCpf" name="txtCpf"/></BR>
	<label>CRÉDITO:</label>
	<input type="text" id="txtCredito" name="txtCredito"/></BR>
	<label>LOGRADOURO:</label>
	<input type="text" id="txtLogradouro" name="txtLogradouroRua"/></BR>
	<label>CIDADE:</label>
	<input type="text" id="txtCidade" name="txtCidade"/></BR>
	<label>ESTADO:</label>
	<input type="text" id="txtEstado" name="txtEstado"/></BR>
	<label>CEP:</label>
	<input type="text" id="txtCep" name="txtCep"/></BR>
	<label>TIPO:</label>
	<select id="txtTipo" name="txtTipo">
		<%
			StringBuilder sb = new StringBuilder();
			for(EntidadeDominio t: tipos){
				TipoCliente tipo=(TipoCliente)t;
				sb.append("<option value='");
				sb.append(tipo.getId());
				sb.append("'");
				sb.append("selected='true'>");
				sb.append(tipo.getDescricao());
				sb.append("</option>");
			}
		out.println(sb.toString());
		
		%>
		
	</select></BR>
	<input type="submit"/>

</form>
</body>
</html>