package br.com.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.dao.*;
import br.com.entity.*;
import br.com.interfaces.*;

public class ProdutoService implements IEProdutoService {

	ProdutoDAO dao = new ProdutoDAO();
	LocalDate date = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	
	@Override
	public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Produto produto = new Produto();
		
		String id = request.getParameter("id");
		String srtdata = date.format(formatter);
		
		produto.setDescricao(request.getParameter("descricao"));
		produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
		produto.setPreco(Double.parseDouble(request.getParameter("preco").replace(",", "")));
		produto.setTotal(Double.parseDouble(request.getParameter("total").replace(",", "")));
		produto.setData(srtdata);
	
		if (id == null || "".equals(id.trim())) {
			
			dao.save(produto);
			
		} else if (id != null || !"".equals(id.trim())) {
		
			produto.setId(Integer.parseInt(id));
			dao.update(produto);
		}

	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Produto produto = dao.getId(Integer.parseInt(request.getParameter("id")));
		dao.delete(produto);
	}

	@Override
	public void getId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Produto produto = dao.getId(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("produto", produto);
	}

	@Override
	public void getItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Produto> produtos = dao.getProduto(request.getParameter("pesquisa"));
		request.setAttribute("produtos", produtos);

	}

	@Override
	public void getAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Produto> produtos = dao.getAll();
		request.setAttribute("produtos", produtos);

	}


}
