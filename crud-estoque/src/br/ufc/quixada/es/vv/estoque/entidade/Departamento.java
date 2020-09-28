package br.ufc.quixada.es.vv.estoque.entidade;

import java.util.ArrayList;

import br.ufc.quixada.es.vv.estoque.entidade.Produto;

public class Departamento {
	
	private Integer id;
	private String nome;
	private int secao;
	private ArrayList<Produto> produtos;
	
	public Departamento(Integer id, String nome, int secao, ArrayList<Produto> Produtos) {
		this.id = id;
		this.nome = nome;
		this.secao = secao;
		this.produtos = Produtos;
	}
	
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSecao() {
		return this.secao;
	}

	public void setSecao(int secao) {
		this.secao = secao;
	}
	
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	public boolean adicionarProduto(Produto novoProduto) {
		if(this.produtos.add(novoProduto)) 
			return true;
		return false;
	}
	public boolean removerProduto(int i) {
		if(this.produtos.size() >= i) {
			this.produtos.remove(i);
			return true;
		}
		return false;
	}
	
	public String toString() {
		String msg = "\nNome do departamento: " + this.nome
					+ "\nId departamento: " + this.id
					+ "\nNúmero da Seção: " + this.secao;
		msg = "\nProdutos no departamento:\n";
		if(produtos.size() !=0) {
			for(int i = 0; i<produtos.size(); i++) {
				msg = produtos.get(i).getNome() + "\n";
			}
		}else msg = "nenhum \n";
		return msg;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
