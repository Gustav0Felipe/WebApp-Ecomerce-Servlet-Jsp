<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Cadastro</title>
<link rel="shortcut icon" href="favicon.ico"/>
<link rel="stylesheet" href="css/mobile.css" media="all">
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
							<span id="cart" class="material-symbols-outlined">shopping_cart</span> 
						</a>
					</li>
					
				</ul>
			</nav>
	</header>
	<section id="section-principal">
	
		<div id="cadastro">
			<span id="createUserIcon" class="material-symbols-outlined">person_add</span>
			<h1>Criar Conta</h1>
			<p> Informe seus dados abaixo para criar sua conta </p>
			<form name="formCadastro" action="/loja/cadastro" method="post">
			
				<label for="nome">Nome: </label>
				<input id="nome" name="nome" type="text" maxlength="255" placeholder="Nome"/>
				
				<label for="cpf">CPF: </label>
				<input id="cpf" name="cpf" type="text" maxlength="255" placeholder="CPF *"/>
				
				<label for="telefone">Telefone: </label>
				<input id="telefone" name="telefone" type="tel" placeholder="Telefone"/>
				
				<label for="email">Email: </label>
				<input id="email" name="email" type="email" maxlength="255" placeholder="Email *"/>
				
				<label for="senha">Senha: </label>
				<input id="senha" name="senha" type="password" min="8" placeholder="Senha *"/>
				
				<button id="cadastrar" type="submit">Enviar</button>
			</form>
			
		</div>
	
	</section>
	
	<footer class="rodape">
		Site feito por Gustavo Felipe
	</footer>
	
	<script type="text/javascript" src="js/responsive.js">
	
	</script>
</body>
</html>
