package com.aguillen.tournamentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.aguillen.tournamentapp.dto.JugadorDTO;
import com.aguillen.tournamentapp.entity.Jugador;
import com.aguillen.tournamentapp.mapper.JugadorMapper;
import com.aguillen.tournamentapp.repository.JugadorRepository;

@Service
public class JugadorService {
	
	@Autowired
	private JugadorRepository repository;
	
	public List<JugadorDTO> getAll(String sortField, String sortOrder) throws Exception {
		try {
			Direction direction = Direction.fromString(sortOrder);
			return JugadorMapper.convertJugadorBoToDto(repository.findAll(Sort.by(direction, sortField)));
		} catch(Exception ex) {
			throw new Exception(ex);
		}
	}

	public JugadorDTO getOne(Integer id) throws Exception {
		try {
			return JugadorMapper.buildJugadorDTO(repository.getById(id));
		} catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	public JugadorDTO save(Jugador jugador) throws Exception {
		try {
			return JugadorMapper.buildJugadorDTO(repository.save(jugador));
		} catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	public boolean deleteById(Integer id) throws Exception {
		try {
			repository.deleteById(id);
			return true;
		} catch(DataIntegrityViolationException ex) {
			throw new Exception("No se puede eliminar a un jugador que ya haya jugado partidos", ex);
		} catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
}
