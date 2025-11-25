package pedidos.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="Lineas_Pedido")
public class LineasPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="NUMERO_ORDEN")
	private int numeroOrden;
	
	//Relacion unidireccional con el pedido
	@ManyToOne
	@JoinColumn(name="id_pedido")
	private Pedido pedido;
	
	//Relacion unidireccional con el producto
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto producto;
	
	private int cantidad;
	@Column(name="precio_unitario")
	private double precioUnitario;

}
