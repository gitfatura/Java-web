package br.com.clafify.java.controle;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class SessaoListener implements HttpSessionListener {
	private static int contador = 0;
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		contador++;
		System.out.println("LOG ADD Contador = "+contador);
		event.getSession().getServletContext().setAttribute("totalUsuarios", contador);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		contador--;
		System.out.println("LOG Remove Contador = "+contador);
		event.getSession().getServletContext().removeAttribute("totalUsuarios");
		event.getSession().getServletContext().setAttribute("totalUsuarios", contador);
		
	}

}
