package br.ufc.quixada.es.vv.estoque.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.ufc.quixada.es.vv.estoque.controle.ControladorProdutos;
import br.ufc.quixada.es.vv.estoque.controle.ControladorDepartamento;

class CasoIdealTest {
	
	//Testes caso ideal;

	@Test
	public void testAdicionarProduto() throws Exception {
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		boolean novoProduto = testProdutos.adicionarProduto("Arroz", 2.45, "FDWESSRS", 30, 1);
		assertTrue(novoProduto);
	}
	
	@Test
	public void testApagarProduto() throws Exception{
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		testProdutos.adicionarProduto("Arroz", 2.45, "FDWESSRS", 30, 1);
		boolean apagarProduto = testProdutos.apagarProduto("FDWESSRS");
		assertTrue(apagarProduto);
	}
	
	@Test
	public void testAtualizarNomeProduto() throws Exception{
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		testProdutos.adicionarProduto("Arroz", 2.45, "FDWESSRS", 30, 1);
		boolean atualizarProduto = testProdutos.atualizarNomeProduto("Feijao", "FDWESSRS");
		assertTrue(atualizarProduto);
	}
	@Test
	public void testAtualizarPreco() throws Exception{
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		testProdutos.adicionarProduto("Arroz", 2.45, "FDWESSRS", 30, 1);
		boolean atualizarProduto = testProdutos.atualizarPreco(5.00, "FDWESSRS");
		assertTrue(atualizarProduto);
	}
	@Test
	public void testAtualizarCodigoProduto() throws Exception{
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		testProdutos.adicionarProduto("Arroz", 2.45, "FDWESSRS", 30, 1);
		boolean atualizarProduto = testProdutos.atualizarCodigoProduto("FDWESSRS", "PDFSCCE");
		assertTrue(atualizarProduto);
	}
	@Test
	public void testAtualizarQuantidade() throws Exception{
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		testProdutos.adicionarProduto("Arroz", 2.45, "FDWESSRS", 30, 1);
		boolean atualizarProduto = testProdutos.atualizarQuantidade("FDWESSRS", 10);
		assertTrue(atualizarProduto);
	}
	@Test
	public void testAtualizarDepartamento() throws Exception{
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		testProdutos.adicionarProduto("Arroz", 2.45, "FDWESSRS", 30, 1);
		boolean atualizarProduto = testProdutos.atualizarDepartamento("FDWESSRS", 1, 2);
		assertTrue(atualizarProduto);
	}
	@Test
	public void testAdicionarDepartamento() throws Exception{
		ControladorDepartamento testDepartamentos = ControladorDepartamento.getInstace();
		boolean novoDepartamento = testDepartamentos.adicionarDepartamento("Frios", 2);
		assertTrue(novoDepartamento);
	}
	@Test
	public void testApagarDepartamento() throws Exception{
		ControladorDepartamento testDepartamentos = ControladorDepartamento.getInstace();
		testDepartamentos.adicionarDepartamento("Frios", 2);
		boolean apagarDepartamento = testDepartamentos.apagarDepartamento(1);
		assertTrue(apagarDepartamento);
	}
	@Test
	public void testAtualizarNomeDepartamento() throws Exception{
		ControladorDepartamento testDepartamentos = ControladorDepartamento.getInstace();
		testDepartamentos.adicionarDepartamento("Frios", 2);
		boolean atualizarNomeDepartamento = testDepartamentos.atualizarNomeDepartamento("Calçados", 1);
		assertTrue(atualizarNomeDepartamento);
	}
	@Test
	public void testAtualizarSecaoDepartamento() throws Exception{
		ControladorDepartamento testDepartamentos = ControladorDepartamento.getInstace();
		testDepartamentos.adicionarDepartamento("Frios", 2);
		boolean atualizarSecaoDepartamento = testDepartamentos.atualizarSecaoDepartamento(3, 1);
		assertTrue(atualizarSecaoDepartamento);
	}
}