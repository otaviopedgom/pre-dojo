package com.business;

import java.util.Date;

import com.model.Jogador;
import com.model.Log;
import com.model.Match;

public class MontaRanking {

	public MontaRanking() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		LeLog lelog = new LeLog();
		Log log = lelog.getLog();
		
		for(Match m : log.getLstDePartidas()) {
			System.out.println("Partida numero: "+m.getId() );
			System.out.println("Data: "+ m.getDataInicio() );
			int i=1;
			for(Jogador j : m.getLstJogadores()) {
				
				System.out.println("");
				System.out.println("Jogador numero "+i+": "+j.getNome() );
				System.out.println("Numero de Assassinatos: "+j.getQuantidadeAssassinatos() );
				System.out.println("Mortes: "+j.getQuantidadeMortes());
				

				System.out.println("");
				if (j.getQuantidadeAssassinatos()>0 && j.getQuantidadeMortes()==0 && i==1) {
					System.out.println("*******AWARD*******");
					System.out.println("Venceu sem morrer nenhuma vez");
				}
				
				
				
				System.out.println("");
				i++;
				
			}
		}		

		
	}

}
