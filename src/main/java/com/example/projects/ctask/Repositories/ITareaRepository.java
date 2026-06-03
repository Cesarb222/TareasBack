package com.example.projects.ctask.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projects.ctask.models.Proyecto;
import com.example.projects.ctask.models.Tarea;
import com.example.projects.ctask.models.Usuario;

import java.util.List;


public interface ITareaRepository extends JpaRepository<Tarea,UUID> {

    List<Tarea> findByAsignadoA(Usuario asignadoA);
    List<Tarea> findByProyecto(Proyecto proyecto);

}
