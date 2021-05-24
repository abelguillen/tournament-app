package com.aguillen.tournamentapp.model;

import java.util.Date;
import java.util.List;

public class PartidoResponse {
	
	private Integer id;
	private Date fecha;
	private Integer nroPartido;
	private Integer bonus;
	private String ganador;
	private List<JugadorEnPartido> jugadorEnPartido;
	
	public PartidoResponse() {}

	public PartidoResponse(Integer id, Date fecha, Integer nroPartido, Integer bonus, String ganador,
			List<JugadorEnPartido> jugadorEnPartido) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.nroPartido = nroPartido;
		this.bonus = bonus;
		this.ganador = ganador;
		this.jugadorEnPartido = jugadorEnPartido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
