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


@WebServlet(urlPatterns = {"/cadastro"})
public class CadastroController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/user/cadastro.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String telefone = req.getParameter("telefone");
		String senha = req.getParameter("senha");
		String cpf = req.getParameter("cpf");
		
		DAOEcommerce.cadastrarCliente(nome, email, telefone, senha, cpf);
		
		Cliente cliente = DAOEcommerce.validarLogin(email, senha);
		
		session.setAttribute("cliente", cliente);
		
		req.getRequestDispatcher("/WEB-INF/user/perfil.jsp").forward(req, resp);
	}
	
}
