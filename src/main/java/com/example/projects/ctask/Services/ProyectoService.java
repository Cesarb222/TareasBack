package com.example.projects.ctask.Services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projects.ctask.Repositories.IProyectoRepository;
import com.example.projects.ctask.models.Proyecto;

@Service
public class ProyectoService {

    @Autowired
    private IProyectoRepository proyectoRepository;

    public Proyecto getProyectoByID(UUID idproyecto){
        return proyectoRepository.findById(idproyecto).get();
    }

    public Proyecto addProyecto(Proyecto proyecto){
        return proyectoRepository.save(proyecto);
    }

}
