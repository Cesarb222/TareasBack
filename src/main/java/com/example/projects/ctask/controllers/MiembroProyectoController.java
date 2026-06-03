package com.example.projects.ctask.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projects.ctask.Services.MiembrosProyectosService;
import com.example.projects.ctask.Services.ProyectoService;
import com.example.projects.ctask.Services.UsuarioService;
import com.example.projects.ctask.models.MiembrosProyecto;
import com.example.projects.ctask.models.Proyecto;
import com.example.projects.ctask.models.Usuario;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/mp")
public class MiembroProyectoController {

    @Autowired
    private MiembrosProyectosService mProyectosService;

    @Autowired
    private ProyectoService proyectoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/userproyect/{idproyecto}")
    public ResponseEntity<?> getUsersProyect(@PathVariable String idproyecto) {
        Proyecto p = proyectoService.getProyectoByID(UUID.fromString(idproyecto));
        System.out.println(p);
        if (p!=null) {
            List<Usuario> lista = mProyectosService.getUsuariosProyecto(p);
            System.out.println(lista);
            if(lista.size()>0){
                return ResponseEntity.ok(mProyectosService.getUsuariosProyecto(p));
            }else{
                return ResponseEntity.status(404).body("No hay usuarios en este proyecto");
            }
        }
        return ResponseEntity.status(404).body("No se encuentra proyecto con ese ID");
        
        
    }
    

    @GetMapping("/proyectuser/{email:.+}")
    public ResponseEntity<?> getProyectsUser(@PathVariable String email) {
        Usuario user = usuarioService.getUsuario(email);
        if (user!=null) {
            List<Proyecto> lista = mProyectosService.getProyectosUsuario(user);
            if(lista.size()>0){
                return ResponseEntity.ok(lista);
            }else{
                return ResponseEntity.status(404).body("No hay proyectos para este usuario");
            }
        }
        return ResponseEntity.status(404).body("No se encuentra usuario con ese ID");
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> agregarMiembro(@RequestBody MiembrosProyecto mp) {
        MiembrosProyecto miembro = mProyectosService.addMiembroProyecto(mp);
        if (miembro!=null) return ResponseEntity.ok(miembro);
        return ResponseEntity.status(404).body("No se pudo insertar el proyecto");
    }
    
}
