package loja.webComponents.controller;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import loja.negocio.Cliente;
import loja.persistencia.DAOEcommerce;
import loja.util.EcommerceUtil;

@WebServlet(urlPatterns = {"/perfil/editar-senha/autenticar"})
public class AutenticarSenhaController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		
		if(cliente != null) {
				req.getRequestDispatcher("/WEB-INF/user/autenticarSenha.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("/loja/login");
		}
	}

	/**
	 * O cliente ira pedir alteração de senha e tera de passar sua senha atual, este metodo vai chamar a
	 * validação, e se a senha for a mesma que esta no banco de dados, vai enviar ao cliente um email com
	 * o link para alteração de senha, para confirmar que foi pedida por ele.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		
		String senha = req.getParameter("senha");
			
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		
		if(cliente == null) {
			resp.sendRedirect("/loja/login");
		
		}else {
			String msg = "";
			
			if(DAOEcommerce.autenticarSenha(cliente.getId(), senha)) {

				Map<String, String> credenciais = DAOEcommerce.getCredenciaisEmailEmpresa();
				
				String email = credenciais.get("email");
				String password = credenciais.get("senha");
				String token = EcommerceUtil.gerarStringAlphanumerica();
				
				System.out.println("http://192.168.100.16:8080/loja/perfil/editar-senha?auth="+token);
				session.setAttribute("token", token);

				msg = "Cheque seu email, lhe enviamos um link para que possa ser feita a alteração de senha.";
				req.setAttribute("messageWindow", msg);
				req.getRequestDispatcher("/mensagem.jsp").forward(req, resp);
				
				EcommerceUtil.enviarEmailAutorizar(email, password, email, email, (String) session.getAttribute("token"));
			}else {
				msg = "A senha fornecida não corresponde a que foi salva.";
				req.setAttribute("mensagem", msg);
				doGet(req, resp);
			}
		}
	}
}
	