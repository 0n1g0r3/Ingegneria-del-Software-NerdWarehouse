package com.example.NerdWarehouse.dao;

import com.example.NerdWarehouse.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User,Long> {

    @Override
    Optional<User> findById(Long aLong);

    Optional<User> findUserByEmail(String email);

    User findById(User idUser);

}
