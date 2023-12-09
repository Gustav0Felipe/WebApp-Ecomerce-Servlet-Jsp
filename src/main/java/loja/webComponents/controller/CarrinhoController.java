package loja.webComponents.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import loja.negocio.Pedido;
import loja.negocio.Produto;


@WebServlet(urlPatterns = {"/cart"})
public class CarrinhoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		
		List<Produto> produtos = new LinkedList<Produto>();
		produtos = (List<Produto>) session.getAttribute("produtosSession");

		if(produtos == null) {
			produtos = new ArrayList<>();
		}
		
		
		req.getRequestDispatcher("/WEB-INF/view/carrinho.jsp").forward(req, resp);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		Produto produto = new Produto();
		Pedido pedido = new Pedido();
		List<Produto> produtos = new LinkedList<Produto>();
	
		double total = 0;
		
		produto.setId(Integer.valueOf(req.getParameter("codigo")));
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
		produtos = (List<Produto>) session.getAttribute("produtosSession");
		
		if(produtos == null) {
			produtos = new ArrayList<>();
		}
		
		
		
		session.setAttribute("produtosSession", produtos);
		
		session.setAttribute("carrinhoTotalSession", total);
		
		
		pedido.setProdutos(produtos);
		
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
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String operacao = req.getParameter("operacao");
		int indexProduto = Integer.parseInt(req.getParameter("produtoIndice"));
		
		HttpSession session = req.getSession(false);
		Pedido pedido = new Pedido();
		List<Produto> produtos = new LinkedList<Produto>();
		
		double total = (double) session.getAttribute("carrinhoTotalSession");
		
		pedido = (Pedido) session.getAttribute("pedidoSession");
		
		produtos = (List<Produto>) session.getAttribute("produtosSession");
		
		if(produtos == null) {
			produtos = new ArrayList<>();
		}
		
		session.setAttribute("produtosSession", produtos);
		
		Boolean isZero = false;
		for(Produto p: produtos) {
			if(produtos.indexOf(p) == indexProduto) {
				if(operacao.equals("decrement")) {
					p.decrementQuantidadePedido();
					
					session.setAttribute("carrinhoTotalSession", total - p.getValor());
						
					if(p.getQuantidadePedido() < 1){
						isZero = true;
					}
				}else if(operacao.equals("increment")) {
					p.incrementQuantidadePedido();
					session.setAttribute("carrinhoTotalSession", total + p.getValor());
				}
			}
		}
		if(isZero == true) {
			produtos.remove(indexProduto);
		}
		
		pedido.setProdutos(produtos);
		
		session.setAttribute("pedidoSession", pedido);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String scope = req.getParameter("scope");
		
		HttpSession session = req.getSession(true);
		Pedido pedido = new Pedido();
		List<Produto> produtos = new LinkedList<Produto>();
		
		pedido = (Pedido) session.getAttribute("pedidoSession");
		
		produtos = (List<Produto>) session.getAttribute("produtosSession");
		
		double total = 0;
		
		if(session.getAttribute("carrinhoTotalSession") != null){
			total = (double) session.getAttribute("carrinhoTotalSession");
		}
				
		if(produtos == null) {
			produtos = new ArrayList<>();
		}
		
		
		if(scope.equals("single")) {
			int indexProduto = Integer.parseInt(req.getParameter("produtoIndice"));
			Produto produto = produtos.get(indexProduto);
			session.setAttribute("carrinhoTotalSession", total - (produto.getValor() * produto.getQuantidadePedido()));
			produtos.remove(indexProduto);
			pedido.setProdutos(produtos);
			session.setAttribute("pedidoSession", pedido);
			session.setAttribute("produtosSession", produtos);
			
		}else if(scope.equals("all")) {
			session.removeAttribute("pedidoSession");
			session.removeAttribute("produtosSession");
			session.removeAttribute("carrinhoTotalSession");
		}
		
	}
}
