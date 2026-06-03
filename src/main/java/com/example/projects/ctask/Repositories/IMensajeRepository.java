package com.example.projects.ctask.Repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projects.ctask.models.Mensaje;
import com.example.projects.ctask.models.Proyecto;

public interface IMensajeRepository extends JpaRepository<Mensaje,UUID> {
    List<Mensaje> findByProyecto(Proyecto proyecto);
}
