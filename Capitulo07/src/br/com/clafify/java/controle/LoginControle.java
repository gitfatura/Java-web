package br.com.clafify.java.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.clafify.java.modelo.Usuario;
import br.com.clafify.java.repositorio.UsuarioRepositorio;

/**
 * Servlet implementation class LoginControle
 */
@WebServlet({"/", "/login", "/autenticar", "/logoff" })
public class LoginControle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioRepositorio repositorio = new UsuarioRepositorio();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		executar(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		executar(request, response);
	}

	private void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getContextPath();
		String uri = request.getRequestURI();
		if (uri.equalsIgnoreCase(path + "/login") ||uri.equalsIgnoreCase(path + "/")) {
			login(request, response);
		} else if (uri.equalsIgnoreCase(path + "/autenticar")) {
			autenticar(request, response);
		} else if (uri.equalsIgnoreCase(path + "/logoff")) {
			logoff(request, response);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);

	}

	private void autenticar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!request.getMethod().equalsIgnoreCase("post")) {
			response.sendError(401);
		} else {

			String nome = request.getParameter("nome");
			String senha = request.getParameter("senha");
			Usuario usuario = repositorio.buscarPorNome(nome);
			if (usuario != null && senha != null && senha.equals(usuario.getSenha())) {
				HttpSession session = request.getSession();
				//configura o tempo máximo de inatividade da sessão em segundos
				//session.setMaxInactiveInterval(20);
				session.setAttribute("usuarioLogado", usuario);
				response.sendRedirect(request.getContextPath() + "/contatos");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("login_erro", "Usuario ou senha inválido");
				response.sendRedirect(request.getContextPath() + "/login");
			}
		}

	}

	private void logoff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath() + "/login");

	}

}
