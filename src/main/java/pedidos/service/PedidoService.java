package pedidos.service;

import java.util.List;

import pedidos.entities.Pedido;
import pedidos.entities.Usuario;

public interface PedidoService {
	List<Usuario> clientesConPedidos();
	List<Pedido> conMasDeLineas(long n);
	List<Pedido> porCliente(long id);
}
