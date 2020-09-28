package br.ufc.quixada.es.vv.estoque.controle;

import br.ufc.quixada.es.vv.estoque.dao.DepartamentoDAO;

import br.ufc.quixada.es.vv.estoque.entidade.Departamento;

import java.util.ArrayList;

import br.ufc.quixada.es.vv.estoque.controle.ControladorProdutos;

import br.ufc.quixada.es.vv.estoque.util.Regex;

public class ControladorDepartamento {
	
	private Regex validar = new Regex();
	private static ControladorDepartamento controladorDepartamento;
	private DepartamentoDAO chamarDepartamentoDAO = new DepartamentoDAO();
	private ControladorProdutos chamarControladorProduto = ControladorProdutos.getInstace();
	
	public static ControladorDepartamento getInstace() {
		if(controladorDepartamento == null)
			controladorDepartamento = new ControladorDepartamento();

		return controladorDepartamento;
	}
	
	public boolean temItem(int idDepartamento) {
		if(!validar.NumeroValido(idDepartamento)) {
			System.out.println("Valor atribu�do ao id do departamento � inv�lido");
			return false;
		}
		try {
			if(chamarDepartamentoDAO.temDepartamento(idDepartamento)) {
				return true;
			}
		}catch(Exception e) {
			System.out.println("N�o foi poss�vel verificar se tem departamento");
		}
		return false;
	}
	
	public boolean adicionarDepartamento(String nome, int secao) throws Exception{
		if(nome == null) {
			System.out.println("Valor nulo inserido. Opera��o inv�lida");
			return false;
		}
		if(!validar.StringValida(nome) || !validar.NumeroValido(secao)) {
			return false;
		}
		try {
			chamarDepartamentoDAO.adicionarDepartamento(nome, secao);
			System.out.println("Departamento novo cadastrado");
			return true;
		}catch(Exception e) {
			System.out.println("Erro no cadastro de produto: " + e.getMessage());
		}
		return false;
	}
	public boolean apagarDepartamento(int id) throws Exception{
		if(chamarDepartamentoDAO.isEmpty()){
			System.out.println("Nenhum produto cadastrado");
			return false;
		}
		if(!validar.NumeroValido(id)) {
			System.out.println("Valor inv�lido passado por par�metro");
		}
		try {
			if(temItem(id)) {
				if(!chamarControladorProduto.ExisteProdutoNoDepartamento(id)) {
					if(chamarDepartamentoDAO.apagarDepartamento(id)) {
						System.out.println("O departamento foi removido com sucesso.");
						return true;
					}
				}else {
					System.out.println("O departamento n�o pode ter nenhum produto cadastrado quando for apagado");
				}
			}else {
				System.out.println("Departamento n�o encontrado");
			}
		}catch(Exception e) {
			System.out.println("Erro ao remover um departamento" + e.getLocalizedMessage());
		}
		return false;
	}
	public void ListarDepartamentos() throws Exception{
		if(chamarDepartamentoDAO.isEmpty()){
			System.out.println("Nenhum departamento cadastrado");
			return;
		}
		try {
			ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
			departamentos = chamarDepartamentoDAO.Listar();
			if(departamentos == null) {
				System.out.println("Nenhum produto cadastrado");
				return;
			}
			for(int i = 0; i < departamentos.size(); i++) {
				System.out.println(departamentos.get(i).toString());
			}
		} catch(Exception e) {
			System.out.println("Erro ao listar os departamentos existentes: " + e.getMessage());
		}
	}
	public boolean atualizarNomeDepartamento(String novoNome, int id) {
		if(novoNome == null) {
			System.out.println("Valor nulo inserido. Opera��o inv�lida");
			return false;
		}
		if(!validar.StringValida(novoNome) || !validar.NumeroValido(id)) {
			System.out.println("Atualiza��o do nome do departamento com par�metro inv�lido.");
			return false;
		}
		try {
			if(temItem(id)) {
				if(chamarDepartamentoDAO.AtualizarNomeDepartamento(novoNome, id)) {
					System.out.println("Nome do departamento atualizado com sucesso.");
					return true;
				}
			}
		}catch(Exception e) {
			System.out.println("Erro na atualiza��o do nome de um departamento" + e.getLocalizedMessage());
		}
		System.out.println("Departamento n�o encontrado");
		return false;
	}
	public boolean atualizarSecaoDepartamento(int secao, int id) {
		if(!validar.NumeroValido(secao) || !validar.NumeroValido(id)) {
			System.out.println("Atualiza��o da se��o do departamento com par�metro inv�lido.");
			return false;
		}
		try {
			if(temItem(id)) {
				if(chamarDepartamentoDAO.AtualizarSecaoDepartamento(secao, id)) {
					System.out.println("Se��o do departamento atualizado com sucesso.");
					return true;
				}
			else {
				System.out.println("Falha ao procurar departamento.");
			}
				return false;
			}
		}catch(Exception e) {
			System.out.println("Erro na atualiza��o da se��o de um departamento" + e.getLocalizedMessage());
		}
		System.out.println("Departamento n�o encontrado");
		return false;
	}
}
