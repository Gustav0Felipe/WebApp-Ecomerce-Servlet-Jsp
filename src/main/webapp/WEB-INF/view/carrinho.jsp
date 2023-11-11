<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="loja.negocio.Produto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Carrinho</title>
<link rel="stylesheet" href="css/mobile.css" media="all">
<link rel="shortcut icon" href="favicon.ico"/>
<link rel="stylesheet" href="css/mediaquery.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"> 
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />


<script type="text/javascript" src="js/responsive.js"></script>
<script type="text/javascript" src="js/sessionStorage.js"></script>
</head>
<body onresize="mudouTamanhoMenu()" onload="mudouTamanhoMenu()">

<jsp:include page="/cabecalho.jsp"/>

<section>
	<h1><span class="material-symbols-outlined">shopping_cart</span> MEU CARRINHO</h1>
	<div id="resumo">
		<h2>Resumo</h2>
		<p>Total: ${carrinhoTotalSession}</p>
	</div>
	
	<div id="carrinho">
		<h3>Produto</h3>
		<ol id=carrinho_list>
			<c:forEach var="produto" items="${pedidoSession.getProdutos()}">
				<li>
					<img class="miniatura_produto" src="imagens/${produto.getId()}.png" alt="Produto ${produto.getNome()}"/>	

					<p>
						<button type="button" onclick="decrementProduto(${pedidoSession.getProdutos().indexOf(produto)})"><span class="material-symbols-outlined">remove</span></button>
						<span> ${produto.getQuantidadePedido()} </span>
						
						<button type="button" onclick="incrementProduto(${pedidoSession.getProdutos().indexOf(produto)})"><span class="material-symbols-outlined">add</span></button>
						<button type="button" onclick="deleteProduto(${pedidoSession.getProdutos().indexOf(produto)})"><span class="material-symbols-outlined">delete</span></button>
					</p>
				</li>
				
				<li>
					<p class="prod_name">${produto.getNome()}</p>
				</li>
			</c:forEach>
		</ol>
		<button id="limpar_carrinho" type="button" onclick="limparCarrinho()"><span class="material-symbols-outlined">delete_forever</span> LIMPAR CARRINHO</button>
	</div>
	
	<div id="finalizar">
		<a href="/loja/encomendar"><button type="button"><span class='material-symbols-outlined'>shopping_cart</span> FINALIZAR PEDIDO</button></a>
	</div>
</section>

<jsp:include page="/rodape.jsp"/>
</body>
</html>