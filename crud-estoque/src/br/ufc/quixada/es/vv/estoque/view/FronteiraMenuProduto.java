package br.ufc.quixada.es.vv.estoque.view;


import br.ufc.quixada.es.vv.estoque.controle.ControladorDepartamento;
import br.ufc.quixada.es.vv.estoque.controle.ControladorProdutos;

import java.util.Scanner;
import br.ufc.quixada.es.vv.estoque.util.Regex;

public class FronteiraMenuProduto {
	private static Scanner ler;
	
	public void GerenciarProdutos() throws Exception {
		ControladorProdutos chamarProduto = ControladorProdutos.getInstace();
		ControladorDepartamento chamarDepartamento = ControladorDepartamento.getInstace();
		Regex validar = new Regex();
		ler = new Scanner(System.in);
		int opcao = 0;
		String msg = "----------------------------------------------------\n"
				+ "Digite uma das opções abaixo que deseja fazer no sistema:\n"
				+ "1 - Cadastrar um novo produto.\n" 
				+ "2 - Apagar um produto existente.\n"
				+ "3 - Listar todos os produtos cadastrados no sistema.\n"
				+ "4 - Atualizar o nome de um produto existente.\n"
				+ "5 - Atualizar o preço de um produto existente.\n"
				+ "6 - Atualizar o código de um produto existente.\n"
				+ "7 - Atualizar a quantidade de um produto existente.\n"
				+ "8 - Atualizar o departamento de um produto existente.\n"
				+ "9 - Voltar para o menu principal";
		do {
			System.out.println(msg);
			String nome = "", codigo = ""; 
			Double preco = 0.00;
			int quantidade = 0, idDepartamento = 0;
			
			opcao = ler.nextInt();
			while(!validar.NumeroValido(opcao)) {
				System.out.println("Valor inválido. Por favor, digite um valor válido para a opção: ");
				opcao = ler.nextInt();
			}
			switch (opcao) {
				case 1:
					nome = ler.next();
					while(!validar.StringValida(nome)){
						System.out.println("Valor inválido. Por favor, digite um nome válido para o novo produto: ");
						nome = ler.next();
					}
					System.out.println("Digite o preço do produto: ");
					try {
						preco = Double.parseDouble(ler.next());
					}catch(Exception e) {
						System.out.println("Erro na inserção do preço" + e.getMessage());
					}
					while(!validar.PrecoValido(preco)){
						System.out.println("Valor inválido. Por favor, digite um preço válido para o novo produto: ");
						try {
							preco = Double.parseDouble(ler.next());
						}catch(Exception e) {
							System.out.println("Erro na inserção do preço" + e.getMessage());
						}
					}
					
					System.out.println("Digite o codigo do produto: ");
					codigo = ler.next();
					while(!validar.StringValida(codigo)) {
						System.out.println("Valor inválido. Por favor, digite um código para o novo produto: ");
						codigo = ler.next();
					}
					
					System.out.println("Digite a quantidade de exemplares do produto: ");
					quantidade = 0;
					try {
						quantidade = Integer.parseInt(ler.next());
					}catch(Exception e) {
						System.out.println("Erro na inserção da quantidade" + e.getMessage());
					}
					while(!validar.NumeroValido(quantidade) || (quantidade < 0)){
						System.out.println("Valor inválido. Por favor, digite uma quantidade válida para o novo produto: ");
						try {
							quantidade = Integer.parseInt(ler.next());
						}catch(Exception e) {
							System.out.println("Erro na inserção da quantidade" + e.getMessage());
						}
					}
					
					try {
						chamarDepartamento.ListarDepartamentos();
					}catch(Exception e) {
						System.out.println("Erro ao se comunicar com o controlador de Departamentos" + e.getMessage());
					}
					
					System.out.println("Digite o id do departamento que deseja colocar o produto: ");
					idDepartamento = Integer.parseInt(ler.next());
					while(!validar.NumeroValido(idDepartamento)) {
						System.out.println("Valor inválido. Por favor, digite o id de um departamento válido: ");
						idDepartamento = Integer.parseInt(ler.next());
					}
					boolean valido = false;
					while(!valido) {
						valido = chamarDepartamento.temItem(idDepartamento);
						System.out.println("Por favor, digite uma id válido para o departamento do produto");
					}
					
					try {
						if(chamarProduto.adicionarProduto(nome, preco, codigo, quantidade, idDepartamento)) {
							System.out.println("Produto cadastrado com sucesso.");
						}else {
							System.out.println("Operação não realizada.");
						}
					}catch(Exception e) {
						System.out.println("Erro ao se comunicar com o controlador de Produtos" + e.getMessage());
					}
					break;
					
				case 2 :
					try {
						chamarProduto.ListarProdutos();
					}catch(Exception e) {
						System.out.println("Erro ao se comunicar com o controlador de Produtos" + e.getMessage());
					}
					
					System.out.println("Digite o código do produto que deseja apagar: ");
					codigo = ler.next();
					while(!validar.StringValida(codigo)) {
						System.out.println("Por favor, digite um código válido produto: ");
						codigo = ler.next();
					}
					try {
						if(chamarProduto.apagarProduto(codigo)) {
							System.out.println("Produto apagado com sucesso!");
						}else {
							System.out.println("Operação não realizada.");
						}
					}catch(Exception e){
						System.out.println("Operação não realizada.");
					}
					break;
				case 3 :
					try {
						chamarProduto.ListarProdutos();
					}catch(Exception e) {
						System.out.println("Erro ao se comunicar com o controlador de Produtos" + e.getMessage());
					}
					break;
					
				case 4 :
					try {
						chamarProduto.ListarProdutos();
					}catch(Exception e) {
						System.out.println("Erro ao se comunicar com o controlador de Produtos" + e.getMessage());
					}
					
					System.out.println("Digite o código do produto que deseja alterar o nome: ");
					codigo = ler.next();
					while(!validar.StringValida(codigo)) {
						System.out.println("Valor inválido. Por favor, digite o código do produto: ");
						codigo = ler.next();
					}
					System.out.println("Digite o novo nome do produto selecionado: ");
					nome = ler.next();
					while(!validar.StringValida(nome)){
						System.out.println("Valor inválido. Por favor, digite um nome válido para o produto: ");
						nome = ler.next();
					}
					try {
						if(chamarProduto.atualizarNomeProduto(nome, codigo)) {
							System.out.println("Nome do produto atualizado com sucesso!");
						}else {
							System.out.println("Operação não realizada.");
						}
					}catch(Exception e) {
						System.out.println("Erro ao se comunicar com o controlador de Produtos" + e.getMessage());
					}
					
					break;
				case 5 :
					try {
						chamarProduto.ListarProdutos();
					}catch(Exception e) {
						System.out.println("Erro ao se comunicar com o controlador de Produtos" + e.getMessage());
					}
					
					System.out.println("Digite o código do produto que deseja alterar o nome: ");
					codigo = ler.next();
					while(!validar.StringValida(codigo)) {
						System.out.println("Valor inválido. Por favor, digite o código do produto: ");
						codigo = ler.next();
					}
					System.out.println("Digite o novo preço do produto selecionado: ");
					try {
						preco = Double.parseDouble(ler.next());
					}catch(Exception e) {
						System.out.println("Erro na inserção do preço" + e.getMessage());
					}
					while(!validar.PrecoValido(preco)) {
						System.out.println("Valor inválido. Por favor, digite um preço válido para o produto: ");
						try {
							preco = Double.parseDouble(ler.next());
						}catch(Exception e) {
							System.out.println("Erro na inserção do preço" + e.getMessage());
						}
					}
					try {
						if(chamarProduto.atualizarPreco(preco, codigo)) {
							System.out.println("Preço do produto atualizado com sucesso!");
						}else {
							System.out.println("Operação não realizada.");
						}
					}catch(Exception e) {
						System.out.println("Erro ao se comunicar com o controlador de Produtos" + e.getMessage());
					}
					
					break;
				case 6 :
					try {
						chamarProduto.ListarProdutos();
					}catch(Exception e) {
						System.out.println("Erro ao se comunicar com o controlador de Produtos" + e.getMessage());
					}
					
					System.out.println("Digite o código do produto que deseja alterar o nome: ");
					codigo = ler.next();
					while(!validar.StringValida(codigo)) {
						System.out.println("Valor inválido. Por favor, digite o código do produto: ");
						codigo = ler.next();
					}
					System.out.println("Digite o novo código do produto selecionado: ");
					String codigoNovo = ler.next();
					while(!validar.StringValida(codigoNovo)) {
						System.out.println("Valor inválido. Por favor, digite o código novo para o produto: ");
						codigo = ler.next();
					}
					try {
						if(chamarProduto.atualizarCodigoProduto(codigo, codigoNovo)) {
							System.out.println("Código do produto atualizado com sucesso!");
						}else {
							System.out.println("Operação não realizada.");
						}
					}catch(Exception e) {
						System.out.println("Erro ao se comunicar com o controlador de Produtos" + e.getMessage());
					}
					break;
				case 7 :
					try {
						chamarProduto.ListarProdutos();
					}catch(Exception e) {
						System.out.println("Erro ao se comunicar com o controlador de Produtos" + e.getMessage());
					}
					
					System.out.println("Digite o código do produto que deseja alterar o nome: ");
					codigo = ler.next();
					while(!validar.StringValida(codigo)) {
						System.out.println("Valor inválido. Por favor, digite o código do produto: ");
						codigo = ler.next();
					}
					System.out.println("Digite a quantidade nova do produto selecionado: ");
					try {
						quantidade = Integer.parseInt(ler.next());
					}catch(Exception e) {
						System.out.println("Erro na inserção da quantidade " + e.getMessage());
					}
					while(!validar.NumeroValido(quantidade)) {
						System.out.println("Valor inválido. Por favor, digite a quantidade nova do produto: ");
						try {
							quantidade = Integer.parseInt(ler.next());
						}catch(Exception e) {
							System.out.println("Erro na inserção da quantidade " + e.getMessage());
						}
					}
					try {
						if(chamarProduto.atualizarQuantidade(codigo, quantidade)){
							System.out.println("Quantidade nova do produto atualizada com sucesso!");
						}else {
							System.out.println("Operação não realizada.");
						}
					}catch(Exception e) {
						System.out.println("Erro ao se comunicar com o controlador de Produtos" + e.getMessage());
					}
					break;
				case 8 :
					try {
						chamarProduto.ListarProdutos();
					}catch(Exception e) {
						System.out.println("Erro ao se comunicar com o controlador de Produtos" + e.getMessage());
					}
					System.out.println("Digite o código do produto que deseja alterar o departamento: ");
					codigo = ler.next();
					while(!validar.StringValida(codigo)) {
						System.out.println("Valor inválido. Por favor, digite o código do produto: ");
						codigo = ler.next();
					}
					try {
						chamarDepartamento.ListarDepartamentos();
					}catch(Exception e){
						System.out.println("Erro ao se comunicar com o controlador de Departamento");
					}
					int idDepartamentoNovo = 0;
					System.out.println("Digite o id do departamento que deseja retirar o produto: ");
					try {
						idDepartamento = Integer.parseInt(ler.next());
					}catch(Exception e) {
						System.out.println("Erro na inserção do id do departamento antigo" + e.getLocalizedMessage());
					}
					while(!validar.NumeroValido(idDepartamento)) {
						System.out.println("Valor inválido. Por favor, digite um id de departamento válido");
						try {
							idDepartamento = Integer.parseInt(ler.next());
						}catch(Exception e) {
							System.out.println("Erro na inserção do id do novo departamento " + e.getMessage());
						}
					}
					System.out.println("Digite o id do departamento que deseja colocar o produto: ");
					try {
						idDepartamentoNovo = Integer.parseInt(ler.next());
					}catch(Exception e) {
						System.out.println("Erro na inserção do id do novo departamento" + e.getLocalizedMessage());
					}
					while(!validar.NumeroValido(idDepartamentoNovo)) {
						System.out.println("Valor inválido. Por favor, digite um id de departamento válido");
						try {
							idDepartamentoNovo = Integer.parseInt(ler.next());
						}catch(Exception e) {
							System.out.println("Erro na inserção do id do novo departamento " + e.getMessage());
						}
					}
					try {
						if(chamarProduto.atualizarDepartamento(codigo, idDepartamento, idDepartamentoNovo)) {
							System.out.println("Departamento do produto atualizado com sucesso!");
						}else {
							System.out.println("Operação não realizada.");
						}
					}catch(Exception e) {
						System.out.println("Erro ao se comunicar com o controlador de Produtos" + e.getMessage());
					}
					break;
				case 9 :
					opcao = 9;
					break;
				default :
					System.out.println("\n\n\nComando não encontrado. Veja novamente as opções do sistema.\n\n\n");			
			}
		}while(opcao != 9);
	}
}
