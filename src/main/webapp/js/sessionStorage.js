


function limparCarrinho(){
	fetch("/loja/cart?scope=all", {method: "DELETE"}).then(window.location.href = "/loja/cart");
}

function incrementProduto(indiceProduto){
	fetch(`/loja/cart?produtoIndice=${indiceProduto}&operacao=increment`, {
		method: "PUT"
		})
		
		.then(window.location.href = "/loja/cart");
}

function decrementProduto(indiceProduto){
	fetch(`/loja/cart?produtoIndice=${indiceProduto}&operacao=decrement`, {
		method: "PUT"
		})
		
		.then(window.location.href = "/loja/cart");
}

function deleteProduto(indiceProduto){
	fetch(`/loja/cart?produtoIndice=${indiceProduto}&scope=single`, {method: "DELETE"})
		.then(window.location.href = "/loja/cart");
}

function updatePassword(){
	let pass = document.querySelector("#senha");
	let senha = {
		password: pass.value
		};
	
	fetch(`/loja/editar-senha`, {
		method: "PUT", 
		body: JSON.stringify(senha),
		redirect: 'follow'
		})
}

function checkSessionLoad(type){
	if(type != null){
		window.location.reload();
	}
	console.log(type);
}

