package loja.webComponents.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import loja.negocio.Cliente;
import loja.negocio.Pedido;
import loja.persistencia.DAOEcommerce;

public class SubirEncomendaController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		Pedido pedido = new Pedido();
		Cliente cliente = new Cliente();
		
		cliente = (Cliente) session.getAttribute("cliente");
		pedido = (Pedido) session.getAttribute("pedidoSession");
		
		if(pedido == null || pedido.getProdutos().size() < 1) {
			resp.sendRedirect("/loja/cart");
		}else{
			if(cliente != null){
				pedido.setCliente(cliente.getId());
				DAOEcommerce.subirEncomenda(pedido);
			
				session.removeAttribute("pedidoSession");
				session.removeAttribute("produtosSession");
				session.removeAttribute("carrinhoTotalSession");
			}else{
				req.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(req, resp);
			}
		}
	}
}
