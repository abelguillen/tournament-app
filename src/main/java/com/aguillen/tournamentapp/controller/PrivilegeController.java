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
import com.aguillen.tournamentapp.dto.PrivilegeDTO;
import com.aguillen.tournamentapp.mapper.PrivilegeMapper;
import com.aguillen.tournamentapp.service.PrivilegeService;

@RestController
@RequestMapping(value = "/privilege")
public class PrivilegeController {

final static Logger LOG = LoggerFactory.getLogger(TournamentApplication.class);
	
	@Autowired
	private PrivilegeService privilegeService;
	
	@GetMapping("list")
	public List<PrivilegeDTO> getAll(@RequestParam(value="sort_field", required=false, defaultValue = "name") String sortField,
								@RequestParam(value="sort_order", required=false, defaultValue = "ASC") String sortOrder) throws Exception {
		try {
			return privilegeService.getAll(sortField, sortOrder);
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error al obtener la lista de privilegios");
			throw new Exception(ex);
		}
	}
	
	@GetMapping("/{id}")
	public PrivilegeDTO getById(@PathVariable("id") Long id) throws Exception {
		try {
			return privilegeService.getById(id);
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error al obtener el privilegio");
			throw new Exception(ex);
		}
	}
	
	@PostMapping("/create")
	public PrivilegeDTO create(@RequestBody PrivilegeDTO privilegeDTO) throws Exception {
		try {
			return privilegeService.create(PrivilegeMapper.privilegeDTOToPrivilege((privilegeDTO)));
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error al crear el privilegio");
			throw new Exception(ex);
		}
	}
	
	@PutMapping("/update")
	public PrivilegeDTO update(@RequestBody PrivilegeDTO privilegeDTO) throws Exception {
		try {
			return privilegeService.update(PrivilegeMapper.privilegeDTOToPrivilege(privilegeDTO));
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error al modificar el privilegio");
			throw new Exception(ex);
		}
	}
	
	@DeleteMapping("/delete")
	public boolean deleteById(@RequestParam("id") Long id) throws Exception {
		try {
			return privilegeService.deleteById(id);
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error al eliminar el privilegio");
			throw new Exception(ex);
		}
	}
}
