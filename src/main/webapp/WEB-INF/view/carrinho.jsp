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


<script type="text/javascript" src="js/responsive.js">
	
</script>
</head>
<body onresize="mudouTamanhoMenu()" onload="mudouTamanhoMenu()">
<header>
	<img alt="Icone do Java" src="favicon.ico" id="logo">
	<div id="pesquisar">
		<form action="/loja/pesquisar" method="get">
			<input type="text" id="pesquisa" name="pesquisa" placeholder="Pesquisar"/>
		</form>
	</div>
	<span id="burguer" class="material-icons" onclick="clickMenu(menu)">menu</span>
	<nav id="menu">
		<ul>
			<li><a href="#"> Ofertas do Dia </a></li>
			<li><a href="#"> Supermercado </a></li>
			<li><a href="#"> Moda </a></li>
			<!-- Espaçamento-->
			<li><a href="/loja/cadastro"> Crie a sua conta </a></li>
			<li><a href="/loja/login"> Entre </a></li>
			<li><a href="/loja/cart">
					<span class="material-symbols-outlined">shopping_cart</span> 
				</a>
			</li>
		</ul>
	</nav>
</header>
<section>
	<!-- LOGICA DE COMPRAS, IMAGENS DINAMICAS E TALZ. -->
	
	<h1><span class="material-symbols-outlined">shopping_cart</span> MEU CARRINHO</h1>
	<div id="resumo">
		<h2>Resumo</h2>
		<p>Total: ${pedidoSession.getValorTotal()}</p>
	</div>
	
	<div id="carrinho">
		<h3>Produto</h3>
	
		<form name="pedidoForm" action="/loja/checkout" method="post">
		
			<ol id="carrinhoList">
				<c:forEach var="produto" items="${pedidoSession.getProdutos()}">
					<li>
						<img class="miniatura_produto" src="imagens/${produto.getNome()}.png" alt="Produto ${produto.getNome()} }"/>	

						<p>
							<button type="button" onclick="decrementProduto()"><span class="material-symbols-outlined">remove</span></button>
							<span> ${produto.getQuantidadePedido()} </span>
							<button type="button" onclick="incrementProduto()"><span class="material-symbols-outlined">add</span></button>
							<button type="button" onclick="deleteProduto()"><span class="material-symbols-outlined">delete</span></button>
						</p>
					</li>
					
					<li>
						<p class="prod_name">${produto.getNome()}</p>
					</li>
				</c:forEach>
			</ol>
			
			<button id="limparCarrinho" type="button"><span class="material-symbols-outlined">delete_forever</span> LIMPAR CARRINHO</button>
			
			<h2>Frete e Prazos</h2> 
			
			
			<label for="cep"></label>
			<input id="cep" name="cep" type="number" size="8" placeholder="CEP *"/>
			<button id="calcularCep" type="button"><span class="material-symbols-outlined">local_shipping</span> CALCULAR</button>
		</form>	
	</div>
	
	<div id="finalizar">
		<button type="button" onclick="finalizarPedido"><span class='material-symbols-outlined'>shopping_cart</span> FINALIZAR PEDIDO</button>
	</div>
</section>
	
<footer>
	Site feito por Gustavo Felipe
</footer>


</body>
</html>