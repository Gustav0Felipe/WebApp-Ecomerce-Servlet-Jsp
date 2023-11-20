<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Perfil</title>
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/favicon.ico" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/mobile.css" media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/mediaquery.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/responsive.js"></script>
</head>
<body onresize="mudouTamanhoMenu()" onload="mudouTamanhoMenu()">

	<jsp:include page="/cabecalho.jsp" />

	<section id="section-principal">

		<div class="perfil">
			<span id="accountIcon" class="material-symbols-outlined">account_circle</span>
			<h1>Minha Conta</h1>
			<h2>Informações de Acesso</h2>

			<p>${cliente.getNome()}</p>
			<p>${cliente.getEmail()}</p>
			<p>${cliente.getTelefone()}</p>
			<p>${cliente.getCpf()}</p>
			<br> <a href="/loja/perfil/editar"><button
					class="editButtons">EDITAR</button></a> <a
				href="/loja/perfil/editar-senha/autenticar"><button
					class="editButtons">MUDAR SENHA</button></a>
		</div>

	</section>

	<jsp:include page="/rodape.jsp" />

</body>
</html>
