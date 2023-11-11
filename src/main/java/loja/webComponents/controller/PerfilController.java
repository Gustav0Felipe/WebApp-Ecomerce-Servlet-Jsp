package loja.webComponents.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import loja.negocio.Cliente;


public class PerfilController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(true);
		
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		
		if(cliente == null) {
			req.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(req, resp);
		}else {
			session.setAttribute("cliente", cliente);
			req.getRequestDispatcher("/WEB-INF/user/perfil.jsp").forward(req, resp);
		}
	}
}
