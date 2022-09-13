package com.aguillen.tournamentapp.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aguillen.tournamentapp.dto.PrivilegeDTO;
import com.aguillen.tournamentapp.dto.RoleDTO;
import com.aguillen.tournamentapp.dto.UserDTO;
import com.aguillen.tournamentapp.entity.Privilege;
import com.aguillen.tournamentapp.entity.Role;
import com.aguillen.tournamentapp.entity.User;
import com.aguillen.tournamentapp.repository.RoleRepository;

@Component
public class UserMapper {

	@Autowired
	private RoleRepository roleRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public UserDTO userToUserDTO(User user) {
		UserDTO userDTO = modelMapper.map(user, UserDTO.class);
		List<Role> roles = (List<Role>) user.getRoles();
		Long roleId = roles.get(0).getId();
		String roleName = roles.get(0).getName();
		List<PrivilegeDTO> privilegesDTOList = PrivilegeMapper.privilegeListToPrivilegeDTOList((List<Privilege>) roles.get(0).getPrivileges());
		RoleDTO roleDTO = new RoleDTO(roleId, roleName, privilegesDTOList);
		userDTO.setRoleDTO(roleDTO);
		return userDTO;
	}

	public User userDTOToUser(UserDTO userDTO) {
		User user = modelMapper.map(userDTO, User.class);
		Role role = roleRepository.findById(userDTO.getRoleDTO().getId()).get();
		user.setRoles(Arrays.asList(role));
		return user;
	}
	
	public List<UserDTO> userListToUserDTOList(List<User> users) {
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		for(User user : users) {
			usersDTO.add(userToUserDTO(user));
		}
		return usersDTO;
	}
	
}
