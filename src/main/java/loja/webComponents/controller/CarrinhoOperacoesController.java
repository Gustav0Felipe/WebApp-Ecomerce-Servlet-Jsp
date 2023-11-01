package loja.webComponents.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import loja.negocio.Pedido;
import loja.negocio.Produto;


public class CarrinhoOperacoesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		
		session.removeAttribute("pedidoSession");
		session.removeAttribute("produtosSession");
		session.removeAttribute("carrinhoTotalSession");
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int indexProduto = Integer.parseInt(req.getParameter("produtoIndice"));
		System.out.println(indexProduto);
		
		HttpSession session = req.getSession(false);
		Pedido pedido = new Pedido();
		List<Produto> produtos = new LinkedList<Produto>();
		
		pedido = (Pedido) session.getAttribute("pedidoSession");
		
		produtos = (List<Produto>) session.getAttribute("produtosSession");
		
		if(produtos == null) {
			produtos = new ArrayList<>();
		}
		
		session.setAttribute("produtosSession", produtos);
		
		for(Produto p: produtos) {
			if(produtos.indexOf(p) == indexProduto) {
				p.incrementQuantidadePedido();
			}
		}
		
		pedido.setProdutos(produtos);
		
		session.setAttribute("pedidoSession", pedido);
		
		req.getRequestDispatcher("/WEB-INF/view/carrinho.jsp").forward(req, resp);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int indexProduto = Integer.parseInt(req.getParameter("produtoIndice"));
		HttpSession session = req.getSession(false);
		Pedido pedido = new Pedido();
		List<Produto> produtos = new LinkedList<Produto>();
		
		pedido = (Pedido) session.getAttribute("pedidoSession");
		
		produtos = (List<Produto>) session.getAttribute("produtosSession");
		
		if(produtos == null) {
			produtos = new ArrayList<>();
		}
		
		session.setAttribute("produtosSession", produtos);
		
		Boolean isZero = false;
		
		for(Produto p: produtos) {
			if(produtos.indexOf(p) == indexProduto) {
				p.decrementQuantidadePedido();
				if(p.getQuantidadePedido() < 1){
					isZero = true;
				}
			}
		}
		
		if(isZero == true) {
			produtos.remove(indexProduto);
		}
		
		pedido.setProdutos(produtos);
		
		session.setAttribute("pedidoSession", pedido);
		
		//req.getRequestDispatcher("/WEB-INF/view/carrinho.jsp").forward(req, resp);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int indexProduto = Integer.parseInt(req.getParameter("produtoIndice"));
		
		HttpSession session = req.getSession(false);
		Pedido pedido = new Pedido();
		List<Produto> produtos = new LinkedList<Produto>();
		
		pedido = (Pedido) session.getAttribute("pedidoSession");
		
		produtos = (List<Produto>) session.getAttribute("produtosSession");
		
		if(produtos == null) {
			produtos = new ArrayList<>();
		}
		
		session.setAttribute("produtosSession", produtos);
		
		produtos.remove(indexProduto);
		
		pedido.setProdutos(produtos);
		
		session.setAttribute("pedidoSession", pedido);
		
		
	}
}
