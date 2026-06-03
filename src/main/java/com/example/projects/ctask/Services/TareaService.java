package com.example.projects.ctask.Services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projects.ctask.Repositories.ITareaRepository;
import com.example.projects.ctask.models.Proyecto;
import com.example.projects.ctask.models.Tarea;
import com.example.projects.ctask.models.Usuario;

@Service
public class TareaService {

    @Autowired
    private ITareaRepository tareaRepository;

    public List<Tarea> tareasUsuario(Usuario usuario){
        return tareaRepository.findByAsignadoA(usuario);
    }

    public Tarea tareaId(UUID idTarea){
        return tareaRepository.findById(idTarea).orElse(null);
    }

    public Boolean updateTarea(Tarea tarea){
        if (tareaRepository.existsById(tarea.getId())) {
            tareaRepository.save(tarea);
            return true;
        }
        return false;
    }

    public Tarea addTarea(Tarea tarea){
        return tareaRepository.save(tarea);
    }

    public List<Tarea> getAllTareas(Proyecto proyecto){
        return tareaRepository.findByProyecto(proyecto);
    }
}
