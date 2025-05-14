package org.example.demojdbc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.example.demojdbc.model.Producto;

import org.springframework.jdbc.core.RowMapper;

public class ProductoMapper implements RowMapper<Producto> {

    @Override
    public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
        // Crear un nuevo objeto Producto y mapear los campos del ResultSet
        Producto producto = new Producto();
        producto.setId(rs.getInt("id"));
        producto.setNombre(rs.getString("nombre"));
        producto.setPrecio(rs.getDouble("precio"));
        producto.setStock(rs.getInt("stock"));
        return producto;
    }
}
