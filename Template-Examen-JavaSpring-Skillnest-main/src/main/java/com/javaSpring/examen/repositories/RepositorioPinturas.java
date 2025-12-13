package com.javaSpring.examen.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javaSpring.examen.models.Pintura;

@Repository
public interface RepositorioPinturas extends CrudRepository<Pintura, Long> {
    
}
