package com.example.NerdWarehouse.services;


import com.example.NerdWarehouse.dao.UserDao;
import com.example.NerdWarehouse.dto.NewUserDto;
import com.example.NerdWarehouse.dto.UserDto;
import com.example.NerdWarehouse.entities.User;
import com.example.NerdWarehouse.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Puoi personalizzare la gestione dei ruoli qui
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }


    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public UserDto findById(Long uId) {
        Optional<User> user  = userDao.findById(uId);
        return modelMapper.map(user, UserDto.class);

    }

    @Override
    public UserDto findByEmail(String email) {
        Optional<User> user  = userDao.findUserByEmail(email);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }


    @Override
    public NewUserDto saveDto(NewUserDto newUserDto) {
        User user  = modelMapper.map(newUserDto,User.class);
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10)));
        userDao.save(user);
        return modelMapper.map(user, NewUserDto.class);
    }
}
