package br.ufc.quixada.es.vv.estoque.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
	private String usuario;
	private String senha;
	private String url;
	
	public FabricaConexao() {
		usuario = "postgres";
		senha = "root123";
		url = "jdbc:postgresql://localhost:5432/mercadinho";
	}
	public Connection getConexao() throws Exception {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			return conexao;
		}catch(ClassNotFoundException e) {
			System.out.println("Erro no driver de conexão");
			return null;
		}catch(SQLException e){
			System.out.println("Erro na conexão");
			return null;
		}
	}
}
