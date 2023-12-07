<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Alterar senha</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}favicon.ico" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mobile.css" media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mediaquery.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />

<script type="text/javascript" src="${pageContext.request.contextPath}/js/responsive.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/sessionStorage.js"></script>
</head>
<body onresize="mudouTamanhoMenu()" onload="mudouTamanhoMenu()">

	<jsp:include page="/cabecalho.jsp" />

	<section id="section-principal">
		<div class="base">
			<span id="accountIcon" class="material-symbols-outlined">account_circle</span>
			<h1>Alterar senha</h1>

			<form action="/loja/perfil/editar-senha/autenticar" method="post">
				<label for="senha">Sua senha atual: </label> <input id="senha" name="senha" type="password" maxlength="30" required placeholder="Senha Atual *" />

				<button id="editar" type="submit">Enviar</button>
			</form>

			<p>${mensagem}</p>
		</div>
	</section>

	<jsp:include page="/rodape.jsp" />

</body>
</html>


