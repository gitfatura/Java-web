package br.com.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.dao.ProdutoDao;
import br.com.entity.Produto;
import br.com.interfaces.IEService;

public class ProdutoService implements IEService<Produto> {

	private ProdutoDao dao = new ProdutoDao();

	LocalDate date = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	

	@Override
	public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		try {
		Produto produto = new Produto();
		String data = date.format(formatter);
		produto.setDescricao(request.getParameter("descricao"));
		produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
		produto.setValor(Double.parseDouble(request.getParameter("valor").replace(",", ".")));
		produto.setData(data);
		dao.save(produto);			
		} catch (Exception e) {			 
			HttpSession session = request.getSession();
			if (e.getMessage().contains("For input string")) {
				System.out.println("------------------------------------------------------------------------------------------");
				System.out.println("Log inicio"+"\n");
				System.out.println("Foi inserido um valor com formato errado "+"\n");
				System.out.println("Cause: "+e.getMessage()+"\n");
				session.setAttribute("erro_formato", "Verifique se tem algum campo com formato errado");
				System.out.println("Log fim");
				System.out.println("------------------------------------------------------------------------------------------"+"\n");
			}
		}

	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) throws Exception {				
		try {
		Produto produto = new Produto();
		String data = date.format(formatter);
		produto.setDescricao(request.getParameter("descricao").trim());
		produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade").trim()));
		produto.setValor(Double.parseDouble(request.getParameter("valor").replace(",", ".").trim()));
		produto.setData(data);
		produto.setId(Long.parseLong(request.getParameter("id").trim()));
		dao.update(produto);
		} catch (Exception e) {			 
			HttpSession session = request.getSession();
			if (e.getMessage().contains("For input string")) {
				System.out.println("------------------------------------------------------------------------------------------");
				System.out.println("Log inicio"+"\n");
				System.out.println("Foi inserido um valor com formato errado "+"\n");
				System.out.println("Cause: "+e.getMessage()+"\n");
				session.setAttribute("erro_formato", "Verifique se tem algum campo com formato errado");
				System.out.println("Log fim");
				System.out.println("------------------------------------------------------------------------------------------"+"\n");
			}

		}

	}

	public void inputProduto(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		try {
			Produto produto = new Produto();
			produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade").trim()));
			produto.setId(Long.parseLong(request.getParameter("id").trim()));
			dao.inputProduto(produto);
		} catch (Exception e) {
			HttpSession session = request.getSession();			
			if (e.getMessage().contains("For input string")) {
				System.out.println("------------------------------------------------------------------------------------------");
				System.out.println("Log inicio"+"\n");
				System.out.println("Foi inserido um valor com formato errado "+"\n");
				System.out.println("Cause: "+e.getMessage()+"\n");
				session.setAttribute("erro_formato", "Verifique se tem algum campo com formato errado e tente novamente");
				System.out.println("Log fim");
				System.out.println("------------------------------------------------------------------------------------------"+"\n");
			}
		}
	}
	
	public void decreaseProduto(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			Produto produto = new Produto();
			produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade").trim()));
			produto.setId(Long.parseLong(request.getParameter("id").trim()));
			Produto p = dao.getId(Integer.parseInt(request.getParameter("id").trim()));
			
			if (p.getQuantidade() < produto.getQuantidade()) {
				HttpSession session = request.getSession();
				System.out.println("------------------------------------------------------------------------------------------");
				System.out.println("Log inicio");
				session.setAttribute("quantidade_baixa", "A quantidade a ser baixada não pode ser maior que a quantidade existente"+"\n");
				System.out.println("A quantidade a ser baixada não pode ser menor que a quantidade existente");
				System.out.println("Log fim");
				System.out.println("------------------------------------------------------------------------------------------"+"\n");
				return;
			}else{
				
				dao.decreaseProduto(produto);
			
			}
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
			HttpSession session = request.getSession();			
			if (e.getMessage().contains("For input string")) {
				System.out.println("------------------------------------------------------------------------------------------");
				System.out.println("Log inicio"+"\n");
				System.out.println("Foi inserido um valor com formato errado "+"\n");
				System.out.println("Cause: "+e.getMessage()+"\n");
				session.setAttribute("erro_formato", "Verifique se tem algum campo com formato errado");
				System.out.println("Log fim");
				System.out.println("------------------------------------------------------------------------------------------"+"\n");
				
			}
		}
	}

	@Override
	public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			Produto produto = dao.getId(Integer.parseInt(request.getParameter("id")));
			dao.remove(produto);
		} catch (Exception e) {
			HttpSession session = request.getSession();			
			if (e.getMessage().contains("For input string")) {
				System.out.println("------------------------------------------------------------------------------------------");
				System.out.println("Log inicio"+"\n");
				System.out.println("Foi inserido um valor com formato errado "+"\n");
				System.out.println("Cause: "+e.getMessage()+"\n");
				session.setAttribute("erro_formato", "Verifique se tem algum campo com formato errado");
				System.out.println("Log fim");
				System.out.println("------------------------------------------------------------------------------------------"+"\n");
				
			}
		}

	}

	@Override
	public void getAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Produto> produtos = dao.getAll();
		request.setAttribute("produtos", produtos);

	}

	@Override
	public void getId(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Produto produto = dao.getId(Integer.parseInt(request.getParameter("id")));
		if (produto == null) {
			HttpSession session = request.getSession();
			session.setAttribute("erro_id", "Id não existe");
		} else {
			request.setAttribute("produto", produto);
		}
	}

	@Override
	public void getProduto(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Produto> produtos = dao.getProduto(request.getParameter("descricao"));
		request.setAttribute("produtos", produtos);
	}
}
