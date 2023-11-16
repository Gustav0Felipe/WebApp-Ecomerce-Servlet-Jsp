<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Perfil</title>
<link rel="shortcut icon" href="favicon.ico"/>
<link rel="stylesheet" href="css/mobile.css" media="all">
<link rel="stylesheet" href="css/mediaquery.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"> 
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />

<script type="text/javascript" src="js/responsive.js"></script>
</head>
<body onresize="mudouTamanhoMenu()" onload="mudouTamanhoMenu()">
	
<jsp:include page="/cabecalho.jsp"/>
	
	<section id="section-principal">
	
	<div class="perfil">
		<span id="accountIcon" class="material-symbols-outlined">account_circle</span>
		<h1>Minha Conta</h1>
		<h2>Informações de Acesso</h2>		
		
		<p>${cliente.getNome()}</p>
		<p>${cliente.getEmail()}</p>
		<a href="/loja/editar"><button>EDITAR</button></a>
		<a href="/loja/autenticar-senha"><button>MUDAR SENHA</button></a>
		<button id="excluirConta">EXCLUIR MINHA CONTA</button>
	</div>
	
	</section>
	
<jsp:include page="/rodape.jsp"/>

</body>
</html>
