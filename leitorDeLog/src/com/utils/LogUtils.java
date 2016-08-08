package com.utils;

public class LogUtils {

	
	public String encontrarValor(String chave, String linha) {
		String resultado ="";
		Integer index = linha.indexOf(chave) + chave.length();//encontra o inicio do valor desejado
		resultado = linha.substring(index).trim() ;//corta a string a partir do valor desejado retirando o espaço inicial e final
		String[] valores= resultado.split(" ");//quebra a string em um array, atraves do espaço
		resultado = valores[0]; // pega o primeiro valor da array desprezando o restante
		return resultado;
	}

	public String encontrarValorAntesDaChave(String chave, String linha) {
		String resultado ="";
		Integer index = linha.indexOf(chave);//encontra o inicio do valor desejado
		resultado = linha.substring(0, index).trim() ;//corta o final da string, no ponto onde encontrou a chave. 
		String[] valores= resultado.split(" ");//quebra a string em um array, atraves do espaço
		resultado = valores[valores.length-1];  //pega o ultimo valor da array desprezando o restante
		return resultado;
	}

}
