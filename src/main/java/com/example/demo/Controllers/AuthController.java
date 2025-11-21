package com.example.demo.Controllers;

import com.example.demo.Dtos.LoginRequest;
import com.example.demo.Dtos.RegisterRequest;
import com.example.demo.Services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest registerRequest){
        return authService.register(registerRequest);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest){
        return authService.login(loginRequest);
    }
}
