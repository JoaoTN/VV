package br.ufc.quixada.es.vv.estoque.view;
import java.util.Scanner;
import br.ufc.quixada.es.vv.estoque.util.Regex;
import br.ufc.quixada.es.vv.estoque.view.FronteiraMenuProduto;
import br.ufc.quixada.es.vv.estoque.view.FronteiraMenuDepartamento;

public class FronteiraMenuPrincipal {
	private static Scanner ler;
	
	public static void main(String[] args) throws Exception{
		Regex validar = new Regex();
		ler = new Scanner(System.in);
		int opcao = 0;
		String msg = "----------------------------------------------------\n" 
				+ "Bem-Vindo ao Sistema de Estoque do Super Marquim!\n"
				+ "Digite uma das op��es abaixo que deseja fazer no sistema: \n"
				+ "1  - Gerenciar produtos.\n" 
				+ "2  - Gerenciar departamentos.\n"
				+ "3 - Sair e fechar o programa";
		
		do {
			System.out.println(msg);
			try {
				opcao = ler.nextInt();
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
					new FronteiraMenuProduto().GerenciarProdutos();
					break;
				case 2 :
					new FronteiraMenuDepartamento().GerenciarDepartamentos();
					break;
				case 3 :
					opcao = 3;
					break;
				default :
					System.out.println("\n\n\nComando n�o encontrado. Veja novamente as op��es do sistema.\n\n\n");			
			}
		}while(opcao != 3);
	}
}
