package br.ufc.quixada.es.vv.estoque.controle;

import br.ufc.quixada.es.vv.estoque.controle.ControladorDepartamento;

import java.util.ArrayList;
import br.ufc.quixada.es.vv.estoque.entidade.Produto;

import br.ufc.quixada.es.vv.estoque.dao.ProdutoDAO;

import br.ufc.quixada.es.vv.estoque.util.Regex;

public class ControladorProdutos {
	private Regex validar = new Regex();
	private static ControladorProdutos controladorProdutos;
	private ProdutoDAO chamarProdutoDAO = new ProdutoDAO();
	private ControladorDepartamento chamarControladorDepartamento = new ControladorDepartamento(); 
	
	public static ControladorProdutos getInstace() {
		if(controladorProdutos == null)
			controladorProdutos = new ControladorProdutos();

		return controladorProdutos;
	}
	
	
	public boolean temItem(String codigo){
		if(!validar.StringValida(codigo)) {
			System.out.println("Valor atribu�do ao c�digo do produto � inv�lido");
			return false;
		}
		try {
			if(chamarProdutoDAO.temProduto(codigo)) {
				return true;
			}
		}catch(Exception e) {
			System.out.println("N�o foi poss�vel verificar se tem produto");
		}
		return false;
	}
	
	public boolean adicionarProduto(String nome, double preco, String codigoProduto, int quantidade, int idDepartamento) throws Exception {
		if(nome == null || codigoProduto == null) {
			System.out.println("Valor nulo inserido. Opera��o inv�lida");
			return false;
		}
		if(!validar.StringValida(nome) || !validar.PrecoValido(preco) || !validar.StringValida(codigoProduto) || !validar.NumeroValido(quantidade) || !validar.NumeroValido(idDepartamento)) {
			System.out.println("Valor inv�lido passado por par�metro");
			return false;
		}
		
		try {
			if(temItem(codigoProduto)){
				System.out.println("O mesmo c�digo de produto n�o pode ser cadastrado duas vezes.");
				return false;
			}
			if(chamarProdutoDAO.adicionarProduto( nome, preco, codigoProduto, quantidade, idDepartamento)) {
				System.out.println("Produto novo cadastrado");
				return true;
			}
		}catch(Exception e) {
			System.out.println("Erro no cadastro de produto: " + e.getMessage());
		}
		return false;
	}
	
	
	public boolean apagarProduto(String codigo) throws Exception{
		if(codigo == null) {
			System.out.println("Valor nulo inserido. Opera��o inv�lida");
			return false;
		}
		if(chamarProdutoDAO.isEmpty()){
			System.out.println("Nenhum produto cadastrado");
			return false;
		}
		if(!validar.StringValida(codigo)) {
			System.out.println("Valor inv�lido passado por par�metro");
			return false;
		}
		try {
			if(temItem(codigo))
				if(chamarProdutoDAO.apagarProduto(codigo)) {
					System.out.println("O produto foi removido com sucesso");
					return true;
				}
		}catch(Exception e){
			System.out.println("Erro ao remover um produto" + e.getMessage());
			
		}
		System.out.println("Produto n�o encontrado");
		return false;
	}
	
	public void ListarProdutos() throws Exception{
		if(chamarProdutoDAO.isEmpty()){
			System.out.println("Nenhum produto cadastrado");
			return;
		}
		try {
			ArrayList<Produto> produtos = new ArrayList<Produto>();
			produtos = chamarProdutoDAO.Listar();
			if(produtos == null) {
				System.out.println("Nenhum produto cadastrado");
				return;
			}
			for(int i = 0; i < produtos.size(); i++) {
				System.out.println(produtos.get(i).toString());
			}
		} catch(Exception e) {
			System.out.println("Erro ao listar os produtos existentes: " + e.getMessage());
		}
	}
	public boolean atualizarNomeProduto(String novoNome, String codigo) throws Exception{
		if(novoNome == null || codigo == null) {
			System.out.println("Valor nulo inserido. Opera��o inv�lida");
			return false;
		}
		if(!validar.StringValida(novoNome) || !validar.StringValida(codigo)) {
			System.out.println("Atualiza��o do nome do produto com par�metro inv�lido.");
			return false;
		}
		try {
			if(temItem(codigo)) {
				if(chamarProdutoDAO.AtualizarNomeProduto(codigo, novoNome)) {
					System.out.println("Nome do produto atualizado com sucesso");
					return true;
				}
			}else {
				System.out.println("Falha ao procurar produto.");
			}
		} catch(Exception e) {
			System.out.println("Erro na atualiza��o do nome do produto" + e.getMessage());
		}
		System.out.println("Produto n�o encontrado");
		return false;
	}
	
