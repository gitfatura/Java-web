package br.com.interfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IEProdutoService {
	
	    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception;
	    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception;	    
	    public void getId(HttpServletRequest request, HttpServletResponse response) throws Exception;
	    public void getItem(HttpServletRequest request, HttpServletResponse response) throws Exception;
	    public void getAll(HttpServletRequest request, HttpServletResponse response) throws Exception;
	   

}
