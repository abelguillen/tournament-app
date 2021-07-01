package com.aguillen.tournamentapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.aguillen.tournamentapp.TournamentApplication;
import com.aguillen.tournamentapp.dto.JugadorDTO;
import com.aguillen.tournamentapp.dto.PartidoDTO;
import com.aguillen.tournamentapp.dto.PartidosJugadosDTO;
import com.aguillen.tournamentapp.entity.Jugador;
import com.aguillen.tournamentapp.entity.Partido;
import com.aguillen.tournamentapp.mapper.PartidoMapper;
import com.aguillen.tournamentapp.mapper.PartidosJugadosMapper;
import com.aguillen.tournamentapp.model.Equipos;
import com.aguillen.tournamentapp.model.PartidoResponse;
import com.aguillen.tournamentapp.repository.JugadorRepository;
import com.aguillen.tournamentapp.repository.PartidoRepository;

@Service
public class PartidoService {
	
	final static Logger LOG = LoggerFactory.getLogger(TournamentApplication.class);

	@Autowired
	private PartidoRepository partidoRepository;

	@Autowired
	private JugadorRepository jugadorRepository;
	
	@Autowired
	private PartidosJugadosService partidosJugadosService;
	
	@Autowired
	private JugadorService jugadorService;

	public List<PartidoResponse> getAll(String sortField, String sortOrder) throws Exception {
		try {
			Direction direction = Direction.fromString(sortOrder);
			List<PartidoDTO> partidoDTOList = PartidoMapper.convertPartidoBoToDto(partidoRepository.findAll(Sort.by(direction, sortField)));
			return PartidoMapper.buildPartidoListResponse(partidoDTOList);
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}

	public PartidoResponse getOne(Integer id) throws Exception {
		try {
			PartidoDTO partidoDTO = PartidoMapper.buildPartidoDTO(partidoRepository.getById(id));
			List<PartidosJugadosDTO> partidosJugadosDTOList = (partidosJugadosService.getByIdPartido(partidoDTO.getId()));
			return PartidoMapper.buildPartidoResponse(partidoDTO, partidosJugadosDTOList);
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}

	public PartidoResponse create(Partido partido, Equipos equipos) throws Exception {
		try {
			partido.setNroPartido(getNroPartido());
			validarJugadores(equipos);
			PartidoDTO partidoDTO = PartidoMapper.buildPartidoDTO(partidoRepository.save(partido));
			partidosJugadosService.save(PartidosJugadosMapper.buildEquiposToPartidosJugadosBO(equipos, partidoDTO.getId()));
			List<PartidosJugadosDTO> partidosJugadosDTOList = partidosJugadosService.getByIdPartido(partidoDTO.getId());
			sumarPuntos(partidosJugadosDTOList);
			return PartidoMapper.buildPartidoResponse(partidoDTO, partidosJugadosDTOList);
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}

	public PartidoDTO update(Partido partido) throws Exception {
		try {
			return PartidoMapper.buildPartidoDTO(partidoRepository.save(partido));
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}

	public boolean deleteById(Integer id) throws Exception {
		try {
			List<PartidosJugadosDTO> partidosJugadosDTOList = partidosJugadosService.getByIdPartido(id);
			descontarPuntos(partidosJugadosDTOList);
			partidoRepository.deleteById(id);
			return true;
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}
	
	private Integer getNroPartido() {
		Integer ultimoPartido = partidoRepository.getLastNroPartido();
		if(ultimoPartido == null) {
			return 1;
		} else {
			return ultimoPartido + 1;
		}
	}

	private void validarJugadores(Equipos equipos) throws Exception {
		try {
			validarEquipo(equipos.getEquipoA());
			validarEquipo(equipos.getEquipoB());
		} catch(Exception ex) {
			throw new Exception(ex);
		}
	}

	private void validarEquipo(List<Integer> equipoA) throws Exception {
		try {
			for(Integer idJugador : equipoA) {
				if(!jugadorRepository.existsById(idJugador)) {
					String message = "Uno o varios de los jugadores indicados no existe";
					LOG.error(message);
					throw new Exception(message);
				}
			}
		} catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	private void sumarPuntos(List<PartidosJugadosDTO> partidosJugadosDTOList) throws Exception {
		String ganador = partidosJugadosDTOList.get(0).getPartido().getGanador();
		Integer bonus = partidosJugadosDTOList.get(0).getPartido().getBonus();
		for(PartidosJugadosDTO partidosJugadosDTO : partidosJugadosDTOList) {
			String equipo = partidosJugadosDTO.getEquipo();
			Jugador jugador = partidosJugadosDTO.getJugador();
			if(ganador.equals("EMPATE")) {
				jugador.empatar();
			} else if(ganador.equals(equipo)) {
				jugador.ganar(bonus);
			} else if(!ganador.equals(equipo)) {
				jugador.perder();
			}
			try {
				@SuppressWarnings("unused")
				JugadorDTO jugadorDTO = jugadorService.save(jugador);
			} catch (Exception ex) {
				String message = "Ha ocurrido un error mientras se sumaban los puntos";
				LOG.error(message);
				throw new Exception(message);
			}
		}
	}
	
	private void descontarPuntos(List<PartidosJugadosDTO> partidosJugadosDTOList) throws Exception {
		String ganador = partidosJugadosDTOList.get(0).getPartido().getGanador();
		Integer bonus = partidosJugadosDTOList.get(0).getPartido().getBonus();
		for(PartidosJugadosDTO partidosJugadosDTO : partidosJugadosDTOList) {
			String equipo = partidosJugadosDTO.getEquipo();
			Jugador jugador = partidosJugadosDTO.getJugador();
			if(ganador.equals("EMPATE")) {
				jugador.rollbackEmpatar();
			} else if(ganador.equals(equipo)) {
				jugador.rollbackGanar(bonus);
			} else if(!ganador.equals(equipo)) {
				jugador.rollbackPerder();
			}
			try {
				@SuppressWarnings("unused")
				JugadorDTO jugadorDTO = jugadorService.save(jugador);
				partidosJugadosService.deleteById(partidosJugadosDTO.getId());
			} catch (Exception ex) {
				String message = "Ha ocurrido un error mientras se sumaban los puntos";
				LOG.error(message);
				throw new Exception(message);
			}
		}
		
	}

}
