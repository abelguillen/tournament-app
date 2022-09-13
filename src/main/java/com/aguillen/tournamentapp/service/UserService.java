package com.aguillen.tournamentapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aguillen.tournamentapp.dto.UserDTO;
import com.aguillen.tournamentapp.entity.User;
import com.aguillen.tournamentapp.exceptions.UserAlreadyExistException;
import com.aguillen.tournamentapp.mapper.UserMapper;
import com.aguillen.tournamentapp.repository.UserRepository;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private UserMapper userMapper;

    public UserDTO create(User user) throws Exception {
        if (emailExists(user.getEmail())) {
            throw new UserAlreadyExistException("Ya existe una cuenta con esta email: " + user.getEmail());
        }
        try {
        	user.setPassword(passwordEncoder.encode(user.getPassword()));
        	return userMapper.userToUserDTO(userRepository.save(user));
        } catch(Exception ex) {
        	throw new Exception("Ha ocurrido un error al crear al usuario", ex);
        }
    }
    
    public UserDTO update(User user) throws Exception {
    	User userDB = userRepository.findByEmail(user.getEmail());
        if(user.getId() == null) {
        	throw new Exception("No se puede modificar un usuario con id nulo");
        } else if (userDB.getId() != user.getId()) {
            throw new UserAlreadyExistException("Ya existe una cuenta con este email: " + user.getEmail());
        }
        try {
        	user.setPassword(passwordEncoder.encode(user.getPassword()));
        	return userMapper.userToUserDTO(userRepository.save(user));
        } catch(Exception ex) {
        	throw new Exception("Ha ocurrido un error al modificar al usuario", ex);
        }
    }
    
    public List<UserDTO> getAll(String sortField, String sortOrder) throws Exception {
		try {
			Direction direction = Direction.fromString(sortOrder);
			return userMapper.userListToUserDTOList(userRepository.findAll(Sort.by(direction, sortField)));
		} catch(Exception ex) {
			throw new Exception("Ha ocurrido un error al obtener la lista de usuarios", ex);
		}
	}
    
    public UserDTO getById(Long id) throws Exception {
		try {
			return userMapper.userToUserDTO(userRepository.findById(id).get());
		} catch(Exception ex) {
			throw new Exception("Ha ocurrido un error al obtener al usuario", ex);
		}
	}
    
    public boolean deleteById(Long id) throws Exception {
		try {
			userRepository.deleteById(id);
			return true;
		} catch(Exception ex) {
			throw new Exception("Ha ocurrido un error al eliminar al usuario", ex);
		}
	}
    
    private boolean emailExists(final String email) {
        return userRepository.findByEmail(email) != null;
    }

}
