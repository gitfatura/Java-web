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

@WebFilter("/*")
public class AltenticacaoFilter3 implements Filter {

	private int contador = 0;
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
	 
		HttpServletRequest request = (HttpServletRequest) req;
		if (request.getRequestURI().equals(request.getContextPath()+"/contatos")) {
			contador++;
			System.out.println("Contador "+contador);
			
		}
		chain.doFilter(req, resp);
		
	}
 
	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
