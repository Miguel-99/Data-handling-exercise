package com.example.datahandling.controllers;

import com.example.datahandling.entities.Role;
import com.example.datahandling.entities.User;
import com.example.datahandling.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    List<User> usersByRole(@RequestParam("role") Role role) {
    return userService.findByRole(role);
}

//    @GetMapping
//    List<User> usersByQuestionDate(@RequestParam("start") LocalDate start, @RequestParam("end") LocalDate end) {
//        return userService.findByQuestionDate(start, end);
//    }
}
