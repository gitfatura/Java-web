package br.com.negocio;

import br.com.model.Contato;

public class ContatoValidador extends Validador<Contato>{

	@Override
	public boolean isValido(Contato contato) {
		 
		if (contato == null) {
			addErros("contato_erro", "contato n�o informado");
		}else{
			if (!isValido(contato.getNome())) {
				addErros("nome_erro", "Nome n�o informador");
			}if (!isValido(contato.getEmail())) {
				addErros("email_erro", "Email n�o informador");
			}if (!isValido(contato.getTelefone())) {
				addErros("telefone_erro", "Telefone n�o informador");
			}
			
		}
		return getErros().isEmpty();
	}
	
	
	
	private boolean isValido(String valor){
		return valor !=null && !"".equals(valor.trim());
	}
	

}
