package com.model;

import java.util.Date;


public class Jogador implements Comparable<Jogador> {

	public Jogador() {
		// TODO Auto-generated constructor stub
	}

	private String nome;
	private Integer quantidadeAssassinatos;
	private Integer quantidadeMortes;
	private Date tempoDeMatar;

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the quantidadeAssassinatos
	 */
	public Integer getQuantidadeAssassinatos() {
		return quantidadeAssassinatos;
	}

	/**
	 * @param quantidadeAssassinatos the quantidadeAssassinatos to set
	 */
	public void setQuantidadeAssassinatos(Integer quantidadeAssassinatos) {
		this.quantidadeAssassinatos = quantidadeAssassinatos;
	}

	/**
	 * @return the quantidadeMortes
	 */
	public Integer getQuantidadeMortes() {
		return quantidadeMortes;
	}

	/**
	 * @param quantidadeMortes the quantidadeMortes to set
	 */
	public void setQuantidadeMortes(Integer quantidadeMortes) {
		this.quantidadeMortes = quantidadeMortes;
	}
	
	@Override
	public boolean equals(Object obj) {
		Jogador j = (Jogador)obj;
		return this.nome.equals(j.getNome());
	}
	
	@Override
	public int compareTo(Jogador j) {
	        return j.getQuantidadeAssassinatos() - quantidadeAssassinatos ;
	}

	/**
	 * @return the tempoDeMatar
	 */
	public Date getTempoDeMatar() {
		return tempoDeMatar;
	}

	/**
	 * @param tempoDeMatar the tempoDeMatar to set
	 */
	public void setTempoDeMatar(Date tempoDeMatar) {
		this.tempoDeMatar = tempoDeMatar;
	}	
	
}
