

function limparCarrinho(){
	fetch("/loja/cartUpdate", {method: "GET"}).then(window.location.reload(false));
}

function incrementProduto(indiceProduto){
	fetch(`/loja/cartUpdate?produtoIndice=${indiceProduto}`, {
		method: "POST"
		})
		
		.then(window.location.reload(false))
}

function decrementProduto(indiceProduto){
	fetch(`/loja/cartUpdate?produtoIndice=${indiceProduto}`, {
		method: "PUT"
		})
		
		.then(window.location.reload(false))
}

function deleteProduto(indiceProduto){
	fetch(`/loja/cartUpdate?produtoIndice=${indiceProduto}`, {method: "DELETE"})
		.then(window.location.reload(false))
}


