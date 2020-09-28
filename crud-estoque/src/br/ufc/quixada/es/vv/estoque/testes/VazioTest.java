package br.ufc.quixada.es.vv.estoque.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.ufc.quixada.es.vv.estoque.controle.ControladorProdutos;
import br.ufc.quixada.es.vv.estoque.controle.ControladorDepartamento;

class VazioTest {

	@Test
	public void testAdicionarComVazio() throws Exception {
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		boolean novoProduto = testProdutos.adicionarProduto("", 2.45, "FDWESSRS", 30, 3);
		assertFalse(novoProduto);
	}
	
	@Test
	public void testApagarProdutoComVazio() throws Exception{
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		testProdutos.adicionarProduto("Arroz", 2.45, "FDWESSRS", 30, 3);
		boolean apagarProduto = testProdutos.apagarProduto("");
		assertFalse(apagarProduto);
	}
	
	@Test
	public void testAtualizarNomeProdutoComVazio() throws Exception{
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		testProdutos.adicionarProduto("Arroz", 2.45, "FDWESSRS", 30, 3);
		boolean atualizarProduto = testProdutos.atualizarNomeProduto("", "");
		assertFalse(atualizarProduto);
	}
	
	@Test
	public void testAtualizarPrecoComVazio() throws Exception{
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		testProdutos.adicionarProduto("Arroz", 2.45, "FDWESSRS", 30, 3);
		boolean atualizarProduto = testProdutos.atualizarPreco(5.00, "");
		assertFalse(atualizarProduto);
	}
	
	@Test
	public void testAtualizarCodigoProdutoComVazio() throws Exception{
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		testProdutos.adicionarProduto("Arroz", 2.45, "FDWESSRS", 30, 3);
		boolean atualizarProduto = testProdutos.atualizarCodigoProduto("FDWESSRS", "");
		assertFalse(atualizarProduto);
	}
	
	@Test
	public void testAtualizarQuantidadeComVazio() throws Exception{
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		testProdutos.adicionarProduto("Arroz", 2.45, "FDWESSRS", 30, 3);
		boolean atualizarProduto = testProdutos.atualizarQuantidade("", 10);
		assertFalse(atualizarProduto);
	}
	
	@Test
	public void testAdicionarDepartamentoComVazio() throws Exception {
		ControladorDepartamento testDepartamentos = ControladorDepartamento.getInstace();
		boolean novoDepartamento = testDepartamentos.adicionarDepartamento("Frios", 2);
		assertFalse(novoDepartamento);
	}
	
	@Test
	public void testAtualizarDepartamentoNomeComVazio() throws Exception{
		ControladorDepartamento testDepartamentos = ControladorDepartamento.getInstace();
		testDepartamentos.adicionarDepartamento("Frios", 2);
		boolean atualizarNomeDepartamento = testDepartamentos.atualizarNomeDepartamento("", 1);
		assertFalse(atualizarNomeDepartamento);
	}
}
