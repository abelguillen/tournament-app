package com.aguillen.tournamentapp.model;

import java.util.List;

public class PartidoResponse {
	
	private Integer nroPartido;
	private Integer bonus;
	private String ganador;
	private List<JugadorEnPartido> jugadorEnPartido;
	
	public PartidoResponse() {}
	
	public PartidoResponse(Integer nroPartido, Integer bonus, String ganador, List<JugadorEnPartido> jugadorEnPartido) {
		this.nroPartido = nroPartido;
		this.bonus = bonus;
		this.ganador = ganador;
		this.jugadorEnPartido = jugadorEnPartido;
	}

	public Integer getNroPartido() {
		return nroPartido;
	}
	
	public void setNroPartido(Integer nroPartido) {
		this.nroPartido = nroPartido;
	}
	
	public Integer getBonus() {
		return bonus;
	}
	
	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}
	
	public String getGanador() {
		return ganador;
	}
	
	public void setGanador(String ganador) {
		this.ganador = ganador;
	}
	
	public List<JugadorEnPartido> getJugadorEnPartido() {
		return jugadorEnPartido;
	}
	
	public void setJugadorEnPartido(List<JugadorEnPartido> jugadorEnPartido) {
		this.jugadorEnPartido = jugadorEnPartido;
	}

}
