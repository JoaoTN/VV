package br.ufc.quixada.es.vv.estoque.view;

import br.ufc.quixada.es.vv.estoque.controle.ControladorDepartamento;

import java.util.Scanner;
import br.ufc.quixada.es.vv.estoque.util.Regex;

public class FronteiraMenuDepartamento {
	private static Scanner ler;
	
	public void GerenciarDepartamentos() throws Exception{
		ControladorDepartamento chamarDepartamento = ControladorDepartamento.getInstace();
		Regex validar = new Regex();
		ler = new Scanner(System.in);
		int opcao = 0;
		String msg = "----------------------------------------------------\n"
				+ "Digite uma das op��es abaixo que deseja fazer no sistema:\n"
				+ "1 - Cadastrar um novo departamento.\n" 
				+ "2 - Apagar um departamento existente.\n"
				+ "3 - Listar todos os departamentos cadastrados no sistema.\n"
				+ "4 - Atualizar o nome de um departamento existente.\n"
				+ "5 - Atualizar a se��o de um produto existente.\n"
				+ "6 - Voltar para o menu principal";
		do {
			System.out.println(msg);
			String nomeDepartamento;
			int secao = 0, idDepartamento = -1;
			try {
				opcao = Integer.parseInt(ler.next());
			}catch(Exception e) {
				System.out.println("Erro ao receber a op��o desejada." + e.getMessage());
			}
			while(!validar.NumeroValido(opcao)) {
				System.out.println("Valor inv�lido. Por favor, digite um valor v�lido para a op��o: ");
				try {
					opcao = ler.nextInt();
				}catch(Exception e) {
					System.out.println("Erro ao receber a op��o desejada." + e.getMessage());
				}
			}
			switch (opcao) {
				case 1:
					System.out.println("\nDigite o nome do departamento que deseja adicionar: ");
					nomeDepartamento = ler.next();
					while(!validar.StringValida(nomeDepartamento)){
						System.out.println("Valor inv�lido. Por favor, digite um nome v�lido para o novo departamento: ");
						try {
							nomeDepartamento = ler.next();
						}catch(Exception e) {
							System.out.println("Erro na inser��o do nome do departamento" + e.getMessage());
						}
					}
					
					System.out.println("Digite a se��o do novo departamento: ");
					try {
						secao = Integer.parseInt(ler.next());
					}catch(Exception e) {
						System.out.println("Erro na inser��o de se��o" + e.getMessage());
					}
					while(!validar.NumeroValido(secao)){
						System.out.println("Valor inv�lido. Por favor, digite uma se��o v�lida para o novo departamento: ");
						try {
							secao = Integer.parseInt(ler.next());
						}catch(Exception e) {
							System.out.println("Erro na inser��o de se��o" + e.getMessage());
						}
					}
					try {
						if(chamarDepartamento.adicionarDepartamento(nomeDepartamento, secao)) {
							System.out.println("Departamento cadastrado com sucesso.");
						}else {
							System.out.println("Opera��o n�o realizada");
						}
					}catch(Exception e) {
						System.out.println("Erro ao se comunicar com o controlador de Departamentos" + e.getMessage());
					}
					break;
				case 2:
					try {
						chamarDepartamento.ListarDepartamentos();
					}catch(Exception e) {
						System.out.println("Erro ao se comunicar com o controlador de departamentos" + e.getMessage());
					}
					
					System.out.println("Digite o id do departamento que deseja apagar: ");
					idDepartamento = Integer.parseInt(ler.next());
					while(!validar.NumeroValido(idDepartamento)) {
						System.out.println("Por favor, digite um id v�lido para departamento: ");
						idDepartamento = Integer.parseInt(ler.next());
					}
					try {
						if(chamarDepartamento.apagarDepartamento(idDepartamento)) {
							System.out.println("Departamento apagado com sucesso!");
						}else {
							System.out.println("Opera��o n�o realizada.");
						}
					}catch(Exception e){
						System.out.println("Opera��o n�o realizada.");
					}
					break;
				case 3:
					try {
						chamarDepartamento.ListarDepartamentos();
					}catch(Exception e) {
						System.out.println("Erro ao se comunicar com o controlador de Produtos" + e.getMessage());
					}
					break;
				case 4:
					try {
						chamarDepartamento.ListarDepartamentos();
					}catch(Exception e) {
						System.out.println("Erro ao se comunicar com o controlador de departamentos" + e.getMessage());
					}
					
					System.out.println("Digite o id do departamento que deseja alterar o nome: ");
					idDepartamento = Integer.parseInt(ler.next());
					while(!validar.NumeroValido(idDepartamento)) {
						System.out.println("Valor inv�lido. Por favor, digite o id do departamento: ");
						idDepartamento = Integer.parseInt(ler.next());
					}
					System.out.println("Digite o novo nome do departamento selecionado: ");
					nomeDepartamento = ler.next();
					while(!validar.StringValida(nomeDepartamento)){
						System.out.println("Valor inv�lido. Por favor, digite um nome v�lido para o departamento: ");
						nomeDepartamento = ler.next();
					}
					try {
						if(chamarDepartamento.atualizarNomeDepartamento(nomeDepartamento, idDepartamento)) {
							System.out.println("Nome do departamento atualizado com sucesso!");
						}else {
							System.out.println("Opera��o n�o realizada.");
						}
					}catch(Exception e) {
						System.out.println("Erro ao se comunicar com o controlador de Departamentos" + e.getMessage());
					}
					
					break;
				case 5:
					try {
						chamarDepartamento.ListarDepartamentos();
					}catch(Exception e) {
						System.out.println("Erro ao se comunicar com o controlador de departamentos" + e.getMessage());
					}
					
					System.out.println("Digite o id do departamento que deseja alterar o nome: ");
					idDepartamento = Integer.parseInt(ler.next());
					while(!validar.NumeroValido(idDepartamento)) {
						System.out.println("Valor inv�lido. Por favor, digite o id do departamento: ");
						idDepartamento = Integer.parseInt(ler.next());
					}
					System.out.println("Digite a nova se��o do departamento selecionado: ");
					secao = Integer.parseInt(ler.next());
					while(!validar.NumeroValido(secao)){
						System.out.println("Valor inv�lido. Por favor, digite um n�mero v�lido para a se��o do departamento selecionado: ");
						secao = Integer.parseInt(ler.next());
					}
					try {
						if(chamarDepartamento.atualizarSecaoDepartamento(secao, idDepartamento)) {
							System.out.println("Secao do departamento atualizado com sucesso!");
						}else {
							System.out.println("Opera��o n�o realizada.");
						}
					}catch(Exception e) {
						System.out.println("Erro ao se comunicar com o controlador de Departamentos" + e.getMessage());
					}
					break;
				case 6:
					opcao = 6;
					break;
			}
		}while(opcao != 6);
	}
}
