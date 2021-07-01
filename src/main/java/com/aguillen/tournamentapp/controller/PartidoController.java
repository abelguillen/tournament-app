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
import com.aguillen.tournamentapp.dto.PartidoDTO;
import com.aguillen.tournamentapp.mapper.PartidoMapper;
import com.aguillen.tournamentapp.model.PartidoResponse;
import com.aguillen.tournamentapp.service.PartidoService;

@RestController
@RequestMapping(value = "/partido")
public class PartidoController {

	final static Logger LOG = LoggerFactory.getLogger(TournamentApplication.class);

	@Autowired
	private PartidoService service;

	/***
	 * List partido
	 * 
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/list")
	public List<PartidoResponse> getAll(@RequestParam(value="sort_field", required=false, defaultValue = "nroPartido") String sortField,
            @RequestParam(value="sort_order", required=false, defaultValue = "ASC") String sortOrder) throws Exception {
		try {
			return service.getAll(sortField, sortOrder);
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error al obtener la lista de partidoes");
			throw new Exception(ex);
		}
	}

	/***
	 * GetById partido
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public PartidoResponse getOne(@PathVariable("id") Integer id) throws Exception {
		try {
			return service.getOne(id);
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error al obtener al partido");
			throw new Exception(ex);
		}
	}

	/***
	 * Create partido
	 * 
	 * @param partidoDTO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/create")
	public PartidoResponse create(@RequestBody PartidoDTO partidoDTO) throws Exception {
		try {
			return service.create(PartidoMapper.buildPartidoBO(partidoDTO), PartidoMapper.buildEquiposBO(partidoDTO));
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error al crear el partido");
			throw new Exception(ex);
		}
	}

	/***
	 * Update partido
	 * 
	 * @param partidoDTO
	 * @return
	 * @throws Exception
	 */
	@PutMapping("/update")
	public PartidoDTO update(@RequestBody PartidoDTO partidoDTO) throws Exception {
		try {
			return service.update(PartidoMapper.buildPartidoBO(partidoDTO));
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error al modificar al partido");
			throw new Exception(ex);
		}
	}

	/***
	 * Delete partido
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
			LOG.error("Ha ocurrido un error al eliminar al partido");
			throw new Exception(ex);
		}
	}

}
