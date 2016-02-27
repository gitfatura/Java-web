package br.com.businesslayer;

public class Produto {
 
	private String id;
	private String desc;
	private String quant;
	private double valor;

	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public Produto(String id, String desc, String quant, Double valor) {
		super();
		this.id = id;
		this.desc = desc;
		this.quant = quant;
		this.valor = valor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getQuant() {
		return quant;
	}

	public void setQuant(String quant) {
		this.quant = quant;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	 
	
	
	
}
