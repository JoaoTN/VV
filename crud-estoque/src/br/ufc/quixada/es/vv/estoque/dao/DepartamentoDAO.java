package br.ufc.quixada.es.vv.estoque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufc.quixada.es.vv.estoque.dao.ProdutoDAO;

import br.ufc.quixada.es.vv.estoque.entidade.Departamento;
import br.ufc.quixada.es.vv.estoque.entidade.Produto;

public class DepartamentoDAO {
	private ProdutoDAO chamarProdutoDAO = new ProdutoDAO();
	private FabricaConexao conexao;
	private Connection con;
	
	public DepartamentoDAO(){
		this.conexao = new FabricaConexao();
	}
	
	public DepartamentoDAO(FabricaConexao conexao) throws Exception{
		this.conexao = conexao;
		this.con = conexao.getConexao();
	}

	public boolean temDepartamento(int idDepartamento) throws Exception {
		try {
			if(this.con == null) con = conexao.getConexao();
			String  query = "SELECT * FROM departamentos WHERE idDepartamento = ?";
			PreparedStatement stm = this.con.prepareStatement(query);
			stm.setInt(1, idDepartamento);
			ResultSet rs = stm.executeQuery();
			con.close();
			if(rs != null) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException e) {
			System.out.println("Erro ao se comunicar com o banco de dados" + e.getLocalizedMessage());
		}
		return false;
	}

	public boolean adicionarDepartamento(String nome, int secao) throws Exception{
		try {
			if(this.con == null) con = conexao.getConexao();
			String query = "INSERT INTO departamentos(nome, secao) VALUES (?,?)";
			PreparedStatement stm = this.con.prepareStatement(query);
			stm.setString(1, nome);
			stm.setInt(2, secao);
			stm.executeUpdate();
			con.close();
			return true;
		}catch(Exception e) {
			System.out.println("Erro ao se comunicar com o banco de dados" + e.getLocalizedMessage());
		}
		return false;
		
	}

	public boolean isEmpty() throws Exception{
		try {
			if(this.con == null) con = conexao.getConexao();
			String  query = "SELECT * FROM departamentos";
			PreparedStatement stm = this.con.prepareStatement(query);
			ResultSet rs = stm.executeQuery();
			con.close();
			if(rs != null) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException e) {
			System.out.println("Erro ao se comunicar com o banco de dados" + e.getLocalizedMessage());
		}
		return false;
	}

	public boolean apagarDepartamento(int id) throws Exception{
		try {
			if(this.con == null) con = conexao.getConexao();
			String query = "DELETE FROM departamentos WHERE idDepartamento = ?";
			PreparedStatement stm = this.con.prepareStatement(query);
			stm.setInt(1, id);
			stm.executeUpdate();
			con.close();
			return true;
		}catch(SQLException e) {
			System.out.println("Erro ao se comunicar com o banco de dados" + e.getLocalizedMessage());
		}
		return false;
	}

	public ArrayList<Departamento> Listar() throws Exception{
		try {
			if(this.con == null) con = conexao.getConexao();
			String query = "SELECT * FROM departamentos";
			PreparedStatement stm = this.con.prepareStatement(query);
			ResultSet rs = stm.executeQuery();
			ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
			int idDepartamento;
			ArrayList<Produto> produtoTemp;
			if(rs != null) {
				while(rs.next()) {
					idDepartamento = rs.getInt("idDepartamento");
					produtoTemp = chamarProdutoDAO.ListarSelecionar(idDepartamento);
					departamentos.add(new Departamento(
							rs.getInt("idDepartamento"), rs.getString("nome"), rs.getInt("secao"), produtoTemp));
				}
				rs.close();
			}
			con.close();
			return departamentos;
		}catch(SQLException e) {
			System.out.println("Erro ao se comunica com o banco de dados" + e.getLocalizedMessage());
			return null;
		}
		
	}

	public boolean AtualizarNomeDepartamento(String novoNome, int id) throws Exception{
		try {
			if(this.con == null) con = conexao.getConexao();
			String query = "UPDATE departamentos SET nome = ? WHERE idDepartamento = ?";
			PreparedStatement stm = this.con.prepareStatement(query);
			stm.setString(1, novoNome);
			stm.setInt(2, id);
			stm.executeUpdate();
			con.close();
			return true;
		}catch(SQLException e) {
			System.out.println("Erro ao se comunicar com o banco de dados" + e.getLocalizedMessage());
		}
		return false;
	}

	public boolean AtualizarSecaoDepartamento(int secao, int id) throws Exception{
		try {
			if(this.con == null) con = conexao.getConexao();
			String query = "UPDATE departamentos SET secao = ? WHERE idDepartamento = ?";
			PreparedStatement stm = this.con.prepareStatement(query);
			stm.setInt(1, secao);
			stm.setInt(2, id);
			stm.executeUpdate();
			con.close();
			return true;
		}catch(SQLException e) {
			System.out.println("Erro ao se comunicar com o banco de dados" + e.getLocalizedMessage());
		}
		return false;
	}

}
