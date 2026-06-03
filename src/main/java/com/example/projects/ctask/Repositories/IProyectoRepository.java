package com.example.projects.ctask.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projects.ctask.models.Proyecto;

public interface IProyectoRepository extends JpaRepository<Proyecto,UUID>{

}
