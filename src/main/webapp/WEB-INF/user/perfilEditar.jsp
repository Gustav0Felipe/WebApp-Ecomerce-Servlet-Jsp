<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Editar</title>
<link rel="shortcut icon" href="favicon.ico"/>
<link rel="stylesheet" href="css/mobile.css" media="all">
<link rel="stylesheet" href="css/mediaquery.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"> 
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />

<script type="text/javascript" src="js/responsive.js"></script>
</head>
<body onresize="mudouTamanhoMenu()" onload="mudouTamanhoMenu()">
	
	<!-- Header Cabeçalho. -->
	<jsp:include page="/cabecalho.jsp"/>
	
	<section id="section-principal">
	
	<div id="minhaConta">
		<span id="accountIcon" class="material-symbols-outlined">account_circle</span>
		<h1>Meus dados</h1>
		
		<form name="formCadastro" action="/loja/account/edit" method="post">
			
				<label for="nome">Nome: </label>
				<input id="nome" name="nome" type="text" maxlength="255" placeholder="Nome" value="${cliente.getNome()}"/>
				
				<label for="cpf">CPF: </label>
				<input id="cpf" name="cpf" type="text" maxlength="255" placeholder="CPF *" value="${cliente.getCpf()}" />
				
				<label for="telefone">Telefone: </label>
				<input id="telefone" name="telefone" type="tel" placeholder="Telefone" value="${cliente.getTelefone()}"/>
				
				<label for="email">Email: </label>
				<input id="email" name="email" type="email" maxlength="255" placeholder="Email *" value="${cliente.getEmail()}"/>
				
				<button id="cadastrar" type="submit">Enviar</button>
			</form>
	</div>
	
	<div id="meusDados"> </div>
	
	</section>
	
	<footer class="rodape">
		Site feito por Gustavo Felipe
	</footer>
	
	<script type="text/javascript" src="js/responsive.js">
	
	</script>
</body>
</html>
