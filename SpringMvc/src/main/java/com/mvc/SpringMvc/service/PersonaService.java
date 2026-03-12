package com.mvc.SpringMvc.service;

import com.mvc.SpringMvc.entities.Persona;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PersonaService {

    List<Persona> getAll();

    Persona getById(Long id);

    Persona save(Persona persona);

    Persona update(Long id, Persona persona);

    void delete(Long id);
}
