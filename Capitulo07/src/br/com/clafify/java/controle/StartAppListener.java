package br.com.clafify.java.controle;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class StartAppListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("=======================");
		System.out.println("Aplica��o Iniciada");
		System.out.println("Instrutor � "+event.getServletContext().getInitParameter("instrutor"));
		System.out.println("=======================");
	}

}
