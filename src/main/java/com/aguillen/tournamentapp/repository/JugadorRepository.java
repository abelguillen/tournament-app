package com.aguillen.tournamentapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aguillen.tournamentapp.model.Jugador;

@Repository
public interface JugadorRepository extends CrudRepository<Jugador, Integer> {
	
	public List<Jugador> findAll();
	
	public Jugador getById(Integer id);
	
	@SuppressWarnings("unchecked")
	public Jugador save(Jugador jugador);
	
	public void deleteById(Integer id);
	
}
