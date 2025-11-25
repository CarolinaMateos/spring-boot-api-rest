package pedidos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pedidos.entities.Pedido;
import pedidos.entities.Usuario;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	
	@Query("SELECT DISTINCT p.usuario FROM Pedido p WHERE UPPER(p.usuario.rol) = 'CLIENTE'")
	    List<Usuario> findDistinctClientesConPedidos();
	
	@Query("""
	         SELECT p FROM Pedido p
	         WHERE p.idPedido IN (
	           SELECT l.pedido.idPedido
	           FROM LineasPedido l
	           GROUP BY l.pedido.idPedido
	           HAVING COUNT(l) > ?1
	         )
	         """)
	  List<Pedido> findPedidosConMasDeLineas(long n);
	
	  List<Pedido> findByUsuario_IdUsuario(Long idUsuario);
	
	
}
