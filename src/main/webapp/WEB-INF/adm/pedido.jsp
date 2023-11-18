<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Pedido ${pedido.getId()}</title>
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
			<table>
				<tr class="pedido">
					<th scope="col">Pedido</th> 
					<th scope="col">Cliente</th> 
					<th scope="col">Data inicial</th> 
					<th scope="col">Data Final</th> 
					<th scope="col">Valor Total</th> 
					<th scope="col">Status</th> 
				</tr>
				<tr class="pedido">
					<td>${pedido.getId()}</td> 
					<td>${pedido.getCliente()} </td>
					<td>${pedido.getDataInicial()} </td>
					<td>${pedido.getDataFinal()} </td>
					<td>${pedido.getValorTotal()} </td>
					<td>${pedido.getStatus()}</td>
				</tr>
				<tr></tr>
				<tr>
					<th scope="col">Codigo</th>
					<th scope="col">Produto</th>
					<th scope="col">Categoria</th>
					<th scope="col">Quantidade</th>
					<th scope="col">Valor</th>
					<th scope="col">Total</th>
				</tr>
				<c:forEach var="p" items="${pedido.getProdutos()}">
					<tr class="pedido">
						<td>${p.getId()}</td>
						<td>${p.getNome()}</td>
						<td>${p.getCategoria()}</td>
						<td>${p.getQuantidadePedido()}</td>
						<td>${p.getValor()}</td>
						<td>${p.getValor() * p.getQuantidadePedido()}</td>
					</tr>
				</c:forEach>
				<tr class="pedido">
					<th scope="row" colspan="5">Total:</th>
					<td>${pedido.getValorTotal()}</td>
				</tr>
		</table>
		
		<a href="/loja/admin/pedidos">
		<button class="voltar">
			<span class="material-symbols-outlined">
				arrow_back
			</span>
		</button></a>
		</div>
	</section>
	
<jsp:include page="/rodape.jsp"/>
	
</body>
</html>
