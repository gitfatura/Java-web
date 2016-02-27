package br.com.clafify.java.controle;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns={"/*"})
public class AutenticacaoFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession(false);
		if(isResources(request)){
			chain.doFilter(req, resp);
		}else 	if(!isUsuarioLogado(session) && !isAutenticacao(request)){
			HttpServletResponse response = (HttpServletResponse) resp;
			response.sendRedirect(request.getContextPath()+"/login");
		}else{
			//prosegue com a requisição
			chain.doFilter(req, resp);
		}
		
		
	}
	private boolean isResources(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		return requestURI.contains(".css");
	}

	private boolean isUsuarioLogado(HttpSession session){
		return session != null && session.getAttribute("usuarioLogado") != null;
	}
	
	private boolean isAutenticacao(HttpServletRequest request){
		String requestURI = request.getRequestURI();
		return requestURI.equals(request.getContextPath()+"/login") || requestURI.equals(request.getContextPath()+"/autenticar");
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
