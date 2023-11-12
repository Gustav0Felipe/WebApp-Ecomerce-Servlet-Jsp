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

@WebFilter(urlPatterns = {
		"/index.jsp",
		"/principal",
		"/comprar"})
public class PrincipalFilter implements Filter{
	
	private ServletContext context;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		context = filterConfig.getServletContext();
		
		context.log("Filtro de Produtos ligado!");

	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		request.setAttribute("produtos", context.getAttribute("produtos"));
	
		context.log("Filtrando Produtos!");
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		context.log("Filtro de Produtos desligado!");
		context = null;
	}
}
