<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Ecomerce</title>
<link rel="stylesheet" href="css/mobile.css" media="all">
<link rel="shortcut icon" href="favicon.ico"/>
<link rel="stylesheet" href="css/mediaquery.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"> 
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />


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
					<!-- Espa�amento-->
					<li><a href="#"> Crie a sua conta </a></li>
					<li><a href="#"> Entre </a></li>
					<li><a href="/loja/cart">
							<span id="cart" class="material-symbols-outlined">shopping_cart</span> 
						</a>
					</li>
					
				</ul>
			</nav>
	</header>
	<section id="section-principal">
		<div id="anuncio-topo-dinamico">
		
		</div>
		<h1>Ofertas do dia</h1>
		<div id="ofertas">
		<!-- LOGICA DE OFERTAS, IMAGENS DINAMICAS E TALZ. -->
		<ol class="produtos">
			<c:forEach var="p" items="${produtos}">
			<li class="produto">
				<a href='/loja/comprar?produto=${p}'>
				<img class="ofertas" src="imagens/${p}.png"/>	
				</a>
			</li>
			</c:forEach>	
		</ol>
		</div>
	
	</section>
	
	<footer class="rodape">
		Site feito por Gustavo Felipe
	</footer>
	
	<script type="text/javascript" src="js/responsive.js">
	
	</script>
</body>
</html>