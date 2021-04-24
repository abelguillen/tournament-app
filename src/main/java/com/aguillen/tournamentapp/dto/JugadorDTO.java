package com.aguillen.tournamentapp.dto;

import org.springframework.stereotype.Component;

@Component
public class JugadorDTO {

	private Integer id;
	private String nombre;
	private Integer pj;
	private Integer pg;
	private Integer pe;
	private Integer pp;
	private Integer bonus;
	private Integer puntos;

	public JugadorDTO() {}

	public JugadorDTO(Integer id, String nombre, Integer pj, Integer pg, Integer pe, Integer pp, Integer bonus,
			Integer puntos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pj = pj;
		this.pg = pg;
		this.pe = pe;
		this.pp = pp;
		this.bonus = bonus;
		this.puntos = puntos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPj() {
		return pj;
	}

	public void setPj(Integer pj) {
		this.pj = pj;
	}

	public Integer getPg() {
		return pg;
	}

	public void setPg(Integer pg) {
		this.pg = pg;
	}

	public Integer getPe() {
		return pe;
	}

	public void setPe(Integer pe) {
		this.pe = pe;
	}

	public Integer getPp() {
		return pp;
	}

	public void setPp(Integer pp) {
		this.pp = pp;
	}

	public Integer getBonus() {
		return bonus;
	}

	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}

	public Integer getPuntos() {
		return puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

}
