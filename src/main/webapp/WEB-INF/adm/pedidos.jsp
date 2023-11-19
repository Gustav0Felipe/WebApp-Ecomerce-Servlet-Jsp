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
			<table>
				<tr class="pedido">
					<th scope="col">Pedido</th> 
					<th scope="col">Cliente</th> 
					<th scope="col">Data inicial</th> 
					<th scope="col">Data Final</th> 
					<th scope="col">Valor Total</th> 
					<th scope="col">Status</th> 
					<th scope="col"></th>
				</tr>
				<c:forEach var="p" items="${pedidos}">
				<tr class="pedido">
					<td>${p.getId()}</td> 
					<td>${p.getCliente()} </td>
					<td>${p.getDataInicial()} </td>
					<td>${p.getDataFinal()} </td>
					<td>${p.getValorTotal()} </td>
					<td>${p.getStatus()}</td>
					<td>
						<a href="/loja/admin/pedidos/${p.getId()}" class="buttonLink"> 
						<span class="material-symbols-outlined">arrow_forward</span>
						</a>
					</td>
				</tr>
 				</c:forEach>	
		</table>
		</div>
	</section>
	
<jsp:include page="/rodape.jsp"/>
	
</body>
</html>
