package model;

public class Produto {
	
	    public int idProd;
	    public String nome;
	    public double preco;
	    
	    public Produto() {
			super();
	   			
}

public Produto(int idProd, String nome, double preco) {
	super();
	this.idProd = idProd;
	this.nome = nome;
	this.preco = preco;
	
}

public int getIdProd() {
	return idProd;
}

public void setIdProd(int idProd) {
	this.idProd = idProd;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public double getPreco() {
	return preco;
}

public void setPreco(double preco) {
	this.preco = preco;
}}

