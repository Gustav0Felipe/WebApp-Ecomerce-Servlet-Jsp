package loja.webComponents.listener;

import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import loja.persistencia.DAOEcommerce;


@WebListener
public class ListProdutoListener implements ServletContextListener {

	@Override
    public void contextInitialized(ServletContextEvent sce)  { 
		ServletContext context = sce.getServletContext();
		
		List<Integer> produtos = DAOEcommerce.listarIdProdutos();
		
		context.setAttribute("produtos", produtos);
		
		context.log("Produtos carregados no contexto.");
    }
	
	@Override
    public void contextDestroyed(ServletContextEvent sce)  { 
    
		ServletContext context = sce.getServletContext();
		
		context.removeAttribute("produtos");
		
		context.log("Produtos removidos do contexto.");
    }
}
