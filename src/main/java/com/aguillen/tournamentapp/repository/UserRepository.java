package com.aguillen.tournamentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aguillen.tournamentapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @Override
    void delete(User user);

}
