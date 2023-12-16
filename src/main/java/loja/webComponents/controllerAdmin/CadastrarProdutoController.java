package loja.webComponents.controllerAdmin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import loja.negocio.Produto;
import loja.persistencia.DAOGerencia;

@MultipartConfig
@WebServlet(urlPatterns = {"/admin/cadastrar-produto"})
public class CadastrarProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(true);
		
		if(session.getAttribute("permitir") == null|| (Boolean) session.getAttribute("permitir") == false) {
			resp.sendRedirect("/loja/admin");
			return;
		}else {
			req.getRequestDispatcher("/WEB-INF/adm/cadastrar_produto.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext context = req.getServletContext();
		
		HttpSession session = req.getSession(true);
		
		if(session.getAttribute("permitir") == null|| (Boolean) session.getAttribute("permitir") == false) {
			resp.sendRedirect("/loja/admin");
			return;
		}
		
		String path = "C:\\Users\\55119\\Desktop\\Estudos\\Impacta\\Java\\WebApp-Ecomerce-Servlet-Jsp\\src\\main\\webapp\\imagens"; //req.getServletContext().getRealPath("/imagens");
		
		Produto produto = new Produto();
		
		int categoria = Integer.parseInt(req.getParameter("categoria"));
		
		produto.setNome(req.getParameter("nome"));
		produto.setDesc(req.getParameter("desc"));
		produto.setCusto(Double.parseDouble(req.getParameter("custo")));
		produto.setValor(Double.parseDouble(req.getParameter("valor")));
		produto.setQtd_estq(Integer.parseInt(req.getParameter("estoque")));
		
		
		int codigo_do_produto = DAOGerencia.cadastrarProduto(produto, categoria);
		System.out.println(path + "\\" + codigo_do_produto);
		
		if(codigo_do_produto == 0) {
			req.getRequestDispatcher("/mensagem.jsp").forward(req, resp);
			return;
		}
		
		try {
			//Pego todas as partes do formulario.
			for(Part part : req.getParts()) {
				//checo se é um arquivo.
				if(part.getName().equals("imagem")) {
					//copio o arquivo, o separator é uma barra para separar, e o getSubmittedFileName vai pegar o nome do arquivo que foi enviado.
					part.write(path + "\\" + codigo_do_produto + ".png");
					
					@SuppressWarnings("unchecked")
					List<Integer> produtos = (List<Integer>) context.getAttribute("produtos");
					produtos.add(codigo_do_produto);
					context.setAttribute("produtos", produtos);
				}
			}
			req.setAttribute("messageWindow", "Arquivo carregado com sucesso");
		}catch(Exception ex){
			System.out.println("Falha ao salvar arquivo: " + ex.getMessage());
		}
		
		req.getRequestDispatcher("/mensagem.jsp").forward(req, resp);
	}
}
