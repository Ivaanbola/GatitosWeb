<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.sun.javafx.fxml.ParseTraceElement"%>
<%@page
	import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
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

	<%
		String id = "0";
		if (request.getAttribute("id") != null) {
			id = request.getAttribute("id").toString();
		}
		Gatitos gato = new Gatitos();
		gato.buscarID(Integer.parseInt(id));
	%>
	<form name="gatitos" action="GGatitos" method="post">
		<input type="hidden" name="id" id="id"
			value='<%if (request.getAttribute("id") != null)
				out.print(gato.getId());%>'>
		<div class="form-group">
			<label for="exampleFormControlInput1">Nombre</label> <input
				type="text" class="form-control" id="nombre" placeholder="Nombre"
				name="nombre"
				value='<%if (request.getAttribute("id") != null)
				out.print(gato.getNombre());%>'>
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">Raza</label> <input type="text"
				class="form-control" id="raza" name="raza" placeholder="Raza"
				value='<%if (request.getAttribute("id") != null)
				out.print(gato.getRaza());%>'>
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">Edad</label> <input
				type="number" class="form-control" id="edad" name="edad"
				placeholder="Edad"
				value='<%if (request.getAttribute("id") != null)
				out.print(gato.getEdad());%>'>
		</div>
		<div class="custom-file">
			<input type="file" class="custom-file-input" id="foto" name="foto">
			<label class="custom-file-label" for="customFile"
				value='<%if (request.getAttribute("id") != null)
				out.print(gato.getFoto());%>'>Elige
				una foto</label>
		</div>
		<input type="hidden" name="opcion" value="1">
		<div class="form-group">
			<button type="submit" class="btn btn-primary">Enviar</button>
		</div>
	</form>
	<a href="index.jsp">Volver a la lista</a>
	<%
		if (request.getAttribute("id") != null)
			out.print("<a href='GGatitos?opcion=2&id=" + gato.getId() + "'>Borrar</a>");
	%>

</body>
</html>