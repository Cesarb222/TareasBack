package com.example.projects.ctask.models;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "mensajes_leidos")
public class MensajeLeido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "mensaje_id")
    @Getter
    @Setter
    private Mensaje mensaje;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @Getter
    @Setter
    private Usuario usuario;

    @Column
    @Getter
    @Setter
    private LocalDateTime fechaLectura = LocalDateTime.now();


    public MensajeLeido(UUID id, Mensaje mensaje, Usuario usuario, LocalDateTime fechaLectura) {
        this.id = id;
        this.mensaje = mensaje;
        this.usuario = usuario;
        this.fechaLectura = fechaLectura;
    }

    public MensajeLeido(Mensaje mensaje, Usuario usuario, LocalDateTime fechaLectura) {
        this.mensaje = mensaje;
        this.usuario = usuario;
        this.fechaLectura = fechaLectura;
    }

    public MensajeLeido() { }


    @Override
    public String toString() {
        return "MensajeLeido [id=" + id + ", mensaje=" + mensaje + ", usuario=" + usuario + ", fechaLectura="
                + fechaLectura + "]";
    }
    
}
