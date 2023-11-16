<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Pedidos</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mobile.css" media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mediaquery.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"> 
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />


<script type="text/javascript" src="${pageContext.request.contextPath}/js/responsive.js"></script>
</head>
<body onresize="mudouTamanhoMenu()" onload="mudouTamanhoMenu()">
	
<jsp:include page="/cabecalho.jsp"/>
	
	<section id="section-principal">
		<div>
			<ol>
			<c:forEach var="p" items="${pedidos}">
				<li class="pedido">
					<span>Id do Pedido: ${p.getId()}</span> 
					<span>Cliente: ${p.getCliente()} </span>
					<span>Data inicial: ${p.getDataInicial()} </span>
					<span>Data Final: ${p.getDataFinal()} </span>
					<c:forEach var="produto" items="${p.getProdutos()}">
							<span>Produto: ${produto.getNome()} </span>
							<span>Quantidade: ${produto.getQuantidadePedido()} </span>
							<span>Valor: ${produto.getValor()} </span>
					</c:forEach>
					<span>Valor total: ${p.getValorTotal()} </span>
					<span>Status: ${p.getStatus()}</span>
				</li>
				<br>
			</c:forEach>	
		</ol>
		</div>
	</section>
	
<jsp:include page="/rodape.jsp"/>
	
</body>
</html>
