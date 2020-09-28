package br.ufc.quixada.es.vv.estoque.entidade;

public class Produto {
	private String nome;
	private double preco;
	private String codigoProduto;
	private int quantidade;
	private int idDepartamento;
	
	public Produto(String nome, double preco, String codigoProduto, int quantidade, int idDepartamento){
		this.nome = nome;
		this.preco = preco;
		this.codigoProduto = codigoProduto;
		this.quantidade = quantidade;
		this.idDepartamento = idDepartamento;
	}
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return this.preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getCodigoProduto() {
		return this.codigoProduto;
	}
	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public int getQuantidade() {
		return this.quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	
	public String toString() {
		String msg = "----------------------------------------------------\n" 
				+ "\nNome do Produto: " + this.nome
				+ "\nPreço do Produto: R$ " + this.preco
				+ "\nCódigo do Produto: " + this.codigoProduto
				+"\nQuantidade: " + this.quantidade
				+ "\nDepartamento: " + this.idDepartamento;
		
		return msg;
	}
}