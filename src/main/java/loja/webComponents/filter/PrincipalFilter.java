package loja.webComponents.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import loja.persistencia.DAOEcommerce;

@WebFilter(urlPatterns = {
		"/index.jsp",
		"/principal",
		"/comprar"})
public class PrincipalFilter implements Filter{
	
	private ServletContext context;
	//private UfFacade facade;
	@Override
	public void destroy() {
		context.log("Filtro de Produtos desligado!");
		context = null;
		//facade = null;
	}
	
	//FilterChain padrão do filtro para chamar o proximo filtro
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//ServletContext context;
		//UfFacade facade;
		
		//context = request.getServletContext();
		//facade = (UfFacade) context.getAttribute(UfFacade.NAME);
		
		request.setAttribute("produtos", DAOEcommerce.listarNomeProdutos());
	
		context.log("Filtrando Produtos em ação!");
		
		//se eu não coloco isso ele para nesse filter e não redireciona para ninguem.
		chain.doFilter(request, response);
	}

	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		context = filterConfig.getServletContext();
		//facade = (UfFacade) context.getAttribute(UfFacade.NAME);
		
		context.log("Filtro de Produtos ligado!");

	}
}
