package com.aguillen.tournamentapp.dto;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PartidoDTO {

	private Integer id;
	private Integer nroPartido;
	private Date fecha;
	private List<Integer> equipoA;
	private List<Integer> equipoB;
	private String ganador;
	private Integer bonus;

	public PartidoDTO() { }

	public PartidoDTO(Integer id, Integer nroPartido, Date fecha, List<Integer> equipoA, List<Integer> equipoB,
			String ganador, Integer bonus) {
		super();
		this.id = id;
		this.nroPartido = nroPartido;
		this.fecha = fecha;
		this.equipoA = equipoA;
		this.equipoB = equipoB;
		this.ganador = ganador;
		this.bonus = bonus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNroPartido() {
		return nroPartido;
	}

	public void setNroPartido(Integer nroPartido) {
		this.nroPartido = nroPartido;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Integer> getEquipoA() {
		return equipoA;
	}

	public void setEquipoA(List<Integer> equipoA) {
		this.equipoA = equipoA;
	}

	public List<Integer> getEquipoB() {
		return equipoB;
	}

	public void setEquipoB(List<Integer> equipoB) {
		this.equipoB = equipoB;
	}

	public String getGanador() {
		return ganador;
	}

	public void setGanador(String ganador) {
		this.ganador = ganador;
	}

	public Integer getBonus() {
		return bonus;
	}

	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}

}