package br.com.controller;

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

import br.com.model.Usuario;

@WebFilter(urlPatterns={"/*"})
public class AltenticacaoFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession(false);

//		if (isResources(request)) {
//			chain.doFilter(req, resp);
//		} else 
		if (!isUsuarioLogado(session) && !isAutenticado(request)) {
			HttpServletResponse response = (HttpServletResponse) resp;
			response.sendRedirect(request.getContextPath() + "/login");
		} else {

			Usuario  usuario = (Usuario) session.getAttribute("usuarioLogado");
			 String uri = request.getRequestURI();

			 if (uri.endsWith("/novo") || uri.endsWith("/remover") || uri.endsWith("/contatos")) {
				 if (!usuario.getUsuario().equals("Usuario3")) {
					HttpServletResponse response = (HttpServletResponse) req;
					response.sendError(403);
				}else{
					chain.doFilter(req, resp);
				}
				  
			}else{
				chain.doFilter(req, resp);
			}
			
		}

	}

	private boolean isResources(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		return requestURI.startsWith(request.getContextPath() + "/resources/");
	}

	private boolean isUsuarioLogado(HttpSession session) {
		return session != null && session.getAttribute("usuarioLogado") != null;
	}

	private boolean isAutenticado(HttpServletRequest request) {
		String uri = request.getRequestURI();
		return uri.equals(request.getContextPath() + "/login") || uri.equals(request.getContextPath() + "/autentica");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
