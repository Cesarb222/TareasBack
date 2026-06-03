package com.example.projects.ctask.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projects.ctask.Repositories.IMiembroProyecto;
import com.example.projects.ctask.models.MiembrosProyecto;
import com.example.projects.ctask.models.Proyecto;
import com.example.projects.ctask.models.Usuario;

@Service
public class MiembrosProyectosService {

    @Autowired
    private IMiembroProyecto miembroProyecto;

    public List<Usuario> getUsuariosProyecto(Proyecto proyecto){
        return miembroProyecto.findByProyecto(proyecto).stream().map(MiembrosProyecto::getUsuario).collect(Collectors.toList());
    }
    public List<Proyecto> getProyectosUsuario(Usuario usuario){
        return miembroProyecto.findByUsuario(usuario).stream().map(MiembrosProyecto::getProyecto).collect(Collectors.toList());
    }

    public MiembrosProyecto addMiembroProyecto(MiembrosProyecto mp){
        return miembroProyecto.save(mp);
    }
}
