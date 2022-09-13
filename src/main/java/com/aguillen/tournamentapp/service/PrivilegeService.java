package com.aguillen.tournamentapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.aguillen.tournamentapp.dto.PrivilegeDTO;
import com.aguillen.tournamentapp.entity.Privilege;
import com.aguillen.tournamentapp.mapper.PrivilegeMapper;
import com.aguillen.tournamentapp.repository.PrivilegeRepository;

@Service
@Transactional
public class PrivilegeService {

	@Autowired
	private PrivilegeRepository privilegeRepository;
	
	public PrivilegeDTO create(Privilege privilege) throws Exception {
        try {
        	return PrivilegeMapper.privilegeToPrivilegeDTO(privilegeRepository.save(privilege));
        } catch(Exception ex) {
        	throw new Exception("Ha ocurrido un error al crear el privilegio", ex);
        }
    }
	
	public PrivilegeDTO update(Privilege privilege) throws Exception {
		if(privilege.getId() == null) {
        	throw new Exception("No se puede modificar un privilegio con id nulo");
        }
        try {
        	return PrivilegeMapper.privilegeToPrivilegeDTO(privilegeRepository.save(privilege));
        } catch(Exception ex) {
        	throw new Exception("Ha ocurrido un error al modificar el privilegio", ex);
        }
    }
    
    public List<PrivilegeDTO> getAll(String sortField, String sortOrder) throws Exception {
		try {
			Direction direction = Direction.fromString(sortOrder);
			return PrivilegeMapper.privilegeListToPrivilegeDTOList(privilegeRepository.findAll(Sort.by(direction, sortField)));
		} catch(Exception ex) {
			throw new Exception("Ha ocurrido un error al obtener la lista de privilegios", ex);
		}
	}
    
    public PrivilegeDTO getById(Long id) throws Exception {
		try {
			return PrivilegeMapper.privilegeToPrivilegeDTO(privilegeRepository.findById(id).get());
		} catch(Exception ex) {
			throw new Exception("Ha ocurrido un error al obtener el privilegio", ex);
		}
	}
    
    public boolean deleteById(Long id) throws Exception {
		try {
			privilegeRepository.deleteById(id);
			return true;
		} catch(Exception ex) {
			throw new Exception("Ha ocurrido un error al eliminar el privilegio", ex);
		}
	}
	
}
