package com.aguillen.tournamentapp.model;

public class JugadorEnPartido {

	private Integer idJugador;
	private String nombre;
	private String equipo;
	
	public JugadorEnPartido() {}
	
	public JugadorEnPartido(Integer idJugador, String nombre, String equipo) {
		this.idJugador = idJugador;
		this.nombre = nombre;
		this.equipo = equipo;
	}
	public Integer getIdJugador() {
		return idJugador;
	}
	public void setIdJugador(Integer idJugador) {
		this.idJugador = idJugador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

}
