package com.aguillen.tournamentapp.dto;

import com.aguillen.tournamentapp.entity.Jugador;
import com.aguillen.tournamentapp.entity.Partido;

public class PartidosJugadosDTO {

	private int id;
	private Partido partido;
	private Jugador jugador;
	private String equipo;
	
	public PartidosJugadosDTO(int id, Partido partido, Jugador jugador, String equipo) {
		this.id = id;
		this.partido = partido;
		this.jugador = jugador;
		this.equipo = equipo;
	}
	
	public PartidosJugadosDTO() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Partido getPartido() {
		return partido;
	}
	public void setPartido(Partido partido) {
		this.partido = partido;
	}
	public Jugador getJugador() {
		return jugador;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	
}
