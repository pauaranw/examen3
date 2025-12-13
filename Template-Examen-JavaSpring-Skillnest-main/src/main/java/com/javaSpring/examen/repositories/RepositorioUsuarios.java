package com.javaSpring.examen.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javaSpring.examen.models.Usuario;

@Repository
public interface RepositorioUsuarios extends CrudRepository<Usuario,Long> {
    Optional<Usuario> findByCorreo(String correo);
}
