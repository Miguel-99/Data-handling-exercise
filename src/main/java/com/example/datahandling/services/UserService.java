package com.example.datahandling.services;

import com.example.datahandling.entities.Role;
import com.example.datahandling.entities.User;

import java.util.List;

public interface UserService {
    List<User> findByRole(Role role);
//    List<User> findByQuestionDate(LocalDate start, LocalDate end);
}
