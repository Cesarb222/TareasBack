package com.example.projects.ctask.models;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "proyectos")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    private UUID id;

    @Column
    @Getter
    @Setter
    private String nombre;

    @Column
    @Getter
    @Setter
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "propietario_id")
    @Getter
    @Setter
    private Usuario propietario;

    @Column
    @Getter
    @Setter
    private LocalDateTime fechaCreacion = LocalDateTime.now();


    @Column(name = "foto",nullable = true,columnDefinition = "TEXT")
    @Getter
    @Setter
    private String foto;
    public Proyecto() { }


    public Proyecto(UUID id, String nombre, String descripcion, Usuario propietario, LocalDateTime fechaCreacion,String foto) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.propietario = propietario;
        this.fechaCreacion = fechaCreacion;
        this.foto = foto;
    }


    public Proyecto(String nombre, String descripcion, Usuario propietario, LocalDateTime fechaCreacion,String foto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.propietario = propietario;
        this.fechaCreacion = fechaCreacion;
        this.foto = foto;
    }


    @Override
    public String toString() {
        return "Proyecto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", propietario="
                + propietario + ", fechaCreacion=" + fechaCreacion + "]";
    }


}
