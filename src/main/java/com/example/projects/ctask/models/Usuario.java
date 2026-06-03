package com.example.projects.ctask.models;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    private UUID id;

    @Column(name = "nombre_usuario", unique = true, nullable = false)
    @Getter
    @Setter
    private String nombreUsuario;

    @Column(unique = true, nullable = false)
    @Getter
    @Setter
    private String email;

    @Column(nullable = false)
    @Getter
    @Setter
    private String password;

    @Column(name = "fecha_creacion")
    @Getter
    @Setter
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    
    @Column(name = "foto",nullable = true,columnDefinition = "TEXT")
    @Getter
    @Setter
    private String foto;

    public Usuario(UUID id, String nombreUsuario, String email, String password, LocalDateTime fechaCreacion,String foto) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.fechaCreacion = fechaCreacion;
        this.foto = foto;
    }

    public Usuario(String nombreUsuario, String email, String password, LocalDateTime fechaCreacion,String foto) {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.foto = foto;
        this.fechaCreacion = fechaCreacion;
    }
    public Usuario(String nombreUsuario, String email, String password) {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
    }

    public Usuario() { }


    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombreUsuario=" + nombreUsuario + ", email=" + email + ", password=" + password
                + ", fechaCreacion=" + fechaCreacion + "]";
    }

    

}