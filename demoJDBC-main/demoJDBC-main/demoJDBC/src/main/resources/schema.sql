package
org.example.demojdbc.repository;

import
org.example.demojdbc.model.Producto;
import
org.springframework.beans.factory.annotation.Autowired;
import
org.springframework.jdbc.core.JdbcTemplate;
import
org.springframework.stereotype.Repository;

import
java.util.List;

@Repository
public class ProductoRepository {

DROP TABLE IF EXISTS producto;
DROP TABLE IF EXISTS persona;

CREATE TABLE persona (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         nombre VARCHAR(255) NOT NULL,
                         apellidos VARCHAR(255),
                         edad INT
);

CREATE TABLE producto (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          nombre VARCHAR(255) NOT NULL,
                          precio DECIMAL(10,2) NOT NULL,
                          stock INT NOT NULL
);

    @Autowired
    private JdbcTemplate jdbcTemplate;

public int save(Producto producto) {
        String sql = "INSERT INTO producto (nombre, precio, stock) VALUES (?, ?, ?)";
return jdbcTemplate.update(sql, producto.getNombre(), producto.getPrecio(), producto.getStock());
}

    public List<Producto> findAll() {
        String sql = "SELECT * FROM producto";
return jdbcTemplate.query(sql, (rs, rowNum) - >
                               new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                )
       );
}

    public int
update (Producto producto) {
    String sql = "UPDATE producto SET nombre = ?, precio = ?, stock = ? WHERE id = ?";
return jdbcTemplate.update(sql, producto.getNombre(), producto.getPrecio(), producto.getStock(), producto.getId());
}

    public int deleteById(int id) {
        String sql = "DELETE FROM producto WHERE id = ?";
return jdbcTemplate.update(sql, id);
}
}
