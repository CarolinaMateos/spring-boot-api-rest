package pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pedidos.entities.Producto;
import java.util.List;


public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	List<Producto> findByStockLessThan(int stock);
	List<Producto> findByCategoria_IdCategoria(int idCategoria);
	List<Producto> findByNombreContainingIgnoreCase(String q);
	List<Producto> findByCategoria_NombreIgnoreCase(String nombre);
}
