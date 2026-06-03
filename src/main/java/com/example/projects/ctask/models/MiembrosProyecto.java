package com.example.projects.ctask.models;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "miembros_proyecto")
public class MiembrosProyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @Getter
    @Setter
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    @Getter
    @Setter
    private Proyecto proyecto;

    @Column
    @Getter
    @Setter
    private String rol;
    @Column
    @Getter
    @Setter
    private LocalDateTime fechaUnion = LocalDateTime.now();
    
    public MiembrosProyecto() { }

    public MiembrosProyecto(UUID id, Usuario usuario, Proyecto proyecto, String rol, LocalDateTime fechaUnion) {
        this.id = id;
        this.usuario = usuario;
        this.proyecto = proyecto;
        this.rol = rol;
        this.fechaUnion = fechaUnion;
    }

    public MiembrosProyecto(Usuario usuario, Proyecto proyecto, String rol, LocalDateTime fechaUnion) {
        this.usuario = usuario;
        this.proyecto = proyecto;
        this.rol = rol;
        this.fechaUnion = fechaUnion;
    }



    @Override
    public String toString() {
        return "MiembrosProyecto [id=" + id + ", usuario=" + usuario + ", proyecto=" + proyecto + ", rol=" + rol
                + ", fechaUnion=" + fechaUnion + "]";
    }

    
}
