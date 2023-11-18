package loja.webComponents.controllerAdmin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import loja.persistencia.DAOGerencia;


@WebServlet(urlPatterns = {"/admin"})
public class AdminController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(true);
		
		if(session.getAttribute("permitir") == null|| (Boolean) session.getAttribute("permitir") == false) {
			req.getRequestDispatcher("/WEB-INF/adm/login.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("/WEB-INF/adm/principal.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(true);
		
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		Boolean permitir = DAOGerencia.validarAdmin(email, senha);
		if(permitir == false || permitir == null) {
			resp.sendRedirect("/loja/admin");
		}else {
			session.setAttribute("permitir", true);
			req.getRequestDispatcher("/WEB-INF/adm/principal.jsp").forward(req, resp);
		}
	}
}
