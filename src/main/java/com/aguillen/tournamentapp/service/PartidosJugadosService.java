package com.aguillen.tournamentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguillen.tournamentapp.dto.PartidosJugadosDTO;
import com.aguillen.tournamentapp.entity.Partido;
import com.aguillen.tournamentapp.entity.PartidosJugados;
import com.aguillen.tournamentapp.mapper.PartidosJugadosMapper;
import com.aguillen.tournamentapp.repository.PartidosJugadosRepository;

@Service
public class PartidosJugadosService {
	
	@Autowired
	private PartidosJugadosRepository partidosJugadosrepository;
	
	public List<PartidosJugadosDTO> getAll() throws Exception {
		try {			
			return PartidosJugadosMapper.buildPartidosJugadosListToPartidosJugadosDTOList(partidosJugadosrepository.findAll());
		} catch(Exception ex) {
			throw new Exception(ex);
		}
	}

	public List<PartidosJugadosDTO> getByIdPartido(Integer idPartido) throws Exception {
		try {
			return PartidosJugadosMapper.buildPartidosJugadosListToPartidosJugadosDTOList(
					partidosJugadosrepository.getByPartido(new Partido(idPartido)));
		} catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	public void save(List<PartidosJugados> partidosJugadosRequestList) throws Exception {
		try {
			for(PartidosJugados partidosJugados : partidosJugadosRequestList) {
				partidosJugadosrepository.save(partidosJugados);
			}
		} catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	public boolean deleteById(Integer id) throws Exception {
		try {
			partidosJugadosrepository.deleteById(id);
			return true;
		} catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
}
