package com.example.datahandling.dtos;

import com.example.datahandling.entities.Role;
import jakarta.validation.constraints.NotNull;

public record SignupRequest(
        @NotNull
        String username,
        @NotNull
        String password,
        @NotNull
        Role role,
        @NotNull
        String name,
        @NotNull
        String lastName,
        @NotNull
        String phoneNumber,
        @NotNull
        String gender,
        @NotNull
        String country
) {
}
