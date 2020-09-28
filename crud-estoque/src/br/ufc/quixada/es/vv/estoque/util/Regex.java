package br.ufc.quixada.es.vv.estoque.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	public boolean StringValida(String palavra) {
		Pattern faixaValida = Pattern.compile("^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ]+[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]*$");
		Matcher procura = faixaValida.matcher(palavra);
		
		if(procura.matches()) {
			return true;
		}
		System.out.println("Texto inválido!");
		return false;
	}
	public boolean NumeroValido(int num) {
		String numNaoVazio = String.valueOf(num);
		Pattern faixaValida = Pattern.compile("[0-9]*");
		Matcher procura = faixaValida.matcher(numNaoVazio);
		if(procura.matches()) {
			return true;
		}
		System.out.println("Número inválido");
		return false;
	}
	public boolean PrecoValido(double preco) {
		String precoNaoVazio = String.valueOf(preco);
		Pattern faixaValida = Pattern.compile("([0-9])*\\.\\d{1,2}$");
		Matcher procura = faixaValida.matcher(precoNaoVazio);
		if(procura.matches()) {
			return true;
		}
		System.out.println("Preço inválido");
		return false;
	}
	
}
