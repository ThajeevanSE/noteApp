package com.example.demo.Services;

import com.example.demo.Dtos.LoginRequest;
import com.example.demo.Dtos.RegisterRequest;
import com.example.demo.Entities.User;
import com.example.demo.Repositories.userRepository;
import lombok.Data;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Data
@Service
public class AuthService {
    private final userRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String register(RegisterRequest registerRequest) {
        if(userRepository.findByUsername(registerRequest.getUsername()).isPresent()){
            return "Username is already taken!";
        }
        User user=User.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(registerRequest.getRole())
                .build();

userRepository.save(user);
return "User registered successfully!";


    }
    public String login(LoginRequest loginRequest) {
        User user=userRepository.findByUsername(loginRequest.getUsername()).orElse(null);
        if(user==null){
            return "User not found!";
        }
        if(!passwordEncoder.matches(loginRequest.getPassword(),user.getPassword())){
            return "Passwords do not match!";
        }
        return "Logged in successfully!";
    }

}
