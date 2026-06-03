package com.example.projects.ctask.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projects.ctask.Services.UsuarioService;
import com.example.projects.ctask.models.Usuario;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;







@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody Usuario user) {
        Usuario respuesta = usuarioService.addUser(user);
        if(respuesta != null) return ResponseEntity.ok(true);
        else return ResponseEntity.status(400).body(false);
    }
    
    @GetMapping("/{email:.+}")
    public ResponseEntity<?> getUserEmail(@PathVariable String email){
        Usuario user = usuarioService.getUsuario(email);
        if(user != null){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(404).body("Task Not Found with this User");
    }
    
    @GetMapping("/find/{name}")
    public ResponseEntity<?> getUserName(@PathVariable String name){
        System.out.println(name);
        Usuario user = usuarioService.getUsuarioByName(name);
        if(user != null){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(404).body("Task Not Found with this User");
    }

    @PutMapping("/edit")
    public ResponseEntity<?> updateUser(@RequestBody Usuario user) {
        Usuario respuesta = usuarioService.updateUser(user);
        if(respuesta != null) return ResponseEntity.ok(respuesta);
        else return ResponseEntity.status(400).body(false);
    }
}
