package com.javaSpring.examen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaSpring.examen.models.Pintura;
import com.javaSpring.examen.repositories.RepositorioPinturas;

@Service
public class ServicioPinturas {
    
    @Autowired
    private RepositorioPinturas repositorioPinturas;

    //Crear
    public Pintura creaPintura(Pintura pintura){
        return this.repositorioPinturas.save(pintura);
    }

    //leer
    public List<Pintura> obtenerTodasLasPinturas(){
        return (List<Pintura>) this.repositorioPinturas.findAll();
    }

    public Pintura obtenerPinturaPorId(Long id){
        return this.repositorioPinturas.findById(id).orElse(null);
    }

    //actualizar
    public Pintura actualizarPinturas(Pintura pintura){
        return this.repositorioPinturas.save(pintura);
    }

    //Borrar
    public void eliminarPinturaPorId(Long id){
        this.repositorioPinturas.deleteById(id);
    }
}
