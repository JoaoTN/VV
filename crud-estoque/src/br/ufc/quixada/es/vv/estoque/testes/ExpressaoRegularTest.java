package br.ufc.quixada.es.vv.estoque.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.ufc.quixada.es.vv.estoque.controle.ControladorDepartamento;
import br.ufc.quixada.es.vv.estoque.controle.ControladorProdutos;

class ExpressaoRegularTest {

	@Test
	public void testAdicionarComEspacos() throws Exception {
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		boolean novoProduto = testProdutos.adicionarProduto("Arroz Solto", 2.45, " FDWESSRS", 30, 3);
		assertFalse(novoProduto);
	}
	@Test
	public void testAdicionarComDoubleErrado() throws Exception {
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		boolean novoProduto = testProdutos.adicionarProduto("Arroz", 2.566, "FDWESSRS", 30, 3);
		assertFalse(novoProduto);
	}
	
	@Test
	public void testApagarProdutoComEspacos() throws Exception{
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		testProdutos.adicionarProduto("Arroz", 2.45, "FDWESSRS", 30, 3);
		boolean apagarProduto = testProdutos.apagarProduto("FDWESSRS ");
		assertFalse(apagarProduto);
	}
	
	@Test
	public void testAtualizarNomeProdutoComEspacos() throws Exception{
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		testProdutos.adicionarProduto("Arroz", 2.45, "FDWESSRS", 30, 3);
		boolean atualizarProduto = testProdutos.atualizarNomeProduto(" ", "FDWESSRS");
		assertFalse(atualizarProduto);
	}
	
	@Test
	public void testAtualizarPrecoComEspacos() throws Exception{
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		testProdutos.adicionarProduto("Arroz", 2.45, "FDWESSRS", 30, 3);
		boolean atualizarProduto = testProdutos.atualizarPreco(5.00, " FDWESSRS");
		assertFalse(atualizarProduto);
	}
	
	@Test
	public void testAtualizarCodigoProdutoComEspacos() throws Exception{
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		testProdutos.adicionarProduto("Arroz", 2.45, "FDWESSRS", 30, 3);
		boolean atualizarProduto = testProdutos.atualizarCodigoProduto(" ", " ");
		assertFalse(atualizarProduto);
	}
	
	@Test
	public void testAtualizarQuantidadeComEspacos() throws Exception{
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		testProdutos.adicionarProduto("Arroz", 2.45, "FDWESSRS", 30, 3);
		boolean atualizarProduto = testProdutos.atualizarQuantidade(" ", 10);
		assertFalse(atualizarProduto);
	}
	
	@Test
	public void testAdicionarDepartamentoComEspacos() throws Exception {
		ControladorDepartamento testDepartamentos = ControladorDepartamento.getInstace();
		boolean novoDepartamento = testDepartamentos.adicionarDepartamento(" Frios", 2);
		assertFalse(novoDepartamento);
	}
	
	@Test
	public void testAtualizarNomeDepartamentoComEspacos() throws Exception{
		ControladorDepartamento testDepartamentos = ControladorDepartamento.getInstace();
		testDepartamentos.adicionarDepartamento("Frios", 2);
		boolean atualizarDepartamento = testDepartamentos.atualizarNomeDepartamento(" ", 1);
		assertFalse(atualizarDepartamento);
	}
}