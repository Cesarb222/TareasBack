package com.example.projects.ctask.Services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projects.ctask.Repositories.IUsuarioRepository;
import com.example.projects.ctask.models.Usuario;

import at.favre.lib.crypto.bcrypt.BCrypt;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository userRepository;

    public Usuario addUser(Usuario user){
        try {
            String hash = BCrypt.withDefaults().hashToString(12,user.getPassword().toCharArray());
            //seteamos la contraseña
            user.setPassword(hash);
            return userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Usuario updateUser(Usuario user){
        return userRepository.save(user);
    }

    public Usuario getUsuario(String email){
        return userRepository.findByEmail(email).get();
    }

    public Usuario getUsuarioByName(String name){
    return userRepository.findByNombreUsuario(name)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado con nombre: " + name));
}
    
    public Usuario getUsuarioByUUID(UUID idUsuario){
        return userRepository.findById(idUsuario).get();
    }

}
