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
import com.aguillen.tournamentapp.dto.RoleDTO;
import com.aguillen.tournamentapp.mapper.RoleMapper;
import com.aguillen.tournamentapp.service.RoleService;

@RestController
@RequestMapping(value = "/role")
public class RoleController {

final static Logger LOG = LoggerFactory.getLogger(TournamentApplication.class);
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("list")
	public List<RoleDTO> getAll(@RequestParam(value="sort_field", required=false, defaultValue = "name") String sortField,
								@RequestParam(value="sort_order", required=false, defaultValue = "ASC") String sortOrder) throws Exception {
		try {
			return roleService.getAll(sortField, sortOrder);
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error al obtener la lista de roles");
			throw new Exception(ex);
		}
	}
	
	@GetMapping("/{id}")
	public RoleDTO getById(@PathVariable("id") Long id) throws Exception {
		try {
			return roleService.getById(id);
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error al obtener al rol");
			throw new Exception(ex);
		}
	}
	
	@PostMapping("/create")
	public RoleDTO create(@RequestBody RoleDTO roleDTO) throws Exception {
		try {
			return roleService.create(RoleMapper.roleDTOToRole((roleDTO)));
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error al crear al rol");
			throw new Exception(ex);
		}
	}
	
	@PutMapping("/update")
	public RoleDTO update(@RequestBody RoleDTO roleDTO) throws Exception {
		try {
			return roleService.update(RoleMapper.roleDTOToRole(roleDTO));
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error al modificar al rol");
			throw new Exception(ex);
		}
	}
	
	@DeleteMapping("/delete")
	public boolean deleteById(@RequestParam("id") Long id) throws Exception {
		try {
			return roleService.deleteById(id);
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error al eliminar al rol");
			throw new Exception(ex);
		}
	}
}
