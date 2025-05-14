package org.example.demojdbc.controller;

import org.example.demojdbc.model.Persona;
import org.example.demojdbc.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private final PersonaService personaService;

    // Constructor de inyección de dependencias
    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/")
    public List<Persona> getAllPersonas() {
        return personaService.getAllPersonas();
    }

    @PostMapping("/")
    public void addPersona(@RequestBody Persona persona) {
        personaService.addPersona(persona);
    }

    @DeleteMapping("/")
    public void deletePersona(@RequestBody Persona persona) {
        personaService.deletePersona(persona);
    }

    @GetMapping("/{nombre}")
    public Persona getPersonaByName(@PathVariable String nombre) {
        return personaService.getPersonaByName(nombre);
    }

    @GetMapping("/id/{id}")
    public Persona getPersonaById(@PathVariable int id) {
        return personaService.getPersonaById(id);
    }
}
