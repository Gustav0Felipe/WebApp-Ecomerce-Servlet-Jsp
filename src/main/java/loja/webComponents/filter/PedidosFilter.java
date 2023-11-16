package loja.webComponents.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import loja.persistencia.DAOGerencia;

@WebFilter(urlPatterns = {
		"/admin/pedidos"
		})
public class PedidosFilter implements Filter {
   
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		request.setAttribute("pedidos", DAOGerencia.listarPedidos());
		
		chain.doFilter(request, response);
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}
	
}
