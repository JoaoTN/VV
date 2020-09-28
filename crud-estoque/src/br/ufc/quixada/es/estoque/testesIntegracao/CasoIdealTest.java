package br.ufc.quixada.es.estoque.testesIntegracao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import br.ufc.quixada.es.vv.estoque.entidade.Produto;
import br.ufc.quixada.es.vv.estoque.entidade.Departamento;

import br.ufc.quixada.es.vv.estoque.controle.ControladorProdutos;
import br.ufc.quixada.es.vv.estoque.dao.DepartamentoDAO;
import br.ufc.quixada.es.vv.estoque.dao.FabricaConexao;
import br.ufc.quixada.es.vv.estoque.dao.ProdutoDAO;

class CasoIdealTest {

	public class CasoIdealTestIntegracao {
		@Mock 
		private FabricaConexao conexao = Mockito.mock(FabricaConexao.class);
		
		@Mock
		private Connection con = Mockito.mock(Connection.class);
		
		@Mock
		private PreparedStatement stm = Mockito.mock(PreparedStatement.class);
		
		@Mock
		private ResultSet rs = Mockito.mock(ResultSet.class);
		
		private ProdutoDAO chamarProdutoDAO = new ProdutoDAO();
		
		private DepartamentoDAO chamarDepartamentoDAO = new DepartamentoDAO();
				
		
		@Before 
		public void setUp() throws Exception{
			MockitoAnnotations.initMocks(this);
			Mockito.when(conexao.getConexao()).thenReturn(con);
			Mockito.when(con.prepareStatement(Mockito.anyString())).thenReturn(stm);
			Mockito.when(stm.executeUpdate()).thenReturn(1);
			Mockito.when(stm.executeQuery()).thenReturn(rs);
		}
		
		@Test
		public void testAdicionarProduto() throws Exception {
			this.setUp();
			ControladorProdutos testProdutos = ControladorProdutos.getInstace();
			boolean novoProduto = testProdutos.adicionarProduto("Arroz", 2.45, "FDWESSRS", 30, 1);
			
			assertTrue(novoProduto);
		}
	}


}
