package com.mvc.SpringMvc.service.impl;

import com.mvc.SpringMvc.entities.Persona;
import com.mvc.SpringMvc.repository.PersonaRepository;
import com.mvc.SpringMvc.service.PersonaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {
    private final PersonaRepository personaRepository;

    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> getAll() {
        return this.personaRepository.findAll();
    }

    @Override
    public Persona getById(Long id) {
        return this.personaRepository.findById(id).orElse(null);
    }

    @Override
    public Persona save(Persona persona) {
        return this.personaRepository.save(persona);
    }

    @Override
    public Persona update(Long id, Persona persona) {
        Persona personaBD = this.personaRepository.findById(id).orElse(null);
        if (personaBD != null){
            personaBD.setNombre(persona.getNombre());
            personaBD.setEdad(persona.getEdad());
            return this.personaRepository.save(personaBD);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        this.personaRepository.deleteById(id);
    }
}
