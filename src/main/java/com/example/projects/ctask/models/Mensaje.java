package com.example.projects.ctask.models;


import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "mensajes")
public class Mensaje implements Comparable<Mensaje>{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "proyecto", nullable = true)
    @Getter
    @Setter
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @Getter
    @Setter
    private Usuario usuario;

    @Column(nullable = false)
    @Getter
    @Setter
    private String contenido;

    @Column(name = "fecha_creacion")
    @Getter
    @Setter
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    public Mensaje(UUID id, Proyecto proyecto, Usuario usuario, String contenido, String tipoMensaje,
            LocalDateTime fechaCreacion) {
        this.id = id;
        this.proyecto = proyecto;
        this.usuario = usuario;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
    }

    public Mensaje(Proyecto proyecto, Usuario usuario, String contenido, String tipoMensaje, LocalDateTime fechaCreacion) {
        this.proyecto = proyecto;
        this.usuario = usuario;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
    }

    public Mensaje() {
    }

    

    @Override
    public String toString() {
        return "Mensaje [id=" + id + ", tarea=" + ", usuario=" + usuario + ", contenido=" + contenido
                + ", tipoMensaje=" +  ", fechaCreacion=" + fechaCreacion + "]";
    }

    @Override
    public int compareTo(Mensaje mensaje) {
        return this.fechaCreacion.compareTo(mensaje.fechaCreacion);
    }


}
