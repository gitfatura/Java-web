package br.com.negocio;

import java.util.HashMap;
import java.util.Map;


public abstract class Validador<T> {

	 private Map<String, String> erros = new HashMap<String, String>();
	 
	 public abstract boolean isValido(T resource);
	 
	 public void addErros(String key, String value){
		 erros.put(key, value);
	 }
	 
	 public Map<String, String> getErros(){
		 return erros;

	 }
	 
	
}
