<header>
	<a href="/loja/"><img alt="Icone do Java" src="favicon.ico" id="logo"></a>
	<div id="pesquisar">
		<form action="/loja/pesquisar" method="get">
			<input type="text" id="pesquisa" name="pesquisa" placeholder="Pesquisar"/>
		</form>
	</div>
	<span id="burguer" class="material-icons" onclick="clickMenu(menu)">menu</span>
	<nav id="menu">
		<ul>
			<li><a href="/loja/"> Ofertas do Dia </a></li>
			<!-- Espaçamento-->
			<li><a href="/loja/cadastro"> Crie a sua conta </a></li>
			<li><a href="/loja/login"> Entre </a></li>
			<li><a href="/loja/perfil"> Minha conta </a></li>
			<li><a href="/loja/cart">
					<span id="cart" class="material-symbols-outlined">shopping_cart</span> 
				</a>
			</li>
		</ul>
	</nav>
</header>