package org.example.demojdbc.repository;

import org.example.demojdbc.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Guardar un nuevo producto
    public int save(Producto producto) {
        String sql = "INSERT INTO producto (nombre, precio, stock) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, producto.getNombre(), producto.getPrecio(), producto.getStock());
    }

    // Obtener todos los productos
    public List<Producto> findAll() {
        String sql = "SELECT * FROM producto";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                )
        );
    }

    // Actualizar un producto existente
    public int update(Producto producto) {
        String sql = "UPDATE producto SET nombre = ?, precio = ?, stock = ? WHERE id = ?";
        return jdbcTemplate.update(sql, producto.getNombre(), producto.getPrecio(), producto.getStock(), producto.getId());
    }

    // Eliminar un producto por ID
    public int deleteById(int id) {
        String sql = "DELETE FROM producto WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public Producto findById(int id) {
        String sql = "SELECT * FROM producto WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                )
        );
    }

    public Producto findByNombre(String nombre) {
        String sql = "SELECT * FROM producto WHERE nombre = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{nombre}, (rs, rowNum) ->
                new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                )
        );
    }


}
