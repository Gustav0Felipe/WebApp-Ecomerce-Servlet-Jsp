package loja.webComponents.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import loja.persistencia.DAOEcommerce;

/**
 * Servlet implementation class CadastroController
 */
public class CadastroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/user/cadastro.jsp").forward(req, resp);
	
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String telefone = req.getParameter("telefone");
		String senha = req.getParameter("senha");
		String cpf = req.getParameter("cpf");
		
		DAOEcommerce.cadastrarCliente(nome, email, telefone, senha, cpf);
		
		req.getRequestDispatcher("/WEB-INF/user/cadastro.jsp").forward(req, resp);
		
	}

}
