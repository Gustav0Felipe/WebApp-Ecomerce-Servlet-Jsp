package loja.webComponents.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OfertasPrincipalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/principal.jsp").forward(req, resp);
		List<Integer> produtos = (List<Integer>) req.getAttribute("produtos");
		for(Integer p : produtos){
			System.out.println(p);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
