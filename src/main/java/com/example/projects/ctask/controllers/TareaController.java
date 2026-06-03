package com.example.projects.ctask.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projects.ctask.Services.ProyectoService;
import com.example.projects.ctask.Services.TareaService;
import com.example.projects.ctask.Services.UsuarioService;
import com.example.projects.ctask.models.Proyecto;
import com.example.projects.ctask.models.Tarea;
import com.example.projects.ctask.models.Usuario;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;





@RestController
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TareaService tareaService;

    @Autowired
    private ProyectoService proyectoService;

    //:.+ sirve para capturar todo siendo asi una regex
    @GetMapping("/{email:.+}")
    private ResponseEntity<?> getAllTareasUser(@PathVariable String email){
        Usuario user = usuarioService.getUsuario(email);
        if(user != null){
            return ResponseEntity.ok(tareaService.tareasUsuario(user));
        }
        return ResponseEntity.status(404).body("Task Not Found with this User");
    }

    @GetMapping("/tarea/{uuid}")
    public ResponseEntity<?> getTareaById(@PathVariable String uuid) {
        Tarea task = tareaService.tareaId(UUID.fromString(uuid));
        if (task != null) return ResponseEntity.ok(task);
        return ResponseEntity.status(404).body("Don't exist task with this ID");
    }

    @PutMapping("/tarea")
    public ResponseEntity<?> updateTarea(@RequestBody Tarea tarea) {
        boolean estado = tareaService.updateTarea(tarea);
        if (estado) return ResponseEntity.ok("Actualizado correctamente");
        else return ResponseEntity.status(404).body("No se pudo actualizar la tarea");
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTarea(@RequestBody Tarea tarea) {
        Tarea tarea2 = tareaService.addTarea(tarea);
        if (tarea2 != null) return ResponseEntity.ok(tarea2);
        else return ResponseEntity.status(404).body("No se pudo actualizar la tarea");
    }
    

    @GetMapping("/proyecto/{proyecto}")
    public ResponseEntity<?> getTareasProyect(@PathVariable String proyecto) {
        Proyecto p = proyectoService.getProyectoByID(UUID.fromString(proyecto));
        if(p!=null){
            List<Tarea> lista = tareaService.getAllTareas(p);
            if(lista != null) return ResponseEntity.ok(lista);
        }  
        return ResponseEntity.status(404).body("No hay tareas para este proyecto");
    }
    
}
