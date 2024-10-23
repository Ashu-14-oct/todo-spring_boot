package com.todo.springapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.springapp.dto.AuthResponse;
import com.todo.springapp.dto.UserDTO;
import com.todo.springapp.entity.AppUser;
import com.todo.springapp.services.UserService;
import com.todo.springapp.utils.JwtUtil;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody UserDTO userDTO){
        AppUser user = new AppUser(userDTO.getUsername(), userDTO.getPassword(), userDTO.getEmail());
        userService.signup(user);
        return ResponseEntity.ok("User signed up successfully!");
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signIn(@RequestBody UserDTO userDTO){
        AppUser user = userService.signIn(userDTO.getUsername());
        if(user != null && new BCryptPasswordEncoder().matches(userDTO.getPassword(), user.getPassword())){
            String token = jwtUtil.generateToken(userDTO.getUsername());
            return ResponseEntity.ok(new AuthResponse(token));
        }

        return ResponseEntity.status(401).body(null);
    }
}
