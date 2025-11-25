package pedidos.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pedidos.dto.UsuarioDTO;
import pedidos.entities.Pedido;
import pedidos.entities.Usuario;
import pedidos.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidosRestController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping("/clientes")
	public List<UsuarioDTO> clientesConPedidos(){
		List<Usuario> lista = pedidoService.clientesConPedidos();
		List<UsuarioDTO> aux = new ArrayList<>();
		for (Usuario usuario: pedidoService.clientesConPedidos()) {
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
	
	@GetMapping("/con-mas-de/{n}") //ENDPOINT 1
	  public List<Pedido> conMasDe(@PathVariable long n){
	    return pedidoService.conMasDeLineas(n);
	  }
	
	@GetMapping("/por-cliente/{idUsuario}") //ENDPOINT 2
	public List<Pedido> porCliente(@PathVariable Long idUsuario){
	  return pedidoService.porCliente(idUsuario);
	}
}
