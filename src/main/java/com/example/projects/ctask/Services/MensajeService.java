package com.example.projects.ctask.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projects.ctask.Repositories.IMensajeRepository;
import com.example.projects.ctask.models.Mensaje;
import com.example.projects.ctask.models.Proyecto;

@Service
public class MensajeService {
    @Autowired
    private IMensajeRepository mensajeRepository;

    public Mensaje addMensaje(Mensaje mensaje){
        return mensajeRepository.save(mensaje);
    }

    public List<Mensaje> getMensajesProyecto(Proyecto proyecto){
        return mensajeRepository.findByProyecto(proyecto);
    }
}
