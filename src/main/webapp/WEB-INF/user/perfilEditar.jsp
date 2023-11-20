<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Editar</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mobile.css" media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mediaquery.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"> 
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />

<script type="text/javascript" src="${pageContext.request.contextPath}/js/responsive.js"></script>
</head>
<body onresize="mudouTamanhoMenu()" onload="mudouTamanhoMenu()">
	
	<jsp:include page="/cabecalho.jsp"/>
	
	<section id="section-principal">
		<div id="cadastro">
			<span id="accountIcon" class="material-symbols-outlined">account_circle</span>
			<h1>Alterar meus dados</h1>
			<p>É possivel alterar apenas Nome e Telefone.</p>
			<form name="formEditar" action="/loja/perfil/editar">
				
					<label for="nome">Nome: </label>
					<input id="nome" name="nome" type="text" maxlength="255" required placeholder="Nome" value="${cliente.getNome()}"/>
					
					<label for="cpf">CPF: </label>
					<input id="cpf" name="cpf" type="text" maxlength="255" required placeholder="CPF *" value="${cliente.getCpf()}" readonly="readonly" />
					
					<label for="telefone">Telefone: </label>
					<input id="telefone" name="telefone" type="tel" required placeholder="Telefone" value="${cliente.getTelefone()}"/>
					
					<label for="email">Email: </label>
					<input id="email" name="email" type="email" required maxlength="255" placeholder="Email *" value="${cliente.getEmail()}" readonly="readonly"/>
					
					<button id="editar" type="submit">Confirmar</button>
			</form>
		</div>
	</section>
	
	<jsp:include page="/rodape.jsp"/>
	
</body>
</html>
