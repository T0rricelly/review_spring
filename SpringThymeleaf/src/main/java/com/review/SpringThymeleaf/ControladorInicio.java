package com.review.SpringThymeleaf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ejecutando el controlador spring mvc");
        String mensaje = "Mensaje con thymeleaf";
        model.addAttribute("mensaje", mensaje);
        return "index";
    }
}
