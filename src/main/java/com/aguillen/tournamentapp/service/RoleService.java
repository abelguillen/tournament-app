package com.aguillen.tournamentapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.aguillen.tournamentapp.dto.RoleDTO;
import com.aguillen.tournamentapp.entity.Role;
import com.aguillen.tournamentapp.mapper.RoleMapper;
import com.aguillen.tournamentapp.repository.RoleRepository;

@Service
@Transactional
public class RoleService {
	
	@Autowired
    private RoleRepository roleRepository;

    public RoleDTO create(Role role) throws Exception {
        try {
        	return RoleMapper.roleToRoleDTO(roleRepository.save(role));
        } catch(Exception ex) {
        	throw new Exception("Ha ocurrido un error al crear el rol", ex);
        }
    }
    
    public RoleDTO update(Role role) throws Exception {
    	if(role.getId() == null) {
        	throw new Exception("No se puede modificar un rol con id nulo");
        }
        try {
        	return RoleMapper.roleToRoleDTO(roleRepository.save(role));
        } catch(Exception ex) {
        	throw new Exception("Ha ocurrido un error al modificar el rol", ex);
        }
    }
    
    public List<RoleDTO> getAll(String sortField, String sortOrder) throws Exception {
		try {
			Direction direction = Direction.fromString(sortOrder);
			return RoleMapper.roleListToRoleDTOList(roleRepository.findAll(Sort.by(direction, sortField)));
		} catch(Exception ex) {
			throw new Exception("Ha ocurrido un error al obtener la lista de roles", ex);
		}
	}
    
    public RoleDTO getById(Long id) throws Exception {
		try {
			return RoleMapper.roleToRoleDTO(roleRepository.findById(id).get());
		} catch(Exception ex) {
			throw new Exception("Ha ocurrido un error al obtener el rol", ex);
		}
	}
    
    public boolean deleteById(Long id) throws Exception {
		try {
			roleRepository.deleteById(id);
			return true;
		} catch(Exception ex) {
			throw new Exception("Ha ocurrido un error al eliminar al rol", ex);
		}
	}

}
