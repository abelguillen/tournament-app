package com.aguillen.tournamentapp.entity;

import java.math.BigDecimal;

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
	
	@Column(name = "efectividad")
	private String efectividad;
	
	public Jugador() {}

	public Jugador(Integer id, String nombre, Integer pj, Integer pg, Integer pe, Integer pp, Integer bonus,
			Integer puntos, String efectividad) {
		this.id = id;
		this.nombre = nombre;
		this.pj = pj;
		this.pg = pg;
		this.pe = pe;
		this.pp = pp;
		this.bonus = bonus;
		this.puntos = puntos;
		this.efectividad = efectividad;
	}
	
	public void ganar(Integer bonus) {
		this.pj++;
		this.pg++;
		this.bonus+=bonus;
		this.puntos=calcularPuntos();
		this.efectividad=calcularEfectividad();
	}
	
	public void rollbackGanar(Integer bonus) {
		this.pj--;
		this.pg--;
		this.bonus-=bonus;
		this.puntos=calcularPuntos();
		this.efectividad=calcularEfectividad();
	}
	
	public void empatar() {
		this.pj++;
		this.pe++;
		this.puntos=calcularPuntos();
		this.efectividad=calcularEfectividad();
	}
	
	public void rollbackEmpatar() {
		this.pj--;
		this.pe--;
		this.puntos=calcularPuntos();
		this.efectividad=calcularEfectividad();
	}
	
	public void perder() {
		this.pj++;
		this.pp++;
		this.puntos=calcularPuntos();
		this.efectividad=calcularEfectividad();
	}
	
	public void rollbackPerder() {
		this.pj--;
		this.pp--;
		this.puntos=calcularPuntos();
		this.efectividad=calcularEfectividad();
	}
	
	private Integer calcularPuntos() {
		return pg*3 + pe + bonus;
	}
	
	private String calcularEfectividad() {
		double calculo;
		if(this.pj != 0) {
			calculo = (double)this.pg / (double)this.pj * 100;
			BigDecimal calculoBD = new BigDecimal(calculo);
			calculoBD = calculoBD.setScale(0, BigDecimal.ROUND_DOWN);
			return calculoBD.toString().concat("%");
		} else {
			return "0%";
		}
		
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

	public String getEfectividad() {
		return efectividad;
	}

	public void setEfectividad(String efectividad) {
		this.efectividad = efectividad;
	}

}