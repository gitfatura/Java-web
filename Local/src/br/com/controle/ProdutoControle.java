package br.com.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.service.*;


@WebServlet(urlPatterns={ "/new-produto","/save-produto", "/id-produto", "/all-produto", "/update-produto", "/remove-produto","/get-produto",
		"/get-id-produto", "/id-input-produto","/id-decrease-produto","/input-produto","/decrease-produto","/teste"})
public class ProdutoControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProdutoService service = new ProdutoService(); 
	
	
    public ProdutoControle() {
        
        System.out.println("Inicio da servlet produto");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		executa(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		executa(request, response);
	}
	
	private void executa(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		String path = request.getContextPath();
		String uri = request.getRequestURI();
		
		try {
			
			if (uri.equalsIgnoreCase(path+"/new-produto")) {
				
				request.getRequestDispatcher("/new-produto.jsp").forward(request, response);
							
			}if(uri.equalsIgnoreCase(path+"/save-produto")){
				
				service.save(request, response);
				
				request.getRequestDispatcher("/new-produto.jsp").forward(request, response);
				
			}if(uri.equalsIgnoreCase(path+"/all-produto")){
				
				service.getAll(request, response);
				request.getRequestDispatcher("/all-produtos.jsp").forward(request, response);
				
			}if (uri.equalsIgnoreCase(path+"/id-produto")) {
				
				service.getId(request, response);
				request.getRequestDispatcher("/update-produto.jsp").forward(request, response);
				
			}if (uri.equalsIgnoreCase(path+"/update-produto")) {
				
				service.update(request, response);
				response.sendRedirect(path+"/all-produto");
				 
				
			}if (uri.equalsIgnoreCase(path+"/remove-produto")) {
				
				service.remove(request, response);
				response.sendRedirect(path+"/all-produto");
						
			}if (uri.equalsIgnoreCase(path+"/get-produto")) {
				 
				service.getProduto(request, response);
				request.getRequestDispatcher("/all-produtos.jsp").forward(request, response);
		
			}if (uri.equalsIgnoreCase(path+"/get-id-produto")) {
				
				service.getId(request, response);
				request.getRequestDispatcher("/get-produto.jsp").forward(request, response);
				
			}if (uri.equalsIgnoreCase(path+"/id-input-produto")) {
				
				service.getId(request, response);
				request.getRequestDispatcher("/input-produto.jsp").forward(request, response);
				
			}if (uri.equalsIgnoreCase(path+"/id-decrease-produto")) {
				
				service.getId(request, response);
				request.getRequestDispatcher("/decrease-produto.jsp").forward(request, response);	
				
			}if (uri.equalsIgnoreCase(path+"/input-produto")) {
				
				service.inputProduto(request, response);
				request.getRequestDispatcher("/input-produto.jsp").forward(request, response);
				
			}if (uri.equalsIgnoreCase(path+"/decrease-produto")) {
				
				service.decreaseProduto(request, response);
				request.getRequestDispatcher("/decrease-produto.jsp").forward(request, response);
			}if (uri.equals(path+"/teste")) {
				
				request.getRequestDispatcher("/teste.jsp").forward(request, response);
			}
			
			
		} catch (Exception e) {
	 	
			
		}
		 
	}

	
	@Override
	public void destroy() {
		System.out.println("Fim da servlet produto");
		
	}
}
