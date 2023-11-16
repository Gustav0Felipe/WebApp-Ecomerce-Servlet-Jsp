/**
 * 
 */
function clickMenu(botao) {
    if (botao.style.display == 'block'){
        botao.style.display = 'none';
    }
    else {
   		botao.style.display = 'block'
    }
}

function mudouTamanhoMenu() { 
        /*Quando clico no menu, o display dos itens muda entre none e block, se eu encolher o menu, o display muda pra none, mas ai se eu aumenta a tela e o menu desaparecer, os itens ainda vão estar no display none, e não vão aparecer denovo por que o menu some em comprimentos maiores, logo tenho que colocar este codigo para que quando mude de tamanho o display dos itens mude automaticamente para block, mesmo sem clicar no menu.*/
    if (window.innerWidth >= 769){
        /*Largura da tela/janela.*/
        menu.style.display = 'block'
    } else{
        menu.style.display = 'none'
    }
}
	