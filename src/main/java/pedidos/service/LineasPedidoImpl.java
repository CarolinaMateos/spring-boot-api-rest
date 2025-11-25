package pedidos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pedidos.entities.LineasPedido;
import pedidos.repository.LineasPedidoRespository;

@Service
@RequiredArgsConstructor
public class LineasPedidoImpl implements LineasPedidoService{

		@Autowired
		private LineasPedidoRespository lineasPedidoRepository;

		@Override
		public List<Object[]> cantidadVendidaPorProducto() {
			return lineasPedidoRepository.cantidadVendidaPorProducto();
		}


		
		
}
