package br.com.clafify.java.controle;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogFiltro implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		Long ti = System.currentTimeMillis();

		chain.doFilter(req, resp);

		Long total = System.currentTimeMillis() - ti;

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String requestURI = request.getRequestURI();
		if(requestURI.endsWith(".css")){
			response.setHeader("Content-Type", "text/css");
		}
		System.out.println(String.format("LOG Tempo location = %s tempo total = %d, tipe =%s", requestURI, total, response.getContentType()));

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
