package br.com.businesslayer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Teste {

	 
	public static void main(String[] args) {
		
		

		LocalDate date = LocalDate.now();		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		String s ="2016/01/30";
		
		s = date.format(formatter);
		
		System.out.println(s);
		 
		 
		
		
//		Produto produto = new Produto();
//		NumberFormat format = NumberFormat.getCurrencyInstance();
//		String id ="1";
//		String desc ="creme";
//		String quant ="555";
//		 
//		 
//		
//		produto.setId(id);
//		produto.setDesc(desc);
//		produto.setQuant(quant);
//		
		 
		
		 
		
//		double dnumero =10;
//		
//		NumberFormat format = NumberFormat.getCurrencyInstance();
//		
//		String formatado = "10,9";
			
	 
		
		
		
		
		
//		Produto produto = new Produto();
//		Validation validation = new Validation();
//		
//		String id ="dsad";
//		String desc ="dsa";
//		String quant ="";
//		
//		if (id.trim().isEmpty()) {
//			validation.addErros("erro_id", "Id invalido");
//		}
//		if (desc.trim().isEmpty()) {
//			validation.addErros("erro_desc", "desc invalido");
//		}
//
//		if (quant.trim().isEmpty()) {
//			validation.addErros("erro_quant", "quant invalido");
//			
//		}if (validation.getErros().isEmpty()) {
//
//			produto.setId(id);
//			produto.setDesc(desc);
//			produto.setQuant(quant);
//		}else{
//			for (Map.Entry<String, String>erro : validation.getErros().entrySet()) {
//				
//				System.out.println("Key :"+erro.getKey());
//				System.out.println("Value :"+erro.getValue());
//				
//			}
//			
//		}
	}

}
