package com.aguillen.tournamentapp.util;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.aguillen.tournamentapp.dto.JugadorDTO;
import com.aguillen.tournamentapp.model.Jugador;

@Component
public class JugadorMapper {

	private static ModelMapper modelMapper = new ModelMapper();
	
	public static JugadorDTO buildJugadorDTO(Jugador jugador) {
		return modelMapper.map(jugador, JugadorDTO.class);
	}
	
	public static Jugador buildJugadorBO(JugadorDTO jugadorDTO) {
		return modelMapper.map(jugadorDTO, Jugador.class);
	}
	
	public static List<JugadorDTO> convertJugadorBoToDto(List<Jugador> jugadores) {
		List<JugadorDTO> jugadoresDTO = new ArrayList<JugadorDTO>();
		for(Jugador jugador : jugadores) {
			jugadoresDTO.add(buildJugadorDTO(jugador));
		}
		return jugadoresDTO;
	}
	
}
