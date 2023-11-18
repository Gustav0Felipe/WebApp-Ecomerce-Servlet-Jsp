package loja.webComponents.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import loja.negocio.Cliente;
import loja.persistencia.DAOEcommerce;

@WebServlet(urlPatterns = {"/editar"})
public class EditarController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		
		if(cliente != null) {
			if(req.getParameter("edit") == null) {
				req.getRequestDispatcher("/WEB-INF/user/perfilEditar.jsp").forward(req, resp);
			}else {
				req.getRequestDispatcher("/WEB-INF/user/editarSenha.jsp").forward(req, resp);
			}
		}else {
			resp.sendRedirect("/loja/login");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		
		Cliente cliente = (Cliente) session.getAttribute("cliente");
	
		if(cliente != null) {
		String nome = req.getParameter("nome");
		String telefone = req.getParameter("telefone");
		int idCliente = cliente.getId();
		DAOEcommerce.atualizarDadosCliente(idCliente , nome, telefone);
		
		req.getRequestDispatcher("/WEB-INF/user/perfilEditar.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("/loja/login");
		}
	}
}
