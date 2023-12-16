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


@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(true);
		
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		
		if(cliente == null) {
			req.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(req, resp);
		}else {
			session.setAttribute("cliente", cliente);
			resp.sendRedirect("/loja/perfil");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		Cliente cliente = DAOEcommerce.validarLogin(email, senha);
		if(cliente == null) {
			req.setAttribute("mensagem", "Este cliente não existe");
			doGet(req, resp);
		}else {
			session.setAttribute("cliente", cliente);
			resp.sendRedirect("/loja/perfil");
		}
	}
}
