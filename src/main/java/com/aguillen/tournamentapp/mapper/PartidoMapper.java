package com.aguillen.tournamentapp.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.aguillen.tournamentapp.dto.PartidoDTO;
import com.aguillen.tournamentapp.dto.PartidosJugadosDTO;
import com.aguillen.tournamentapp.entity.Partido;
import com.aguillen.tournamentapp.model.Equipos;
import com.aguillen.tournamentapp.model.JugadorEnPartido;
import com.aguillen.tournamentapp.model.PartidoResponse;

@Component
public class PartidoMapper {

	private static ModelMapper modelMapper = new ModelMapper();
	
	public static PartidoDTO buildPartidoDTO(Partido partido) {
		return modelMapper.map(partido, PartidoDTO.class);
	}
	
	public static Partido buildPartidoBO(PartidoDTO partidoDTO) {
		Partido partido = modelMapper.map(partidoDTO, Partido.class);
		if(partido.getFecha() == null) partido.setFecha(LocalDateTime.now());
		return partido;
	}
	
	public static Equipos buildEquiposBO(PartidoDTO partidoDTO) {
		return modelMapper.map(partidoDTO, Equipos.class);
	}
	
	public static List<PartidoDTO> convertPartidoBoToDto(List<Partido> partidoes) {
		List<PartidoDTO> partidoesDTO = new ArrayList<PartidoDTO>();
		for(Partido partido : partidoes) {
			partidoesDTO.add(buildPartidoDTO(partido));
		}
		return partidoesDTO;
	}

	public static PartidoResponse buildPartidoResponse(PartidoDTO partidoDTO, List<PartidosJugadosDTO> partidosJugadosDTOList) {
		List<JugadorEnPartido> jugadorEnPartidoList = new ArrayList<JugadorEnPartido>();
		
		for(PartidosJugadosDTO partidosJugadosDTO : partidosJugadosDTOList) {
			JugadorEnPartido jugadorEnPartido = new JugadorEnPartido();
			jugadorEnPartido.setEquipo(partidosJugadosDTO.getEquipo());
			jugadorEnPartido.setIdJugador(partidosJugadosDTO.getJugador().getId());
			jugadorEnPartido.setNombre(partidosJugadosDTO.getJugador().getNombre());
			jugadorEnPartidoList.add(jugadorEnPartido);
		}
		
		PartidoResponse partidoResponse = new PartidoResponse();
		partidoResponse.setId(partidoDTO.getId());
		partidoResponse.setFecha(partidoDTO.getFecha());
		partidoResponse.setBonus(partidoDTO.getBonus());
		partidoResponse.setGanador(partidoDTO.getGanador());
		partidoResponse.setNroPartido(partidoDTO.getNroPartido());
		partidoResponse.setJugadorEnPartido(jugadorEnPartidoList);
		
		return partidoResponse;
	}
	
	public static List<PartidoResponse> buildPartidoListResponse(List<PartidoDTO> partidoDTOList) {
		
		List<PartidoResponse> partidoResponseList = new ArrayList<>();
		
		for(PartidoDTO partidoDTO : partidoDTOList) {
			PartidoResponse partidoResponse = new PartidoResponse();
			partidoResponse.setId(partidoDTO.getId());
			partidoResponse.setFecha(partidoDTO.getFecha());
			partidoResponse.setBonus(partidoDTO.getBonus());
			partidoResponse.setGanador(partidoDTO.getGanador());
			partidoResponse.setNroPartido(partidoDTO.getNroPartido());
			
			partidoResponseList.add(partidoResponse);
		}
		
		return partidoResponseList;
		
	}
	
}
