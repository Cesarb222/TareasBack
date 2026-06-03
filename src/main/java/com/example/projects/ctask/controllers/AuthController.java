package com.example.projects.ctask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projects.ctask.DTO.Auth.AuthRequestDTO;
import com.example.projects.ctask.DTO.Auth.AuthResponse;
import com.example.projects.ctask.Repositories.IUsuarioRepository;
import com.example.projects.ctask.models.Usuario;
import com.example.projects.ctask.security.JWTUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequestDTO requestDTO) {
        try {
            authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                requestDTO.getEmail(),
                requestDTO.getPassword())
            );

            String token = jwtUtil.generarToken(requestDTO.getEmail());

            System.out.println(token);
            Usuario user = iUsuarioRepository.findByEmail(requestDTO.getEmail()).get();
            if (user != null) {
                AuthResponse ar = new AuthResponse(token, user.getEmail(),user.getId(),user.getNombreUsuario());
                return ResponseEntity.ok(ar);
            }else{
                return ResponseEntity.status(404).body("El usuario no existe");
            }
            
        }catch (UsernameNotFoundException e){
            return ResponseEntity.status(404).body("El usuario no existe");
        }catch (BadCredentialsException e){
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
        
    }    
    
}
