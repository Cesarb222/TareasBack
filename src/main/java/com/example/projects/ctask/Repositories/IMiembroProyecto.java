package com.example.projects.ctask.Repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.projects.ctask.models.MiembrosProyecto;
import com.example.projects.ctask.models.Proyecto;
import com.example.projects.ctask.models.Usuario;

public interface IMiembroProyecto extends JpaRepository<MiembrosProyecto,UUID>{
    List<MiembrosProyecto> findByProyecto(Proyecto proyecto);

    List<MiembrosProyecto> findByUsuario(Usuario usuario);
}
