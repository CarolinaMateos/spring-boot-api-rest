package pedidos.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pedidos.entities.Usuario;
import pedidos.repository.UsuarioRepository;

@Service
public class UsuarioImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> buscarClientesPorEmail(String email) {
		return usuarioRepository.findByEmailContainingIgnoreCaseAndRolIgnoreCase(email, "CLIENTE");
	}

	@Override
	public List<Usuario> encontrarConAlgunPedido() {
		return usuarioRepository.findClientesConAlgunPedido();
	}

	@Override
	public List<Usuario> registradosDespuesDe(LocalDate fecha) {
		return usuarioRepository.findByFechaRegistroAfter(fecha);
	}
}
