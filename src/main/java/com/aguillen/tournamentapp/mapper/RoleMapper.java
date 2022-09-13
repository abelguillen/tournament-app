package com.aguillen.tournamentapp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.aguillen.tournamentapp.dto.RoleDTO;
import com.aguillen.tournamentapp.entity.Privilege;
import com.aguillen.tournamentapp.entity.Role;

public class RoleMapper {

private static ModelMapper modelMapper = new ModelMapper();
	
	public static RoleDTO roleToRoleDTO(Role role) {
		RoleDTO roleDTO= modelMapper.map(role, RoleDTO.class);
		roleDTO.setPrivilegeList(PrivilegeMapper.privilegeListToPrivilegeDTOList((List<Privilege>) role.getPrivileges()));
		return roleDTO;
	}
	
	public static Role roleDTOToRole(RoleDTO roleDTO) {
		return modelMapper.map(roleDTO, Role.class);
	}
	
	public static List<RoleDTO> roleListToRoleDTOList(List<Role> roles) {
		List<RoleDTO> rolesDTO = new ArrayList<RoleDTO>();
		for(Role role : roles) {
			rolesDTO.add(roleToRoleDTO(role));
		}
		return rolesDTO;
	}
}
