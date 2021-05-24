package com.aguillen.tournamentapp.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aguillen.tournamentapp.entity.Jugador;

@Repository
public interface JugadorRepository extends CrudRepository<Jugador, Integer> {
	
	public List<Jugador> findAll(Sort sort);
	
	public Jugador getById(Integer id);
	
	@SuppressWarnings("unchecked")
	public Jugador save(Jugador jugador);
	
	public void deleteById(Integer id);
	
}
