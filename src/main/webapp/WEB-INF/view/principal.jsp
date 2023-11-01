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


<script type="text/javascript" src="js/responsive.js"></script>
</head>
<body onresize="mudouTamanhoMenu()" onload="mudouTamanhoMenu()">
	
<jsp:include page="/cabecalho.jsp"/>
	
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
	
<jsp:include page="/rodape.jsp"/>
	
</body>
</html>
