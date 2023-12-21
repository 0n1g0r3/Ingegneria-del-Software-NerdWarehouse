package com.example.NerdWarehouse.services.interfaces;


import com.example.NerdWarehouse.dto.NewUserDto;
import com.example.NerdWarehouse.dto.UserDto;
import com.example.NerdWarehouse.entities.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {

    Collection<? extends GrantedAuthority> getAuthorities();

    void save(User user);

    UserDto findById(Long uId);

    UserDto findByEmail(String email);
    List<User> getAll();

    NewUserDto saveDto(NewUserDto newUserDto);
}
