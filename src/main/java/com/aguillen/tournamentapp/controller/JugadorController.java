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
import com.aguillen.tournamentapp.mapper.JugadorMapper;
import com.aguillen.tournamentapp.service.JugadorService;

@RestController
@RequestMapping(value = "/jugador")
public class JugadorController {

	final static Logger LOG = LoggerFactory.getLogger(TournamentApplication.class);

	@Autowired
	private JugadorService service;

	/***
	 * List jugador
	 * 
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/list")
	public List<JugadorDTO> getAll(@RequestParam(value="sort_field", required=false, defaultValue = "puntos") String sortField,
            @RequestParam(value="sort_order", required=false, defaultValue = "DESC") String sortOrder) throws Exception {
		try {
			return service.getAll(sortField, sortOrder);
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error al obtener la lista de jugadores");
			throw new Exception(ex);
		}
	}

	/***
	 * GetById jugador
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public JugadorDTO getOne(@PathVariable("id") Integer id) throws Exception {
		try {
			return service.getOne(id);
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error al obtener al jugador");
			throw new Exception(ex);
		}
	}

	/***
	 * Create jugador
	 * 
	 * @param jugadorDTO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/create")
	public JugadorDTO create(@RequestBody JugadorDTO jugadorDTO) throws Exception {
		try {
			return service.save(JugadorMapper.buildJugadorBO(jugadorDTO));
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error al crear al jugador");
			throw new Exception(ex);
		}
	}

	/***
	 * Update jugador
	 * 
	 * @param jugadorDTO
	 * @return
	 * @throws Exception
	 */
	@PutMapping("/update")
	public JugadorDTO update(@RequestBody JugadorDTO jugadorDTO) throws Exception {
		try {
			return service.save(JugadorMapper.buildJugadorBO(jugadorDTO));
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error al modificar al jugador");
			throw new Exception(ex);
		}
	}

	/***
	 * Delete jugador
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
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
