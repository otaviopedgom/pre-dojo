package com.model;

import java.util.Date;
import java.util.List;

public class Match {

	public Match() {
		// TODO Auto-generated constructor stub
	}
	
	private Long id;
	private List<Jogador> lstJogadores;
	private Date dataInicio;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the lstJogadores
	 */
	public List<Jogador> getLstJogadores() {
		return lstJogadores;
	}

	/**
	 * @param lstJogadores the lstJogadores to set
	 */
	public void setLstJogadores(List<Jogador> lstJogadores) {
		this.lstJogadores = lstJogadores;
	}

	/**
	 * @return the dataInicio
	 */
	public Date getDataInicio() {
		return dataInicio;
	}

	/**
	 * @param dataInicio the dataInicio to set
	 */
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

}
