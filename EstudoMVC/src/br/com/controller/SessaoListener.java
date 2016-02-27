package br.com.controller;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessaoListener implements HttpSessionListener {

	private int count = 0;

	@Override
	public void sessionCreated(HttpSessionEvent event) {

		count++;
		System.out.println("============================");
		System.out.println("Log add contador" + count);
		event.getSession().getServletContext().setAttribute("totalUsuarios", count);
		System.out.println("============================");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		count--;
		System.out.println("============================");
		System.out.println("Log remove contador" + count);
		System.out.println("============================");
		event.getSession().getServletContext().setAttribute("totalUsuarios", count);

	}

}
