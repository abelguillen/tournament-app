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
import com.aguillen.tournamentapp.dto.UserDTO;
import com.aguillen.tournamentapp.mapper.UserMapper;
import com.aguillen.tournamentapp.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	final static Logger LOG = LoggerFactory.getLogger(TournamentApplication.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private UserMapper userMapper;
	
	@GetMapping("list")
	public List<UserDTO> getAll(@RequestParam(value="sort_field", required=false, defaultValue = "lastName") String sortField,
								@RequestParam(value="sort_order", required=false, defaultValue = "ASC") String sortOrder) throws Exception {
		try {
			return userService.getAll(sortField, sortOrder);
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error al obtener la lista de usuarios");
			throw new Exception(ex);
		}
	}
	
	@GetMapping("/{id}")
	public UserDTO getById(@PathVariable("id") Long id) throws Exception {
		try {
			return userService.getById(id);
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error al obtener al usuario");
			throw new Exception(ex);
		}
	}
	
	@PostMapping("/create")
	public UserDTO create(@RequestBody UserDTO userDTO) throws Exception {
		try {
			return userService.create(userMapper.userDTOToUser((userDTO)));
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error al crear al usuario");
			throw new Exception(ex);
		}
	}
	
	@PutMapping("/update")
	public UserDTO update(@RequestBody UserDTO userDTO) throws Exception {
		try {
			return userService.update(userMapper.userDTOToUser(userDTO));
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error al modificar al jugador");
			throw new Exception(ex);
		}
	}
	
	@DeleteMapping("/delete")
	public boolean deleteById(@RequestParam("id") Long id) throws Exception {
		try {
			return userService.deleteById(id);
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error al eliminar al jugador");
			throw new Exception(ex);
		}
	}
	
}
