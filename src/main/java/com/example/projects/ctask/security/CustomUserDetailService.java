package com.example.projects.ctask.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.projects.ctask.Repositories.IUsuarioRepository;
import com.example.projects.ctask.models.Usuario;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private IUsuarioRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario user = repo.findAll()
                .stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities("USER")
                .build();
    }
}
