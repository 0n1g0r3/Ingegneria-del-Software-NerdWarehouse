package com.example.NerdWarehouse.controller;


import com.example.NerdWarehouse.dao.UserDao;
import com.example.NerdWarehouse.entities.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "Auth") //Name displayed on swagger
public class AuthController {

    private final UserDao userDao;

    @PostMapping("/login")
    public Object login(HttpServletRequest req, HttpServletResponse resp, @RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        String password = requestBody.get("password");
        //TODO
        System.out.println(email);
        System.out.println(password);
        Optional<User> user = userDao.findUserByEmail(email);
        //System.out.println(user.get());
        if (user.isPresent() && BCrypt.checkpw(password, user.get().getPassword())) {
            Map<String, Object> response = new HashMap<>();
            response.put( "userId", user.get().getId().toString());
            HttpSession session = req.getSession();
            resp.addCookie(new Cookie("sessionId", session.getId()));
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
