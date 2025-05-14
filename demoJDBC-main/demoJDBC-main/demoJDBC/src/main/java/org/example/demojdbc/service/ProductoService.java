package org.example.demojdbc.service;

import org.example.demojdbc.model.Producto;
import org.example.demojdbc.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    // Constructor de inyección de dependencias
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Obtener todos los productos
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    // Insertar un producto
    public void addProducto(Producto producto) {
        productoRepository.save(producto);  // Cambiado de update a save
    }

    // Eliminar un producto
    public void deleteProducto(Producto producto) {
        productoRepository.deleteById(producto.getId());  // Llamada correcta al método de eliminación
    }

    // Buscar un producto por nombre
    public Producto getProductoByName(String nombre) {
        return productoRepository.findByNombre(nombre);  // Cambiado de buscarUno a findByNombre
    }

    // Buscar un producto por ID
    public Producto getProductoById(int id) {
        return productoRepository.findById(id);  // Cambiado de buscarUno a findById
    }
}
