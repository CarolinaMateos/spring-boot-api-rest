package pedidos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pedidos.entities.LineasPedido;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LineaPedidoDTO {
	
	private int numeroOrden;
	private int idPedido;
	private long idProducto;
	private double precioUnitario;
	private int cantidadVendida;
	
	public static LineaPedidoDTO convertirADto(LineasPedido linea) {
		LineaPedidoDTO lineaP = new LineaPedidoDTO();
		lineaP.setCantidadVendida(linea.getCantidad());
		lineaP.setIdPedido(linea.getPedido().getIdPedido());
		lineaP.setIdProducto(linea.getProducto().getIdProducto());
		lineaP.setNumeroOrden(linea.getNumeroOrden());
		lineaP.setPrecioUnitario(linea.getPrecioUnitario());
		return lineaP;
	}
}
