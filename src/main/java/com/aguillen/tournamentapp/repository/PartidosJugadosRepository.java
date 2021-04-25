package com.aguillen.tournamentapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aguillen.tournamentapp.entity.Partido;
import com.aguillen.tournamentapp.entity.PartidosJugados;

@Repository
public interface PartidosJugadosRepository extends CrudRepository<PartidosJugados, Integer> {
	
	public List<PartidosJugados> findAll();
	
	public PartidosJugados getById(Integer id);
	
	public List<PartidosJugados> getByPartido(Partido partido);
	
	public void deleteById(Integer id);
	
}
