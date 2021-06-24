package com.aguillen.tournamentapp.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aguillen.tournamentapp.entity.Partido;

@Repository
public interface PartidoRepository extends CrudRepository<Partido, Integer> {
	
	public List<Partido> findAll(Sort sort);
	
	public Partido getById(Integer id);
	
	@SuppressWarnings("unchecked")
	public Partido save(Partido partido);
	
	public void deleteById(Integer id);
	
	@Query(value = "select max(p.nroPartido) from Partido as p")
	public Integer getLastNroPartido();
	
}
