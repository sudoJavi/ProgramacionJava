package org.example.demojdbc.controller;

import org.example.demojdbc.model.Producto;
import org.example.demojdbc.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    // Constructor de inyección de dependencias
    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // Obtener todos los productos
    @GetMapping("/")
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    // Insertar un producto
    @PostMapping("/")
    public void addProducto(@RequestBody Producto producto) {
        productoService.addProducto(producto);
    }

    // Eliminar un producto
    @DeleteMapping("/")
    public void deleteProducto(@RequestBody Producto producto) {
        productoService.deleteProducto(producto);
    }

    // Buscar un producto por nombre
    @GetMapping("/{nombre}")
    public Producto getProductoByName(@PathVariable String nombre) {
        return productoService.getProductoByName(nombre);
    }

    // Buscar un producto por ID
    @GetMapping("/id/{id}")
    public Producto getProductoById(@PathVariable int id) {
        return productoService.getProductoById(id);
    }
}
