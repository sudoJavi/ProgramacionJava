package org.example.demojdbc.repository;

import org.example.demojdbc.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonaRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Obtener todas las personas
    public List<Persona> findAll() {
        String sql = "SELECT * FROM persona";  // consulta SQL
        return jdbcTemplate.query(sql, new PersonaMapper());  // Usamos el PersonaMapper
    }

    // Insertar una nueva persona
    public int insert(Persona persona) {
        String sql = "INSERT INTO persona (nombre, apellidos, edad) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, persona.getNombre(), persona.getApellidos(), persona.getEdad());
    }

    // Eliminar una persona por id
    public int delete(int id) {
        String sql = "DELETE FROM persona WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    // Buscar una persona por id
    public Persona findById(int id) {
        String sql = "SELECT * FROM persona WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new PersonaMapper(), id);  // devuelve una sola persona
    }

    // Buscar una persona por nombre (o cualquier otro criterio que desees)
    public Persona findByName(String nombre) {
        String sql = "SELECT * FROM persona WHERE nombre = ?";
        return jdbcTemplate.queryForObject(sql, new PersonaMapper(), nombre);  // devuelve una sola persona
    }
}
