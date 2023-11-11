<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Alterar senha</title>
<link rel="shortcut icon" href="favicon.ico"/>
<link rel="stylesheet" href="css/mobile.css" media="all">
<link rel="stylesheet" href="css/mediaquery.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"> 
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />

<script type="text/javascript" src="js/responsive.js"></script>
<script type="text/javascript" src="js/sessionStorage.js"></script>
</head>
<body onresize="mudouTamanhoMenu()" onload="mudouTamanhoMenu()">
	
<jsp:include page="/cabecalho.jsp"/>
	
	<section id="section-principal">
		<div id="minhaConta">
			<span id="accountIcon" class="material-symbols-outlined">account_circle</span>
			<h1>Meus dados</h1>
			
			<form name="formEditarSenha" action="/loja/autenticar-senha" method="post">
				<label for="senha">Sua senha: </label>
				<input id="senha" name="senha" type="password" maxlength="30" placeholder="Senha Atual *"/>
				
				<button id="editar" type="submit">Enviar</button>
			</form>
			
			<p>${mensagem}</p>
		</div>
	</section>
	
<jsp:include page="/rodape.jsp"/>
	
</body>
</html>
