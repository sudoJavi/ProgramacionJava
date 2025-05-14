package org.example.demojdbc;

import org.example.demojdbc.model.Persona;
import org.example.demojdbc.model.Producto;
import org.example.demojdbc.repository.PersonaRepository;
import org.example.demojdbc.repository.ProductoRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DemoJdbcTest {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private PersonaRepository personaRepository;

    private static int productoId;
    private static int personaId;

    @Test
    @Order(1)
    void testInsertProducto() {
        Producto producto = new Producto(0, "Teclado", 29.99, 15);
        productoRepository.save(producto);
        Producto found = productoRepository.findByNombre("Teclado");
        assertNotNull(found);
        productoId = found.getId();
    }

    @Test
    @Order(2)
    void testFindProductoById() {
        Producto producto = productoRepository.findById(productoId);
        assertEquals("Teclado", producto.getNombre());
    }

    @Test
    @Order(3)
    void testUpdateProducto() {
        Producto producto = productoRepository.findById(productoId);
        producto.setStock(25);
        productoRepository.update(producto);
        Producto updated = productoRepository.findById(productoId);
        assertEquals(25, updated.getStock());
    }

    @Test
    @Order(4)
    void testDeleteProducto() {
        productoRepository.deleteById(productoId);
        assertThrows(Exception.class, () -> productoRepository.findById(productoId));
    }

    @Test
    @Order(5)
    void testInsertPersona() {
        Persona persona = new Persona("Juan", "Pérez", 30);
        personaRepository.insert(persona);
        Persona found = personaRepository.findByName("Juan");
        assertNotNull(found);
        personaId = found.getId();
    }

    @Test
    @Order(6)
    void testFindPersonaById() {
        Persona persona = personaRepository.findById(personaId);
        assertEquals("Juan", persona.getNombre());
    }

    @Test
    @Order(7)
    void testDeletePersona() {
        personaRepository.delete(personaId);
        assertThrows(Exception.class, () -> personaRepository.findById(personaId));
    }

    @Test
    @Order(8)
    void contextLoads() {
        // Verifica que el contexto Spring se carga sin errores
    }
}
