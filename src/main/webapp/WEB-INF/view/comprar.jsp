<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="loja.negocio.Produto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Comprar</title>
<link rel="stylesheet" href="css/mobile.css" media="all">
<link rel="shortcut icon" href="favicon.ico"/>
<link rel="stylesheet" href="css/mediaquery.css" media="all">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"> 
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />


<script type="text/javascript" src="js/responsive.js">
	
</script>
</head>
<body onresize="mudouTamanhoMenu()" onload="mudouTamanhoMenu()">

	<!-- Header Cabeçalho. -->
	<jsp:include page="/cabecalho.jsp"/>


<section>
	<!-- LOGICA DE COMPRAS, IMAGENS DINAMICAS E TALZ. -->
<div id="comprar">
	<div id="detalhes">
		<img src="imagens/${produto.getNome()}.png" alt="Produto"/>	
		
		<form action="/loja/cart" method="post">
		<p id="preco">Preço: ${produto.getValor()}</p>
		
		<input type="hidden" name="id"  value="${produto.getId()}"/>
		<input type="hidden" name="nome"  value="${produto.getNome()}"/>
		<input type="hidden" name="desc"  value="${produto.getDesc()}"/>
		<input type="hidden" name="custo" value="${produto.getCusto()}"/>
		<input type="hidden" name="valor" value="${produto.getValor()}"/>
		<input type="hidden" name="estoque" value="${produto.getQtd_estq()}"/>
		<input type="hidden" name="categoria" value="${produto.getCategoria()}"/>
		
		<button id="comprar" type="submit"><span class="material-symbols-outlined">shopping_cart</span> Comprar</button>
		<!-- FAZER SAPORRA AQUI, EU CONSIGO PEGAR O VALOR DA LABEL NO SERVLET PELO ID OU NAME SEILAPORRA -->
		</form>
	</div>
	<ol id="descricao_bar" onclick="clickMenu(descricao)">
	<li>Descrição do produto</li>
	<li id="dropdown"class="material-symbols-outlined">expand_more</li>
	</ol>
	<div id="descricao">
	<p>${produto.getDesc()}</p>
	</div>
</div>
</section>
	
<footer>
	Site feito por Gustavo Felipe
</footer>
<script type="text/javascript" src="js/responsive.js">
	
	</script>
</body>
</html>