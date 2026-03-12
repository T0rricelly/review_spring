package com.mvc.SpringMvc.controller;

import com.mvc.SpringMvc.entities.Persona;
import com.mvc.SpringMvc.service.PersonaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/api/persona")
public class PersonaController {
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public String getAll(Model model){
        List<Persona> personas = this.personaService.getAll();
        model.addAttribute("personasLista", personas);
        return "persona";
    }
}
