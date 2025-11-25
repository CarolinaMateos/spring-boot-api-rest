package pedidos.restcontroller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pedidos.dto.UsuarioDTO;
import pedidos.entities.Usuario;
import pedidos.service.UsuarioService;

@RestController
@RequestMapping("/clientes")
public class ClientesRestController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/por-email/{texto}")
	public List<UsuarioDTO> buscarEmail(@PathVariable String texto){
		List<Usuario> lista = usuarioService.buscarClientesPorEmail(texto);
		List<UsuarioDTO> aux = new ArrayList<>();
		for (Usuario usuario: usuarioService.buscarClientesPorEmail(texto)) {
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			usuarioDTO.setEmail(usuario.getEmail());
			usuarioDTO.setEnabled(usuario.getEnabled());
			usuarioDTO.setFechaRegistro(usuario.getFechaRegistro());
			usuarioDTO.setIdUsuario(usuario.getIdUsuario());
			usuarioDTO.setNombre(usuario.getNombre());
			usuarioDTO.setRol(usuario.getRol());
			aux.add(usuarioDTO);
		}
		return aux;
	}
	
	@GetMapping("/algun-pedido")
	public List<UsuarioDTO> buscarPedido(){
		List<Usuario> lista = usuarioService.encontrarConAlgunPedido();
		List<UsuarioDTO> aux = new ArrayList<>();
		for (Usuario usuario: usuarioService.encontrarConAlgunPedido()) {
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			usuarioDTO.setEmail(usuario.getEmail());
			usuarioDTO.setEnabled(usuario.getEnabled());
			usuarioDTO.setFechaRegistro(usuario.getFechaRegistro());
			usuarioDTO.setIdUsuario(usuario.getIdUsuario());
			usuarioDTO.setNombre(usuario.getNombre());
			usuarioDTO.setRol(usuario.getRol());
			aux.add(usuarioDTO);
		}
		return aux;
	}
	
	@GetMapping("/despues-fecha/{fecha}")
	public List<UsuarioDTO> buscarFechaRegistro(@PathVariable LocalDate fecha){
		List<Usuario> lista = usuarioService.registradosDespuesDe(fecha);
		List<UsuarioDTO> aux = new ArrayList<>();
		for (Usuario usuario: usuarioService.registradosDespuesDe(fecha)) {
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			usuarioDTO.setEmail(usuario.getEmail());
			usuarioDTO.setEnabled(usuario.getEnabled());
			usuarioDTO.setFechaRegistro(usuario.getFechaRegistro());
			usuarioDTO.setIdUsuario(usuario.getIdUsuario());
			usuarioDTO.setNombre(usuario.getNombre());
			usuarioDTO.setRol(usuario.getRol());
			aux.add(usuarioDTO);
		}
		return aux;
	}
	
	@GetMapping("/registro/{fecha}")
	public List<UsuarioDTO> buscarFechaRegistro2(@PathVariable LocalDate fecha){
		List<Usuario> lista = usuarioService.registradosDespuesDe(fecha);
		List<UsuarioDTO> aux = new ArrayList<>();
		for (Usuario usuario: usuarioService.registradosDespuesDe(fecha)) {
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			usuarioDTO.setEmail(usuario.getEmail());
			usuarioDTO.setEnabled(usuario.getEnabled());
			usuarioDTO.setFechaRegistro(usuario.getFechaRegistro());
			usuarioDTO.setIdUsuario(usuario.getIdUsuario());
			usuarioDTO.setNombre(usuario.getNombre());
			usuarioDTO.setRol(usuario.getRol());
			aux.add(usuarioDTO);
		}
		return aux;
	}
	
}
