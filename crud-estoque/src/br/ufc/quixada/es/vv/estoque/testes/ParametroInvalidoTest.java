package br.ufc.quixada.es.vv.estoque.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.ufc.quixada.es.vv.estoque.controle.ControladorDepartamento;
import br.ufc.quixada.es.vv.estoque.controle.ControladorProdutos;

class ParametroInvalidoTest {
	
	@Test
	public void testApagarProdutoComCodigoErrado() throws Exception{
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		testProdutos.adicionarProduto("Arroz", 2.45, "FDWESSRS", 30, 1);
		boolean apagarProduto = testProdutos.apagarProduto("FDWES");
		assertTrue(apagarProduto);
	}
	
	@Test
	public void testAtualizarNomeProdutoComCodigoErrado() throws Exception{
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		testProdutos.adicionarProduto("Arroz", 2.45, "FDWESSRS", 30, 3);
		boolean atualizarProduto = testProdutos.atualizarNomeProduto("Feijao", "FDWES");
		assertFalse(atualizarProduto);
	}
	
	@Test
	public void testAtualizarPrecoComCodigoErrado() throws Exception{
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		testProdutos.adicionarProduto("Arroz", 2.45, "FDWESSRS", 30, 3);
		boolean atualizarProduto = testProdutos.atualizarPreco(5.00, "FDWES");
		assertFalse(atualizarProduto);
	}
	
	@Test
	public void testAtualizarCodigoProdutoComCodigoErrado() throws Exception{
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		testProdutos.adicionarProduto("Arroz", 2.45, "FDWESSRS", 30, 3);
		boolean atualizarProduto = testProdutos.atualizarCodigoProduto("FDWES", "FDFVR");
		assertFalse(atualizarProduto);
	}
	
	@Test
	public void testAtualizarQuantidadeComCodigoErrado() throws Exception{
		ControladorProdutos testProdutos = ControladorProdutos.getInstace();
		testProdutos.adicionarProduto("Arroz", 2.45, "FDWESSRS", 30, 3);
		boolean atualizarProduto = testProdutos.atualizarQuantidade("FDWES", 10);
		assertFalse(atualizarProduto);
	}
	
	@Test
	public void testApagarDepartamentoComCodigoErrado() throws Exception{
		ControladorDepartamento testDepartamentos = ControladorDepartamento.getInstace();
		testDepartamentos.adicionarDepartamento("Frios", 2);
		boolean apagarDepartamento = testDepartamentos.apagarDepartamento(8);
		assertFalse(apagarDepartamento);
	}
	
	@Test
	public void testAtualizarNomeDepartamentoComCodigoErrado() throws Exception{
		ControladorDepartamento testDepartamentos = ControladorDepartamento.getInstace();
		testDepartamentos.adicionarDepartamento("Frios", 2);
		boolean atualizarNomeDepartamento = testDepartamentos.atualizarNomeDepartamento("Cereais", 8);
		assertFalse(atualizarNomeDepartamento);
	}
	
	public void testAtualizarSecaoDepartamentoComCodigoErrado() throws Exception{
		ControladorDepartamento testDepartamentos = ControladorDepartamento.getInstace();
		testDepartamentos.adicionarDepartamento("Frios", 2);
		boolean atualizarSecao = testDepartamentos.atualizarSecaoDepartamento(3, 8);
		assertFalse(atualizarSecao);
	}

}
