
class Produto{
    id;
	
	nome;
	
    desc;

	custo;
	
	qtd_estq;
	
	valor;
	
	categoria;
	
}
const document = docu
function atualizarCarrinho(produtoForm){
	
	let produto = new Produto();
	
	produto.id = produtoForm.getId();
	produto.nome = produtoForm.getNome();
	produto.desc = produtoForm.getDesc();
	produto.custo = produtoForm.getCusto();
	produto.qtd_estq = produtoForm.getQtd_estq();
	produto.valor = produtoForm.getValor();
	produto.categoria = produtoForm.getCategoria();
	
	console.log(produto.nome)
}