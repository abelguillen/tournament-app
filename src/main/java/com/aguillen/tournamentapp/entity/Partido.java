package com.aguillen.tournamentapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "partido")
public class Partido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nro_partido")
	private Integer nroPartido;

	@Column(name = "fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Column(name = "ganador")
	private String ganador;
	
	@Column(name = "bonus")
	private Integer bonus;
	
	public Partido() {}
	
	public Partido(Integer id) {
		this.id = id;
	}

	public Partido(Integer id, Integer nroPartido, Date fecha, String ganador, Integer bonus) {
		this.id = id;
		this.nroPartido = nroPartido;
		this.fecha = fecha;
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