package loja.webComponents.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import loja.negocio.Pedido;
import loja.negocio.Produto;

public class CarrinhoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		
		Collection<Produto> produtos;
		produtos = (Collection<Produto>) session.getAttribute("produtosSession");

		if(produtos == null) {
			produtos = new ArrayList<>();
		}
		
		
		req.getRequestDispatcher("/WEB-INF/view/carrinho.jsp").forward(req, resp);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		Produto produto = new Produto();
		Pedido pedido = new Pedido();
		Collection<Produto> produtos;
	
		double total = 0;
		
		produto.setId(Integer.valueOf(req.getParameter("id")));
		produto.setNome(req.getParameter("nome"));
		produto.setCusto(Double.valueOf(req.getParameter("custo")));
		produto.setValor(Double.valueOf(req.getParameter("valor")));
		produto.setQtd_estq(Integer.valueOf(req.getParameter("estoque")));
		produto.setQuantidadePedido(1);
		
		pedido = (Pedido) session.getAttribute("pedidoSession");
		
		if(pedido == null) {
			pedido = new Pedido();
		}
	
		if(session.getAttribute("carrinhoTotalSession") != null) {
		total = produto.getValor() + (double) session.getAttribute("carrinhoTotalSession");
		}else {
			total = produto.getValor();
		}
		produtos = (Collection<Produto>) session.getAttribute("produtosSession");
		
		if(produtos == null) {
			produtos = new ArrayList<>();
		}
		
		
		
		session.setAttribute("produtosSession", produtos);
		
		session.setAttribute("carrinhoTotalSession", total);
		
		pedido.setCliente("Jayr");
		pedido.setProdutos(produtos);
		pedido.setValorTotal(total);
	
		
		boolean existeProduto = false;
		for(Produto p: produtos) {
			if(p.getId() == (produto.getId())) {
				existeProduto = true;
				p.incrementQuantidadePedido();
			}
		}
		if(!existeProduto) {
			produtos.add(produto);
		}
		
		
		session.setAttribute("pedidoSession", pedido);
		
		req.getRequestDispatcher("/WEB-INF/view/carrinho.jsp").forward(req, resp);
	}
	
	

}
