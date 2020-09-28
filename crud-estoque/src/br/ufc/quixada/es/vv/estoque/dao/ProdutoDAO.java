package br.ufc.quixada.es.vv.estoque.dao;


import java.util.ArrayList;

import br.ufc.quixada.es.vv.estoque.entidade.Produto;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProdutoDAO {
	private FabricaConexao conexao;
	private Connection con;
	
	public ProdutoDAO(){
		this.conexao = new FabricaConexao();
	}
	
	public ProdutoDAO(FabricaConexao conexao) throws Exception{
		this.conexao = conexao;
		this.con = conexao.getConexao();
	}
	public boolean temProduto(String codigo) throws Exception {
		try {
			if(this.con == null) con = conexao.getConexao();
			String  query = "SELECT * FROM produtos WHERE codigoProduto = ?";
			PreparedStatement stm = this.con.prepareStatement(query);
			stm.setString(1, codigo);
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

	public boolean adicionarProduto(String nome, double preco, String codigoProduto, int quantidade, int idDepartamento) throws Exception{
		try {
			if(this.con == null) con = conexao.getConexao();
			String query = "INSERT INTO produtos(codigoProduto, nome, preco, quantidade, idDepartamento) VALUES (?,?,?,?,?)";
			PreparedStatement stm = this.con.prepareStatement(query);
			stm.setString(1, codigoProduto);
			stm.setString(2, nome);
			stm.setDouble(3, preco);
			stm.setInt(4, quantidade);
			stm.setInt(5, idDepartamento);
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
			String  query = "SELECT * FROM produtos";
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

	public boolean apagarProduto(String codigo) throws Exception{
		try {
			if(this.con == null) con = conexao.getConexao();
			String query = "DELETE FROM produtos WHERE codigoProduto = ?";
			PreparedStatement stm = this.con.prepareStatement(query);
			stm.setString(1, codigo);
			stm.executeUpdate();
			con.close();
			return true;
		}catch(SQLException e) {
			System.out.println("Erro ao se comunicar com o banco de dados" + e.getLocalizedMessage());
		}
		return false;
	}

	public ArrayList<Produto> Listar() throws Exception{
		try {
			if(this.con == null) con = conexao.getConexao();
			String query = "SELECT * FROM produtos";
			PreparedStatement stm = this.con.prepareStatement(query);
			ResultSet rs = stm.executeQuery();
			ArrayList<Produto> produtos = new ArrayList<Produto>();
			if(rs != null) {
				while(rs.next()) {
					produtos.add(new Produto(
							rs.getString("nome"), rs.getDouble("preco"), rs.getString("codigoProduto"),
							rs.getInt("quantidade"), rs.getInt("idDepartamento")
							));
				}
				rs.close();
			}
			con.close();
			return produtos;
		}catch(SQLException e) {
			System.out.println("Erro ao se comunica com o banco de dados" + e.getLocalizedMessage());
			return null;
		}
	}

	public boolean AtualizarNomeProduto(String codigo, String novoNome) throws Exception{
		try {
			if(this.con == null) con = conexao.getConexao();
			String query = "UPDATE produto SET nome = ? WHERE codigoProduto = ?";
			PreparedStatement stm = this.con.prepareStatement(query);
			stm.setString(1, novoNome);
			stm.setString(2,codigo);
			stm.executeUpdate();
			con.close();
			return true;
		}catch(SQLException e) {
			System.out.println("Erro ao se comunicar com o banco de dados" + e.getLocalizedMessage());
		}
		return false;
	}

	public boolean AtualizarPrecoProduto(String codigo, double preco) throws Exception{
		try {
			if(this.con == null) con = conexao.getConexao();
			String query = "UPDATE produtos SET preco = ? WHERE codigoProduto = ?";
			PreparedStatement stm = this.con.prepareStatement(query);
			stm.setDouble(1, preco);
			stm.setString(2, codigo);
			stm.executeUpdate();
			con.close();
			return true;
		}catch(SQLException e) {
			System.out.println("Erro ao se comunicar com o banco de dados" + e.getLocalizedMessage());
		}
		return false;
		
	}

	public boolean AtualizarCodigoProduto(String codigo, String novoCodigo) throws Exception{
		try {
			if(this.con == null) con = conexao.getConexao();
			String query = "UPDATE produtos SET codigoProduto = ? WHERE codigoProduto = ?";
			PreparedStatement stm = this.con.prepareStatement(query);
			stm.setString(1, novoCodigo);
			stm.setString(2, codigo);
			stm.executeUpdate();
			con.close();
			return true;
		}catch(SQLException e) {
			System.out.println("Erro ao se comunicar com o banco de dados" + e.getLocalizedMessage());
		}
		return false;
		
	}

	public boolean AtualizarQuantidadeProduto(String codigo, int quantidade) throws Exception{
		try {
			if(this.con == null) con = conexao.getConexao();
			String query = "UPDATE produtos SET quantidade = ? WHERE codigoProduto = ?";
			PreparedStatement stm = this.con.prepareStatement(query);
			stm.setInt(1, quantidade);
			stm.setString(2, codigo);
			stm.executeUpdate();
			con.close();
			return true;
		}catch(SQLException e) {
			System.out.println("Erro ao se comunicar com o banco de dados" + e.getLocalizedMessage());
		}
		return false;
		
	}

	public boolean AtualizarDepartamento(String codigo, int idDepartamento) throws Exception{
		try {
			if(this.con == null) con = conexao.getConexao();
			String query = "UPDATE produtos SET idDepartamento = ? WHERE codigoProduto = ?";
			PreparedStatement stm = this.con.prepareStatement(query);
			stm.setInt(1, idDepartamento);
			stm.setString(2, codigo);
			stm.executeUpdate();
			con.close();
			return true;
		}catch(SQLException e) {
			System.out.println("Erro ao se comunicar com o banco de dados" + e.getLocalizedMessage());
		}
		return false;
		
	}

	public boolean ExisteDepartamento(int id) throws Exception{
		try {
			if(this.con == null) con = conexao.getConexao();
			String  query = "SELECT * FROM produtos WHERE idDepartamento = ?";
			PreparedStatement stm = this.con.prepareStatement(query);
			stm.setInt(1, id);
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
	
	public ArrayList<Produto> ListarSelecionar(int idDepartamento) throws Exception{
		try {
			if(this.con == null) con = conexao.getConexao();
			String query = "SELECT * FROM produtos WHERE idDepartamento = ?";
			PreparedStatement stm = this.con.prepareStatement(query);
			stm.setInt(1, idDepartamento);
			ResultSet rs = stm.executeQuery();
			ArrayList<Produto> produtos = new ArrayList<Produto>();
			if(rs != null) {
				while(rs.next()) {
					produtos.add(new Produto(
							rs.getString("nome"), rs.getDouble("preco"), rs.getString("codigoProduto"),
							rs.getInt("quantidade"), rs.getInt("idDepartamento")
							));
				}
				rs.close();
			}
			con.close();
			return produtos;
		}catch(SQLException e) {
			System.out.println("Erro ao se comunica com o banco de dados" + e.getLocalizedMessage());
			return null;
		}
	}

}
