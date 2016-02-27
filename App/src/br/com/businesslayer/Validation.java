package br.com.businesslayer;

import java.util.HashMap;
import java.util.Map;

public class Validation {

	private Map<String, String> erros = new HashMap<String, String>();
	
	public void addErros(String key, String value){
		erros.put(key, value);
	}
	
	public Map<String, String> getErros(){
		return erros;
	}
	
	
}
