package com.aguillen.tournamentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguillen.tournamentapp.dto.JugadorDTO;
import com.aguillen.tournamentapp.model.Jugador;
import com.aguillen.tournamentapp.repository.JugadorRepository;
import com.aguillen.tournamentapp.util.JugadorMapper;

@Service
public class JugadorService {
	
	@Autowired
	private JugadorRepository repository;
	
	public List<JugadorDTO> getAll() throws Exception {
		try {
			return JugadorMapper.convertJugadorBoToDto(repository.findAll());
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
	
	public JugadorDTO save(Jugador article) throws Exception {
		try {
			return JugadorMapper.buildJugadorDTO(repository.save(article));
		} catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	public boolean deleteById(Integer id) throws Exception {
		try {
			repository.deleteById(id);
			return true;
		} catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
}
