package com.example.datahandling.services;

import com.example.datahandling.dtos.AuthResponse;
import com.example.datahandling.dtos.LoginRequest;
import com.example.datahandling.dtos.SignupRequest;
import com.example.datahandling.entities.User;
import com.example.datahandling.jwt.JwtService;
import com.example.datahandling.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        UserDetails user = userRepository.findByUsername(request.username()).orElseThrow();
        String token = jwtService.getToken(user);
        return new AuthResponse(token);
    }

    public AuthResponse signup(SignupRequest request) {
        User user = User.builder()
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .role(request.role())
                .name(request.name())
                .lastName(request.lastName())
                .phoneNumber(request.phoneNumber())
                .gender(request.gender())
                .country(request.country())
                .createdAt(LocalDate.now())
                .build();

        userRepository.save(user);

        return new AuthResponse(jwtService.getToken(user));
    }
}
