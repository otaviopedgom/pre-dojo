package com.business;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Enum.EnumEvento;

import com.model.Jogador;
import com.model.Log;
import com.model.Match;
import com.utils.LogUtils;

public class LeLog {

	
	private Log log = new Log();
	private LogUtils util = new LogUtils();
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	
	public LeLog() {
		BufferedReader br = null;
		String linha;
		log.setLstDePartidas(new ArrayList<Match>());
		
		try {
			br = new BufferedReader(new FileReader("C:\\Log\\log.txt"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			while ((linha = br.readLine()) != null) {
				leLinha(linha);
			}
			
			//Agrupa por nome do jogador.
			for(Match m : log.getLstDePartidas()) {
				List<Jogador> lstJogador = new ArrayList<Jogador>();
				for(Jogador j : m.getLstJogadores()) {
					//Verifica se o Jogador com o mesmo nome já foi inserido na lista (Override no equals), pega esse Jogador na lista e atualiza o numero de mortes e assassinatos.
					if(lstJogador.contains(j)) {
						lstJogador.get(lstJogador.indexOf(j)).setQuantidadeAssassinatos(lstJogador.get(lstJogador.indexOf(j)).getQuantidadeAssassinatos()+  j.getQuantidadeAssassinatos() );
						lstJogador.get(lstJogador.indexOf(j)).setQuantidadeMortes(lstJogador.get(lstJogador.indexOf(j)).getQuantidadeMortes() +    j.getQuantidadeMortes());
					} else {
						lstJogador.add(j);
					}
					
				}

				Collections.sort(lstJogador);//Ordenando jogadores por assasssinato (ver compareTo da classe Jogador)
				m.setLstJogadores(lstJogador);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	private void leLinha(String linha) {

		
		switch (EnumEvento.getPorCodigo(linha)) {
		case BEGIN_MATCH :
			Match match = new Match();
			match.setId(Long.valueOf(util.encontrarValor( EnumEvento.BEGIN_MATCH.getCodigo() , linha) ));
			match.setLstJogadores(new ArrayList<Jogador>());
			
			
			try {
				match.setDataInicio(format.parse(linha.substring(0,19))  );
			} catch (ParseException e) {
				e.printStackTrace();
			}
			this.log.getLstDePartidas().add(match);

			break;
		case END_MATCH :
			
			break;
		case KILL :
			Jogador jogMorto = new Jogador();
			jogMorto.setNome(util.encontrarValor( EnumEvento.KILL.getCodigo() , linha) ) ;
			jogMorto.setQuantidadeMortes(1);
			jogMorto.setQuantidadeAssassinatos(0);
			
			this.log.getLstDePartidas().get(log.getLstDePartidas().size()-1).getLstJogadores().add(jogMorto);
			
			if (!"<WORLD>".equals(util.encontrarValorAntesDaChave( EnumEvento.KILL.getCodigo() , linha) )) {
				Jogador jogVivo = new Jogador();
				jogVivo.setNome(util.encontrarValorAntesDaChave( EnumEvento.KILL.getCodigo() , linha) ) ;
				jogVivo.setQuantidadeMortes(0);
				jogVivo.setQuantidadeAssassinatos(1);
				try {
					jogVivo.setTempoDeMatar(format.parse(linha.substring(0,19)));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				this.log.getLstDePartidas().get(log.getLstDePartidas().size()-1).getLstJogadores().add(jogVivo);
			}
			
			break;

		default:
			break;
		} 
		
	}

	/**
	 * @return the log
	 */
	public Log getLog() {
		return log;
	}

	/**
	 * @param log the log to set
	 */
	public void setLog(Log log) {
		this.log = log;
	}

}
