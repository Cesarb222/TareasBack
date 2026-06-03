package com.example.projects.ctask.controllers;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projects.ctask.Services.MiembrosProyectosService;
import com.example.projects.ctask.Services.ProyectoService;
import com.example.projects.ctask.models.MiembrosProyecto;
import com.example.projects.ctask.models.Proyecto;
import com.example.projects.ctask.models.Usuario;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/proyecto")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @Autowired
    private MiembrosProyectosService mpService;

    @PostMapping("/add")
    private ResponseEntity<?> addProyecto(@RequestBody Proyecto proyecto){
        Proyecto p = proyectoService.addProyecto(proyecto);
        if(p != null){
            mpService.addMiembroProyecto(new MiembrosProyecto(p.getPropietario(), p, "null", LocalDateTime.now()));
            return ResponseEntity.ok(p);
        } 
        return ResponseEntity.status(404).body("No se pudo insertar el proyecto");
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProyect(@RequestBody Proyecto proyecto) {
        Proyecto p = proyectoService.addProyecto(proyecto);
        if(p != null) return ResponseEntity.ok(p);
        return ResponseEntity.status(404).body("No se pudo insertar el proyecto");
    }

    @GetMapping("/{idproyecto}")
    public ResponseEntity<?> getMethodName(@PathVariable String idproyecto) {
        Proyecto p = proyectoService.getProyectoByID(UUID.fromString(idproyecto));
        if (p!=null) return ResponseEntity.ok(p);
        else return ResponseEntity.status(404).body("No existe proyecto con esa id");
    }
    
}
