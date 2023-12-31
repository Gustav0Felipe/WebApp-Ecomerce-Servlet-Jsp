package loja.webComponents.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import loja.negocio.Produto;
import loja.persistencia.DAOEcommerce;


@WebServlet(urlPatterns = {"/comprar"})
public class ComprarController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Produto produto = new Produto();
		produto = DAOEcommerce.buscarProduto(Integer.parseInt(req.getParameter("produto")));
		req.setAttribute("produto", produto);
		req.getRequestDispatcher("/WEB-INF/view/comprar.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
