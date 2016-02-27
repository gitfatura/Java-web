package br.com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/produtos", "/novo", "/salvar", "/editar", "/remover"})
public class ProdutoControle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		executa(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		executa(request, response);
	}

	private void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			ProdutoService service = new ProdutoService();
			String uri = request.getRequestURI();
			String path = request.getContextPath();

			if (uri.equalsIgnoreCase(path+"/produtos")) {				
				service.getAll(request, response);
				request.getRequestDispatcher("/produtos.jsp").forward(request, response);
				
			}else if (uri.equalsIgnoreCase(path + "/novo")) {				 
				request.getRequestDispatcher("/produto.jsp").forward(request, response);
				
			} else if (uri.equalsIgnoreCase(path + "/salvar")) {
				service.save(request, response);
				response.sendRedirect(path+"/produtos");
				
			}else if (uri.equalsIgnoreCase(path+"/editar")) {
				service.getId(request, response);				
				request.getRequestDispatcher("/produto.jsp").forward(request, response);
				
			}else if (uri.equalsIgnoreCase(path+"/remover")) {
				service.delete(request, response);
				response.sendRedirect(path+"/produtos");
				
			} 

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
