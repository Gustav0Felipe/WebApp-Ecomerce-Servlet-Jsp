 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Cadastro</title>
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
		<div id="cadastro">
			<span id="createUserIcon" class="material-symbols-outlined">person_add</span>
			<h1>Criar Conta</h1>
			<p>Informe seus dados abaixo para criar sua conta</p>
			<form action="/loja/cadastro" method="post">
				<label for="nome">Nome: </label> 
				<input id="nome" name="nome" type="text" maxlength="255" required placeholder="Nome"/>
				<label for="cpf">CPF: </label> 
				<input id="cpf" name="cpf" type="text" maxlength="15" required placeholder="CPF *" /> 
				<label for="telefone">Telefone: </label> 
				<input id="telefone" name="telefone" type="tel" required placeholder="Telefone"/> 
				<label for="email">Email: </label> 
				<input id="email" name="email" type="email" maxlength="255" required placeholder="Email *"/> 
				<label for="senha">Senha: </label> 
				<input id="senha" name="senha" type="password" minlength="8" required placeholder="Senha *"/>
				<button id="cadastrar" type="submit">Enviar</button>
			</form>
			<p class="mensagem">${mensagem}</p>
		</div>
	</section>

	<jsp:include page="/rodape.jsp" />

</body>
</html>
