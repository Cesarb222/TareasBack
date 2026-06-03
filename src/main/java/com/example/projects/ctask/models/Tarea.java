package com.example.projects.ctask.models;


import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tareas")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    @Getter
    @Setter
    private Proyecto proyecto;
    @Column
    @Getter
    @Setter
    private String titulo;
    @Column
    @Getter
    @Setter
    private String descripcion;
    @Column
    @Getter
    @Setter
    private String estado; // ABIERTA, EN_PROGRESO, FINALIZADA
    @Column
    @Getter
    @Setter
    private String prioridad; // BAJA, MEDIA, ALTA

    @ManyToOne
    @JoinColumn(name = "creado_por")
    @Getter
    @Setter
    private Usuario creadoPor;

    @ManyToOne
    @JoinColumn(name = "asignado_a")
    @Getter
    @Setter
    private Usuario asignadoA;
    @Column
    @Getter
    @Setter
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    @Column
    @Getter
    @Setter
    private LocalDateTime fechaLimite;

    
    public Tarea(UUID id, Proyecto proyecto, String titulo, String descripcion, String estado, String prioridad,
            Usuario creadoPor, Usuario asignadoA, LocalDateTime fechaCreacion, LocalDateTime fechaLimite) {
        this.id = id;
        this.proyecto = proyecto;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.prioridad = prioridad;
        this.creadoPor = creadoPor;
        this.asignadoA = asignadoA;
        this.fechaCreacion = fechaCreacion;
        this.fechaLimite = fechaLimite;
    }
    public Tarea(Proyecto proyecto, String titulo, String descripcion, String estado, String prioridad,
            Usuario creadoPor, Usuario asignadoA, LocalDateTime fechaCreacion, LocalDateTime fechaLimite) {
        this.proyecto = proyecto;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.prioridad = prioridad;
        this.creadoPor = creadoPor;
        this.asignadoA = asignadoA;
        this.fechaCreacion = fechaCreacion;
        this.fechaLimite = fechaLimite;
    }
    public Tarea() { }


    
    @Override
    public String toString() {
        return "Tarea [id=" + id + ", proyecto=" + proyecto + ", titulo=" + titulo + ", descripcion=" + descripcion
                + ", estado=" + estado + ", prioridad=" + prioridad + ", creadoPor=" + creadoPor + ", asignadoA="
                + asignadoA + ", fechaCreacion=" + fechaCreacion + ", fechaLimite=" + fechaLimite + "]";
    }

    
}
