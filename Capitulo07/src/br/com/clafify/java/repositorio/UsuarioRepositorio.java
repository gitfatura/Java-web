package br.com.clafify.java.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.com.clafify.java.modelo.Contato;
import br.com.clafify.java.modelo.Usuario;

public class UsuarioRepositorio {
	
	private static List<Usuario> lista = new ArrayList<Usuario>();
	
	static{
		lista.add(new Usuario(String.valueOf(System.currentTimeMillis()+1), "Usuario1", "1"));
		lista.add(new Usuario(String.valueOf(System.currentTimeMillis()+2), "Usuario2", "2"));
		lista.add(new Usuario(String.valueOf(System.currentTimeMillis()+3), "Usuario3", "admin"));
	}
	
	public void salvar(Usuario usuario){
		if(usuario == null){
			return;
		}
		if(usuario.getId() == null){
			usuario.setId(String.valueOf(System.currentTimeMillis()));
		}
		int index = lista.indexOf(usuario);
		if(index > -1){
			lista.set(index, usuario);
		}else{
			lista.add(usuario);
		}
	}
	
	public void remover(Usuario usuario){
		lista.remove(usuario);
	}
	
	public List<Usuario> buscarTodos(){
		return lista;
	}
	
	public Usuario buscarPorId(String id){
		if(id == null){
			return null;
		}
		for (Usuario usuario : lista) {
			if(id.equals(usuario.getId())){
				return usuario;
			}
			
		}
		return null;
	}
	
	public Usuario buscarPorNome(String nome){
		if(nome == null){
			return null;
		}
		for (Usuario usuario : lista) {
			if(nome.equals(usuario.getNome())){
				return usuario;
			}
			
		}
		return null;
	}

}
