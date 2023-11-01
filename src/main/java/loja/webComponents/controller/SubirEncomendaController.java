package loja.webComponents.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import loja.negocio.Pedido;
import loja.persistencia.DAOLoja;

public class SubirEncomendaController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		Pedido pedido = new Pedido();
		
		pedido = (Pedido) session.getAttribute("pedidoSession");
		
		DAOLoja.subirEncomenda(pedido);
		
		session.removeAttribute("pedidoSession");
		session.removeAttribute("produtosSession");
		session.removeAttribute("carrinhoTotalSession");
	}
}
