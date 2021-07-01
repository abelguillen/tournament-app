package com.aguillen.tournamentapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jugador")
public class Jugador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "pj")
	private Integer pj;
	
	@Column(name = "pg")
	private Integer pg;
	
	@Column(name = "pe")
	private Integer pe;
	
	@Column(name = "pp")
	private Integer pp;
	
	@Column(name = "bonus")
	private Integer bonus;
	
	@Column(name = "puntos")
	private Integer puntos;
	
	public Jugador() {}

	public Jugador(Integer id, String nombre, Integer pj, Integer pg, Integer pe, Integer pp, Integer bonus,
			Integer puntos) {
		this.id = id;
		this.nombre = nombre;
		this.pj = pj;
		this.pg = pg;
		this.pe = pe;
		this.pp = pp;
		this.bonus = bonus;
		this.puntos = puntos;
	}
	
	public void ganar(Integer bonus) {
		this.pj++;
		this.pg++;
		this.bonus+=bonus;
		this.puntos=calcularPuntos();
	}
	
	public void rollbackGanar(Integer bonus) {
		this.pj--;
		this.pg--;
		this.bonus-=bonus;
		this.puntos=calcularPuntos();
	}
	
	public void empatar() {
		this.pj++;
		this.pe++;
		this.puntos=calcularPuntos();
	}
	
	public void rollbackEmpatar() {
		this.pj--;
		this.pe--;
		this.puntos=calcularPuntos();
	}
	
	public void perder() {
		this.pj++;
		this.pp++;
		this.puntos=calcularPuntos();
	}
	
	public void rollbackPerder() {
		this.pj--;
		this.pp--;
		this.puntos=calcularPuntos();
	}
	
	private Integer calcularPuntos() {
		return pg*3 + pe + bonus;
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