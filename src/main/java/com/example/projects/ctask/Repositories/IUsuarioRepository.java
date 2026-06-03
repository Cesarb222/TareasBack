package com.example.projects.ctask.Repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.projects.ctask.models.Usuario;
import java.util.List;



public interface IUsuarioRepository extends JpaRepository<Usuario,UUID> {

    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    Optional<Usuario> findByEmail(@Param("email") String email);

    Optional<Usuario> findByNombreUsuario(String nombreUsuario);

}
