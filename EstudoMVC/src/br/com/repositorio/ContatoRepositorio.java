package br.com.repositorio;

import java.util.ArrayList;
import java.util.List;
import br.com.model.Contato;

public class ContatoRepositorio {
	
	private static List<Contato> lista = new ArrayList<Contato>();
	
	static{
		lista.add(new Contato(String.valueOf(System.currentTimeMillis()+1), "Contato1", "contato1@teste", "33221100"));
		lista.add(new Contato(String.valueOf(System.currentTimeMillis()+2), "Contato2", "contato2@teste", "33221102"));
		lista.add(new Contato(String.valueOf(System.currentTimeMillis()+3), "Contato3", "contato3@teste", "33221103"));
		lista.add(new Contato(String.valueOf(System.currentTimeMillis()+4), "Contato4", "contato4@teste", "33221104"));
		lista.add(new Contato(String.valueOf(System.currentTimeMillis()+5), "Contato5", "contato5@teste", "33221105"));
	}
	
	public void salvar(Contato contato){
		if(contato == null){
			return;
		}
		if(contato.getId() == null){
			contato.setId(String.valueOf(System.currentTimeMillis()));
		}
		int index = lista.indexOf(contato);
		if(index > -1){
			lista.set(index, contato);
		}else{
			lista.add(contato);
		}
	}
	
	public void remover(Contato contato){
		lista.remove(contato);
	}
	
	public List<Contato> buscarTodos(){
		return lista;
	}
	
	public Contato buscarPorId(String id){
		if(id == null){
			return null;
		}
		for (Contato contato : lista) {
			if(id.equals(contato.getId())){
				return contato;
			}
			
		}
		return null;
	}


}
