package com.aguillen.tournamentapp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.aguillen.tournamentapp.dto.PartidosJugadosDTO;
import com.aguillen.tournamentapp.entity.Jugador;
import com.aguillen.tournamentapp.entity.Partido;
import com.aguillen.tournamentapp.entity.PartidosJugados;
import com.aguillen.tournamentapp.model.Equipos;

@Component
public class PartidosJugadosMapper {

	private static ModelMapper modelMapper = new ModelMapper();
	
	public static PartidosJugadosDTO buildPartidosJugadosDTO(PartidosJugados partidosJugados) {
		return modelMapper.map(partidosJugados, PartidosJugadosDTO.class);
	}
	
	public static PartidosJugados buildPartidosJugadosBO(PartidosJugadosDTO partidosJugadosDTO) {
		return modelMapper.map(partidosJugadosDTO, PartidosJugados.class);
	}
	
	public static List<PartidosJugadosDTO> buildPartidosJugadosListToPartidosJugadosDTOList(List<PartidosJugados> partidosJugadosList) {
		List<PartidosJugadosDTO> partidosJugadosDTOList = new ArrayList<PartidosJugadosDTO>();
		for(PartidosJugados partidosJugados : partidosJugadosList) {
			partidosJugadosDTOList.add(buildPartidosJugadosDTO(partidosJugados));
		}
		return partidosJugadosDTOList;
	}
	
	public static List<PartidosJugados> buildEquiposToPartidosJugadosBO(Equipos equipos, Integer idPartido) {
		List<PartidosJugados> partidosJugadosList = new ArrayList<PartidosJugados>();
		for(Integer idJugador : equipos.getEquipoA()) {
			
			Jugador jugador = new Jugador();
			jugador.setId(idJugador);
			
			Partido partido = new Partido();
			partido.setId(idPartido);
			
			PartidosJugados partidosJugados = new PartidosJugados();
			partidosJugados.setEquipo("A");
			partidosJugados.setPartido(partido);
			partidosJugados.setJugador(jugador);
			
			partidosJugadosList.add(partidosJugados);
		}
		
		for(Integer idJugador : equipos.getEquipoB()) {
			
			Jugador jugador = new Jugador();
			jugador.setId(idJugador);
			
			Partido partido = new Partido();
			partido.setId(idPartido);
			
			PartidosJugados partidosJugados = new PartidosJugados();
			partidosJugados.setEquipo("B");
			partidosJugados.setPartido(partido);
			partidosJugados.setJugador(jugador);
			
			partidosJugadosList.add(partidosJugados);
		}
		
		return partidosJugadosList;
	}
	
}
