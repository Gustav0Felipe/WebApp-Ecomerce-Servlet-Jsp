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