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

@WebServlet(urlPatterns = {"/perfil/editar"})
public class EditarController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		
		if(cliente != null) {
				req.getRequestDispatcher("/WEB-INF/user/perfilEditar.jsp").forward(req, resp);
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
		Boolean sucesso = DAOEcommerce.atualizarDadosCliente(idCliente , nome, telefone);
		
		String msg = "";
		if(sucesso) {
			cliente.setNome(nome);
			cliente.setTelefone(telefone);
		
			session.setAttribute("cliente", cliente);
			msg = "Dados alterados com sucesso.";
		}else {
			msg = "Falha na alteração de dados.";
		}
		req.setAttribute("messageWindow", msg);
		req.getRequestDispatcher("/mensagem.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("/loja/login");
		}
	}
}
