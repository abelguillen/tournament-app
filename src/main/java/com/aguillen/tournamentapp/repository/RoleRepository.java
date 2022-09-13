package com.aguillen.tournamentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aguillen.tournamentapp.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

    @Override
    void delete(Role role);

}
