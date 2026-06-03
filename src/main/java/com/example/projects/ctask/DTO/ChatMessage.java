package com.example.projects.ctask.DTO;

import java.time.LocalDate;

import com.example.projects.ctask.models.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChatMessage {

    private String mensaje;
    private Usuario usuario;
    private LocalDate fechahora;
}
