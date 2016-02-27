package br.com.clafify.java.negocio;

import br.com.clafify.java.modelo.Contato;
/**
 * Classe de validação dos atributos de um contato
 * deve ser utilizada antes de salvar um contato
 * @author Instrutor
 *
 */
public class ContatoValidador extends Validador<Contato> {
	
	public boolean isValido(Contato contato){
		if(contato == null){
			addErro("contato_erro", "Contato não informado");
		}else{
			if(!isValido(contato.getNome())){
				addErro("nome_erro", "Nome não informado");
			}
			if(!isValido(contato.getEmail())){
				addErro("email_erro", "Email não informado");
			}
			if(!isValido(contato.getTelefone())){
				addErro("telefone_erro", "Telefone não informado");
			}
		}
		return getErros().isEmpty();
	}
	
	private boolean isValido(String valor){
		return valor != null && !"".equals(valor.trim());
	}
	
	
	

}
