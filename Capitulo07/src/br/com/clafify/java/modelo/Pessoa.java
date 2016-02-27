package br.com.clafify.java.modelo;

public class Pessoa {
	
	private String nome;
	private int idade;
	private Cachorro dog;
	public Pessoa() {
		super();
	}
	public Pessoa(String nome, int idade ,Cachorro dog) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.setDog(dog);
	}
	public String getNome() {
		System.out.println("==>Chamando o método getNome");
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Cachorro getDog() {
		return dog;
	}
	public void setDog(Cachorro dog) {
		this.dog = dog;
	}
	
	

}