	public boolean atualizarPreco(double preco, String codigo) {
		if(codigo == null) {
			System.out.println("Valor nulo inserido. Opera��o inv�lida");
			return false;
		}
		if(!validar.PrecoValido(preco) || !validar.StringValida(codigo)) {
			System.out.println("Atualiza��o do pre�o com par�metro inv�lido.");
			return false;
		}
		try {
			if(temItem(codigo)) {
				chamarProdutoDAO.AtualizarPrecoProduto(codigo, preco);
				System.out.println("Pre�o do produto atualizado com sucesso.");
				return true;
			}else {
				System.out.println("Falha ao procurar produto.");
			}
		} catch(Exception e) {
			System.out.println("Erro na atualiza��o do pre�o do produto" + e.getMessage());
		}
		System.out.println("Produto n�o encontrado");
		return false;
	}
	public boolean atualizarCodigoProduto(String codigo, String novoCodigo) {
		if(codigo == null || novoCodigo == null) {
			System.out.println("Valor nulo inserido. Opera��o inv�lida");
			return false;
		}
		if(!validar.StringValida(codigo) || !validar.StringValida(novoCodigo)) {
			System.out.println("Atualiza��o do c�digo do produto com par�metro inv�lido.");
			return false;
		}
		try {
			if(temItem(codigo)) {
				chamarProdutoDAO.AtualizarCodigoProduto(codigo, novoCodigo);
				System.out.println("C�digo do produto atualizado com sucesso.");
				return true;
			}else {
				System.out.println("Falha ao procurar produto.");
			}
		} catch(Exception e){
			System.out.println("Erro na atualiza��o do c�digo do produto" + e.getMessage());
		}
		System.out.println("Produto n�o encontrado");
		return false;
	}
	public boolean atualizarQuantidade(String codigo, int quantidade) {
		if(codigo == null) {
			System.out.println("Valor nulo inserido. Opera��o inv�lida");
			return false;
		}
		if(!validar.StringValida(codigo) || !validar.NumeroValido(quantidade)) {
			System.out.println("Atualiza��o da quantidade em estoque do produto com par�metro inv�lido.");
			return false;
		}
		try {
			if(temItem(codigo)) {
				chamarProdutoDAO.AtualizarQuantidadeProduto(codigo, quantidade);
				System.out.println("Quantidade do produto atualizada com sucesso.");
				return true;
			}else {
				System.out.println("Falha ao procurar produto.");
			}
		} catch(Exception e){
			System.out.println("Erro na atualiza��o da quantidade em estoque do produto" + e.getMessage());
		}
		System.out.println("Produto n�o encontrado");
		return false;
	}
	public boolean atualizarDepartamento(String codigo, int  idDepartamento, int novoIdDepartamento) {
		if(codigo == null) {
			System.out.println("Valor nulo inserido. Opera��o inv�lida");
			return false;
		}
		if(!validar.StringValida(codigo) || !validar.NumeroValido(idDepartamento) || !validar.NumeroValido(novoIdDepartamento)) {
			System.out.println("Atualiza��o do departamento do produto com par�metro inv�lido.");
			return false;
		}
		try {
			if(temItem(codigo)) {
				if(chamarControladorDepartamento.temItem(idDepartamento)) {
					chamarProdutoDAO.AtualizarDepartamento(codigo, idDepartamento);
					System.out.println("Departamento atualizado com sucesso");
					return true;
				}else {
					System.out.println("Falha ao procurar departamento");
				}
			}else {
				System.out.println("Falha ao procurar produto.");
			}
		} catch(Exception e) {
			System.out.println("Erro na atualiza��o do Departamento " + e.getMessage());
		}
		System.out.println("Produto n�o encontrado");
		return false;
	}

	public boolean ExisteProdutoNoDepartamento(int id) {
		if(!validar.NumeroValido(id)) {
			System.out.println("Par�metro inv�lido.");
		}
		try {
			if(chamarProdutoDAO.ExisteDepartamento(id)) {
				return true;
			}else {
				System.out.println("N�o existe produto no Departamento.");
			}
		}catch(Exception e) {
			System.out.println("Erro ao procurar o produto no departamento.");
		}
		return false;
	}
}
