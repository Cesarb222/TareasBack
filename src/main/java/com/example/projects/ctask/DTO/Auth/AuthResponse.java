package com.example.projects.ctask.DTO.Auth;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {

    private String token;
    private String email;
    private UUID id;
    private String username;

}
