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

@WebServlet(urlPatterns = {"/editar-senha"})
public class EditarSenhaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session = req.getSession(true);
		
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		
		if(cliente != null) {
			if(req.getParameter("auth") == null) {
				req.getRequestDispatcher("/WEB-INF/user/autenticarSenha.jsp").forward(req, resp);
			}else {
				if(session.getAttribute("token") != null && session.getAttribute("token").equals(req.getParameter("auth"))) {
					req.getRequestDispatcher("/WEB-INF/user/editarSenha.jsp").forward(req, resp);
					}
				else {
					req.getRequestDispatcher("/WEB-INF/user/perfil.jsp").forward(req, resp);
				}
			}
		}
		else {
			req.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		
		String novaSenha = req.getParameter("senha");
		
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		session.setAttribute("cliente", cliente);
		if(cliente != null) {	
		DAOEcommerce.atualizarSenhaCliente(cliente.getId(), novaSenha);
			
		session.removeAttribute("token");
		
		String msg = "Alteração feita com sucesso.";
		
		req.setAttribute("messageWindow", msg);
		req.getRequestDispatcher("/mensagem.jsp").forward(req, resp);
		
		}
	}
}
