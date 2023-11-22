<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Cadastrar Produto</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mobile.css" media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mediaquery.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"> 
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />

<script type="text/javascript" src="${pageContext.request.contextPath}/js/responsive.js">
	
</script>
</head>
<body onresize="mudouTamanhoMenu()" onload="mudouTamanhoMenu()">

<jsp:include page="/cabecalho.jsp"/>

<section id="section-principal">
	<div id="cadastro">
			<span id="createUserIcon" class="material-symbols-outlined">person_add</span>
			<h1>Novo produto: </h1>
			<form class="formDados" action="/loja/admin/cadastrar-produto" method="post" enctype="multipart/form-data">
						
				<label for="nome">Nome: </label>
				<input id="nome" name="nome" type="text" required maxlength="255" placeholder="Nome"/>
				
				<label for="desc">descrição: </label>
				<input id="desc" name="desc" maxlength="255" required placeholder="descrição"/>
				
				<label for="custo">Custo: </label>
				<input id="custo" name="custo" type="number" required maxlength="10" placeholder="Custo *" autocomplete="on"/>
				
				<label for="valor">Valor: </label>
				<input id="valor" name="valor" type="number" required maxlength="10" placeholder="Valor *"/>
				
				<label for="estoque">Estoque: </label>
				<input id="estoque" name="estoque" type="number" required maxlength="10" placeholder="Estoque *"/>
				
				<label for="categoria">Categoria: </label>
				<input id="categoria" name="categoria" type="number" required maxlength="10" placeholder="Categoria *"/>
				
				<label for="imagem">Imagem: </label>
				<input id="imagem" name="imagem" type="file" required maxlength="10" placeholder="Imagem *"/>
				
				
				<button id="cadastrar" type="submit">Enviar</button>
			</form>
	</div>
</section>
	
<jsp:include page="/rodape.jsp"/>
	
</body>
</html>
