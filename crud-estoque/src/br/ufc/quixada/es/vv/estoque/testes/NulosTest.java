package br.ufc.quixada.es.vv.estoque.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.ufc.quixada.es.vv.estoque.controle.ControladorProdutos;
import br.ufc.quixada.es.vv.estoque.controle.ControladorDepartamento;

class NulosTest {

	@Test
	public void testAdicionarComNull() throws Exception {
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		boolean novoProduto = testProdutos.adicionarProduto(null, 2.45, "FDWESSRS", 30, 3);
		assertFalse(novoProduto);
	}
	@Test
	public void testApagarProdutoComNull() throws Exception{
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		testProdutos.adicionarProduto("Arroz", 2.45, "FDWESSRS", 30, 3);
		boolean apagarProduto = testProdutos.apagarProduto(null);
		assertFalse(apagarProduto);
	}
	
	@Test
	public void testAtualizarNomeProdutoComNull() throws Exception{
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		testProdutos.adicionarProduto("Arroz", 2.45, "FDWESSRS", 30, 3);
		boolean atualizarProduto = testProdutos.atualizarNomeProduto(null, "FDWESSRS");
		assertFalse(atualizarProduto);
	}
	
	@Test
	public void testAtualizarPrecoComNull() throws Exception{
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		testProdutos.adicionarProduto("Arroz", 2.45, "FDWESSRS", 30, 3);
		boolean atualizarProduto = testProdutos.atualizarPreco(5.00, null);
		assertFalse(atualizarProduto);
	}
	
	@Test
	public void testAtualizarCodigoProdutoComNull() throws Exception{
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		testProdutos.adicionarProduto("Arroz", 2.45, "FDWESSRS", 30, 3);
		boolean atualizarProduto = testProdutos.atualizarCodigoProduto("FDWESSRS", null);
		assertFalse(atualizarProduto);
	}
	
	@Test
	public void testAtualizarQuantidadeComNull() throws Exception{
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		testProdutos.adicionarProduto("Arroz", 2.45, "FDWESSRS", 30, 3);
		boolean atualizarProduto = testProdutos.atualizarQuantidade(null, 10);
		assertFalse(atualizarProduto);
	}
	
	@Test
	public void testAdicionarDepartamentoComNull() throws Exception {
		ControladorDepartamento testDepartamentos = ControladorDepartamento.getInstace();
		boolean novoDepartamento = testDepartamentos.adicionarDepartamento(null, 2);
		assertFalse(novoDepartamento);
	}
	
	@Test
	public void testAtualizarNomeDepartamentoNomeComNull() throws Exception{
		ControladorDepartamento testDepartamentos = ControladorDepartamento.getInstace();
		testDepartamentos.adicionarDepartamento("Frios", 2);
		boolean atualizarDepartamento = testDepartamentos.atualizarNomeDepartamento(null, 1);
		assertFalse(atualizarDepartamento);
	}
	
	

}
