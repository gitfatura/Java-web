package br.com.clafify.java.negocio;

import java.util.HashMap;
import java.util.Map;

public abstract class Validador<T> {

	private Map<String, String> erros = new HashMap<String, String>();

	public abstract boolean isValido(T resource);

	
	public void addErro(String key,String value){
		erros.put(key, value);
	}
	
	public Map<String, String> getErros() {
		return erros;
	}

}
