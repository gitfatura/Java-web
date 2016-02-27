package br.com.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.repositorio.*;
import br.com.model.*;
import br.com.negocio.ContatoValidador;


@WebServlet({ "/contatos", "/contato/novo", "/contato/editar", "/contato/salvar", "/contato/remover" })
public class ContatoControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ContatoRepositorio repositorio = new ContatoRepositorio();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		executa(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		executa(request, response);
	}

	protected void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie  cookie = new Cookie("ultimo_acesso", DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.MEDIUM).format(new Date()));
		//cookie.setMaxAge(2);
		response.addCookie(cookie);
		String initParameter = getServletContext().getInitParameter("instrutor");
		System.out.println("Intrutor é : "+initParameter);
		String path = request.getContextPath();
		String uri = request.getRequestURI();
		if (uri.equalsIgnoreCase(path + "/contatos")) {
			lista(request, response);
		} else if (uri.equalsIgnoreCase(path + "/contato/novo")) {
			novo(request, response);
		} else if (uri.equalsIgnoreCase(path + "/contato/salvar")) {
			salvar(request, response);
		} else if (uri.equalsIgnoreCase(path + "/contato/editar")) {
			editar(request, response);
		} else if (uri.equalsIgnoreCase(path + "/contato/remover")) {
			remover(request, response);
		}

	}

	private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("contatos", repositorio.buscarTodos());
		request.getRequestDispatcher("/lista.jsp").forward(request, response);

	}

	private void novo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("mensagem", "Novo");
		request.getRequestDispatcher("/formulario.jsp").forward(request, response);

	}

	private void salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();
		String path = request.getContextPath();
		if (!method.equalsIgnoreCase("POST")) {
			response.sendError(401);
		} else {
			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String telefone = request.getParameter("telefone");
			if (id == null || "".equals(id.trim())) {
				id = null;
			}
			Contato contato = new Contato(id, nome, email, telefone);
			ContatoValidador validador = new ContatoValidador();

			if (validador.isValido(contato)) {
				repositorio.salvar(contato);
				response.sendRedirect(path + "/contatos");
			} else {
				HttpSession session = request.getSession();
				for(Map.Entry<String, String> erro : validador.getErros().entrySet()){
					session.setAttribute(erro.getKey(), erro.getValue());
				}
				session.setAttribute("contato", contato);
				if (id == null) {
					response.sendRedirect(path+"/contato/novo");
				}else{
					response.sendRedirect(path+"/contato/editar?id="+id);
				}

			}

		}
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Contato contato = repositorio.buscarPorId(request.getParameter("id"));
		if (contato != null) {
			request.setAttribute("contato", contato);
			request.getRequestDispatcher("/formulario.jsp").forward(request, response);
		}

	}

	private void remover(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Contato contato = repositorio.buscarPorId(request.getParameter("id"));
		if (contato != null) {
			repositorio.remover(contato);
			response.sendRedirect(request.getContextPath() + "/contatos");
		}

	}

}
