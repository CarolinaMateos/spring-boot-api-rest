package pedidos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pedidos.entities.LineasPedido;

public interface LineasPedidoRespository extends JpaRepository<LineasPedido, Integer>{
	
	@Query("""
	         SELECT
	           l.producto.idProducto,   
	           l.producto.nombre,       
	           SUM(l.cantidad)          
	         FROM LineasPedido l
	         GROUP BY l.producto.idProducto, l.producto.nombre
	         ORDER BY l.producto.nombre
	         """)
	  List<Object[]> cantidadVendidaPorProducto();
	
	
}
