package pedidos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pedidos.entities.Pedido;
import pedidos.entities.Usuario;
import pedidos.repository.PedidoRepository;

@Service
public class PedidoImpl implements PedidoService{
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public List<Usuario> clientesConPedidos() {
		// TODO Auto-generated method stub
		return pedidoRepository.findDistinctClientesConPedidos();
	}

	@Override
	public List<Pedido> conMasDeLineas(long n) {
		return pedidoRepository.findPedidosConMasDeLineas(n);
	}

	@Override
	public List<Pedido> porCliente(long id) {
		return pedidoRepository.findByUsuario_IdUsuario(id);
	}

}
