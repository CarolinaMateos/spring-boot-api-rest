package pedidos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pedidos.entities.Usuario;
import java.time.LocalDate;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	List<Usuario> findByEmailContainingIgnoreCaseAndRolIgnoreCase(String email, String rol);
	
	@Query("SELECT u FROM Usuario u WHERE UPPER(u.rol) = 'CLIENTE' AND EXISTS (SELECT 1 FROM Pedido p WHERE p.usuario = u)")
	List<Usuario> findClientesConAlgunPedido();
	
	List<Usuario> findByFechaRegistroAfter(LocalDate fechaRegistro);
}
