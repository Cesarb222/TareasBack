package com.example.projects.ctask.controllers.WebSocket;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.projects.ctask.DTO.ChatMessage;
import com.example.projects.ctask.Services.MensajeService;
import com.example.projects.ctask.Services.ProyectoService;
import com.example.projects.ctask.models.Mensaje;
import com.example.projects.ctask.models.Proyecto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WebSokectController {

    @Autowired
    private MensajeService mensajeService;

    @Autowired 
    private ProyectoService proyectoService;

    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public Mensaje chat(@DestinationVariable String roomId, Mensaje message){
        System.out.println(message.toString());
        //return new ChatMessage(message.getMensaje(), message.getUsuario(),message.getFechahora());
        return mensajeService.addMensaje(message);
    }

    @GetMapping("/mensajes/{idProyecto}")
    public ResponseEntity<?> getMensajes(@PathVariable String idProyecto) {
        Proyecto p = proyectoService.getProyectoByID(UUID.fromString(idProyecto));
        if(p == null) return ResponseEntity.status(404).body("No se encuentra el proyecto");
        List<Mensaje> listMensajes = mensajeService.getMensajesProyecto(p);
        if(listMensajes == null) return ResponseEntity.ok("No hay datos");
        listMensajes.sort(null);
        return ResponseEntity.ok(listMensajes);
    }
    
}
