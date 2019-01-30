<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="controlador.GGatitos"%>
<%@page import="modelo.Gatitos"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul class="nav justify-content-center">
		<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a>
		</li>
		<li class="nav-item"><a class="nav-link active"
			href="GGatitos?opcion=3&id=0">Formulario Gatitos</a></li>
	</ul>

	<section>
		<div class="formulario">
			<h1>Lista Gatos</h1>
			<table class="lista">
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Raza</th>
					<th>Edad</th>
					<th>Foto</th>
				</tr>
				<%
					Gatitos gato = new Gatitos();
					if (gato.listarGatitos() != null)
						for (Gatitos p : gato.listarGatitos()) {
				%>
				<tr>
					<td><%=p.getId()%></td>
					<td><%=p.getNombre()%></td>
					<td><%=p.getRaza()%></td>
					<td><%=p.getEdad()%></td>
					<td><%=p.getFoto()%></td>
					<td><a href="GGatitos?opcion=3&id=<%=p.getId()%>">Editar</a></td>
				</tr>
				<%
					}
				%>
			</table>
</body>
</html>