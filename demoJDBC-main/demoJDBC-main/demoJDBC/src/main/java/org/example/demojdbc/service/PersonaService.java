package org.example.demojdbc.service;

import org.example.demojdbc.model.Persona;
import org.example.demojdbc.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    // Constructor de inyección de dependencias
    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    // Obtener todas las personas
    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    // Insertar una persona
    public void addPersona(Persona persona) {
        personaRepository.insert(persona);
    }

    // Eliminar una persona
    public void deletePersona(Persona persona) {
        personaRepository.findByName(String.valueOf(persona));
    }

    // Buscar una persona por nombre
    public Persona getPersonaByName(String nombre) {
        return personaRepository.findByName(nombre);
    }

    // Buscar una persona por ID
    public Persona getPersonaById(int id) {
        return personaRepository.findById(id);
    }
}
