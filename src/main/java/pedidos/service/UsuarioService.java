package pedidos.service;

import java.time.LocalDate;
import java.util.List;

import pedidos.entities.Usuario;

public interface UsuarioService {
	List<Usuario> buscarClientesPorEmail(String email);
	List<Usuario> encontrarConAlgunPedido();
	List<Usuario> registradosDespuesDe(LocalDate fecha);
}
