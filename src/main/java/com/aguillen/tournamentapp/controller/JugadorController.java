package com.aguillen.tournamentapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aguillen.tournamentapp.TournamentApplication;
import com.aguillen.tournamentapp.dto.JugadorDTO;
import com.aguillen.tournamentapp.service.JugadorService;
import com.aguillen.tournamentapp.util.JugadorMapper;

@RestController
@RequestMapping(value = "/jugador")
public class JugadorController {

	final static Logger LOG = LoggerFactory.getLogger(TournamentApplication.class);

	@Autowired
	private JugadorService service;

	@GetMapping("/list")
	public List<JugadorDTO> getAll() throws Exception {
		try {
			return service.getAll();
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error al obtener la lista de jugadores");
			throw new Exception(ex);
		}
	}

	@GetMapping("/{id}")
	public JugadorDTO getOne(@PathVariable("id") Integer id) throws Exception {
		try {
			return service.getOne(id);
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error al obtener al jugador");
			throw new Exception(ex);
		}
	}

	@PostMapping("/create")
	public JugadorDTO create(@RequestBody JugadorDTO jugadorDTO) throws Exception {
		try {
			return service.save(JugadorMapper.buildJugadorBO(jugadorDTO));
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error al crear al jugador");
			throw new Exception(ex);
		}
	}

	@PutMapping("/update")
	public JugadorDTO update(@RequestBody JugadorDTO jugadorDTO) throws Exception {
		try {
			return service.save(JugadorMapper.buildJugadorBO(jugadorDTO));
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error al modificar al jugador");
			throw new Exception(ex);
		}
	}

	@DeleteMapping("/delete")
	public boolean deleteById(@RequestParam("id") Integer id) throws Exception {
		try {
			return service.deleteById(id);
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error al eliminar al jugador");
			throw new Exception(ex);
		}
	}

}
