package com.example.datahandling.services.impl;

import com.example.datahandling.entities.Role;
import com.example.datahandling.entities.User;
import com.example.datahandling.repositories.UserRepository;
import com.example.datahandling.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findByRole(Role role) {
        return userRepository.findByRole(role);
    }

//    @Override
//    public List<User> findByQuestionDate(LocalDate start, LocalDate end) {
//        return null;
//    }
}
