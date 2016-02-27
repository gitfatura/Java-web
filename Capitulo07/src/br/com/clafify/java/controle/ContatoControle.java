package br.com.clafify.java.controle;

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

import br.com.clafify.java.modelo.Contato;
import br.com.clafify.java.negocio.ContatoValidador;
import br.com.clafify.java.repositorio.ContatoRepositorio;

/**
 * Servlet implementation class ContatoControle
 */
@WebServlet(urlPatterns = { "/contatos", "/contato/novo", "/contato/editar", "/contato/salvar",
		"/contato/remover" }, description = "controlador de contatos")
public class ContatoControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ContatoRepositorio repositorio = new ContatoRepositorio();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	protected void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String instrutor = getServletContext().getInitParameter("instrutor");
		System.out.println("Instrutor é "+instrutor);
		String path = request.getContextPath();
		String uri = request.getRequestURI();
		
		Cookie cookie = new Cookie("ultimo_acessso",DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.MEDIUM).format(new Date()));
		response.addCookie(cookie);
		if (uri.equals(path + "/contatos")) {
			listar(request, response);
		} else if (uri.equals(path + "/contato/novo")) {
			novo(request, response);
		} else if (uri.equals(path + "/contato/editar")) {
			editar(request, response);
		} else if (uri.equals(path + "/contato/salvar")) {
			salvar(request, response);
		} else if (uri.equals(path + "/contato/remover")) {
			remover(request, response);
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		request.setAttribute("contatos", repositorio.buscarTodos());
		request.getRequestDispatcher("/lista.jsp").forward(request, response);
	}

	private void novo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String mensagem = "Novo";
		request.setAttribute("mensagem", mensagem);
		request.getRequestDispatcher( "/formulario.jsp").forward(request, response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String mensagem = "Editar";
		String id = request.getParameter("id");
		Contato contato = repositorio.buscarPorId(id);
		if(contato != null){
			request.setAttribute("mensagem", mensagem);
			request.setAttribute("contato", contato);
			request.getRequestDispatcher("/formulario.jsp").forward(request, response);
		}
	}

	private void salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!request.getMethod().equalsIgnoreCase("post")){
			response.sendError(401);
		}else{
			String path = request.getContextPath();
			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String telefone = request.getParameter("telefone");
			
			if(id == null || "".equals(id.trim())){
				id = null;
			}
			Contato contato = new Contato(id, nome, email, telefone);
			ContatoValidador validador = new ContatoValidador();
			if(validador.isValido(contato)){
				repositorio.salvar(contato);
				response.sendRedirect(path + "/contatos");
			}else{
				HttpSession session = request.getSession();
				for(Map.Entry<String, String> erro : validador.getErros().entrySet()){
					session.setAttribute(erro.getKey(), erro.getValue());
					
				}
				session.setAttribute("contato", contato);
				if(id == null){
					response.sendRedirect(path + "/contato/novo");
				}else{
					response.sendRedirect(path + "/contato/editar?id="+id);
				}
				
			}
			
		}
		
	}

	private void remover(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getContextPath();
		
		String id = request.getParameter("id");
		Contato contato = repositorio.buscarPorId(id);
		if(contato != null){
			repositorio.remover(contato);
		}
		response.sendRedirect(path + "/contatos");

	}

}
