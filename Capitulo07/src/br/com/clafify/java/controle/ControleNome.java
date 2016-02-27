package br.com.clafify.java.controle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.clafify.java.modelo.Cachorro;
import br.com.clafify.java.modelo.Pessoa;

/**
 * Servlet implementation class ControleNome
 */
@WebServlet("/mostrar_nome")
public class ControleNome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		request.setAttribute("batatinha", nome);
		HttpSession session = request.getSession();
		session.setAttribute("curso", "Java Web");
		request.setAttribute("foo.bar", "Testando 123");
		String[] nomes = {"Felipe","Tiago","José"};
		request.setAttribute("nomes", nomes);
		getServletContext().setAttribute("curso2", "Android");
		
		Pessoa pessoa = new Pessoa("Tiago",24,new Cachorro("Betoven"));
		request.setAttribute("pessoa", pessoa);
		Map<String,Object>dados = new HashMap<String,Object>();
		dados.put("nome", nomes);
		dados.put("endereco", "Rua dos Caçadores");
		request.setAttribute("dados", dados);
		request.setAttribute("nota1", 8);
		request.setAttribute("nota2", 10);
		request.setAttribute("nota3", 10);
		RequestDispatcher dispatcher = request.getRequestDispatcher("mostra_nome.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
