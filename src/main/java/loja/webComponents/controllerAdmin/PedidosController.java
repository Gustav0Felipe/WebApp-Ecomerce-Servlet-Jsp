package loja.webComponents.controllerAdmin;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import loja.negocioView.PedidoView;
import loja.persistencia.DAOGerencia;
import loja.util.EcommerceUtil;


@WebServlet(urlPatterns = {"/admin/pedidos", "/admin/pedidos/*"})
public class PedidosController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(true);
		
		if(session.getAttribute("permitir") == null|| (Boolean) session.getAttribute("permitir") == false) {
			resp.sendRedirect("/loja/admin");
			return;
		}
		String pathInfo = req.getPathInfo(); 

		if(pathInfo != null){
		String[] pathParts = pathInfo.split("/");
			if(pathParts.length != 0) {
				String value = pathParts[1];
				if (EcommerceUtil.stringIsInteger(value)) {
					PedidoView pedido = DAOGerencia.buscarPedido(value);
				
					req.setAttribute("pedido", pedido);
					req.getRequestDispatcher("/WEB-INF/adm/pedido.jsp").forward(req, resp);
					return;
				}
			}
		}
		req.getRequestDispatcher("/WEB-INF/adm/pedidos.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
