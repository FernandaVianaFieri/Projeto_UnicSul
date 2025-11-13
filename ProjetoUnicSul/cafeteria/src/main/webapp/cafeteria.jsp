<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("cliente");


 %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Cadastro de Clientes</title>
<link rel="icon" href="imagens/xicara.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Cadastro de Clientes</h1>
	<a href="novo.html" class="Botao1">Novo Cliente</a>

<table id="tabela">
	 <thead>
	<tr>
	<th>CPF</th>
	<th>Nome</th>
	<th>E-mail</th>
	<th>Dta Nasc</th>
	<th>Telefone</th>
	<th>Endereço</th>
	 <th>Opções</th>
	</tr>	
	</thead>
		
	
	
	<tbody>
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getIdcpf()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getEmail()%></td>
				<td><%=lista.get(i).getDataNasc()%></td>
				<td><%=lista.get(i).getTelefone()%></td>
				<td><%=lista.get(i).getEndereco()%></td>
				
					<td><a href="select?idcon=<%=lista.get(i).getIdcpf() %>" class="Botao1">Editar</a></td>
		</tr>
		
	<%} %>
		</tbody>
	

	
	</table>*/
	
	
</body>
</html>