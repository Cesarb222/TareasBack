package com.example.projects.ctask.models;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "adjuntos")
public class Adjunto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "mensaje_id")
    private Mensaje mensaje;

    @Column
    @Getter
    @Setter
    private String urlArchivo;

    @Column
    @Getter
    @Setter
    private String nombreArchivo;

    @Column
    @Getter
    @Setter
    private LocalDateTime fechaSubida = LocalDateTime.now();

    public Adjunto(UUID id, Mensaje mensaje, String urlArchivo, String nombreArchivo, LocalDateTime fechaSubida) {
        this.id = id;
        this.mensaje = mensaje;
        this.urlArchivo = urlArchivo;
        this.nombreArchivo = nombreArchivo;
        this.fechaSubida = fechaSubida;
    }

    public Adjunto(Mensaje mensaje, String urlArchivo, String nombreArchivo, LocalDateTime fechaSubida) {
        this.mensaje = mensaje;
        this.urlArchivo = urlArchivo;
        this.nombreArchivo = nombreArchivo;
        this.fechaSubida = fechaSubida;
    }

    public Adjunto() { }

    @Override
    public String toString() {
        return "Adjunto [id=" + id + ", mensaje=" + mensaje + ", urlArchivo=" + urlArchivo + ", nombreArchivo="
                + nombreArchivo + ", fechaSubida=" + fechaSubida + "]";
    }

    
}
