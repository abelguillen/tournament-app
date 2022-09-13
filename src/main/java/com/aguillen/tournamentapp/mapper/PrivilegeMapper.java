package com.aguillen.tournamentapp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.aguillen.tournamentapp.dto.PrivilegeDTO;
import com.aguillen.tournamentapp.entity.Privilege;

public class PrivilegeMapper {
	
private static ModelMapper modelMapper = new ModelMapper();
	
	public static PrivilegeDTO privilegeToPrivilegeDTO(Privilege privilege) {
		return modelMapper.map(privilege, PrivilegeDTO.class);
	}
	
	public static Privilege privilegeDTOToPrivilege(PrivilegeDTO privilegeDTO) {
		return modelMapper.map(privilegeDTO, Privilege.class);
	}
	
	public static List<PrivilegeDTO> privilegeListToPrivilegeDTOList(List<Privilege> privileges) {
		List<PrivilegeDTO> privilegesDTO = new ArrayList<PrivilegeDTO>();
		try {
			for(Privilege privilege : privileges) {
				privilegesDTO.add(privilegeToPrivilegeDTO(privilege));
			}
			return privilegesDTO;
		} catch(Exception ex) {
			return privilegesDTO;
		}
	}

}
