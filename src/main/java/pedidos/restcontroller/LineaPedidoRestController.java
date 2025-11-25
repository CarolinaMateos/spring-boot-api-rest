package pedidos.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import pedidos.service.LineasPedidoService;

@RestController
@RequestMapping("/lineapedido")
public class LineaPedidoRestController {

	@Autowired
	private LineasPedidoService lineasPedidoService;

	@GetMapping("/venta-productos") //ENDPOINT 3
	public List<Object[]> totalProducto() {
		return lineasPedidoService.cantidadVendidaPorProducto();
	}

}
