package com.aguillen.tournamentapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aguillen.tournamentapp.entity.Partido;

@Repository
public interface PartidoRepository extends CrudRepository<Partido, Integer> {
	
	public List<Partido> findAll();
	
	public Partido getById(Integer id);
	
	@SuppressWarnings("unchecked")
	public Partido save(Partido partido);
	
	public void deleteById(Integer id);
	
}
