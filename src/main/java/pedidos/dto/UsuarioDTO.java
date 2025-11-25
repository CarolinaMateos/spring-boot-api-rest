package pedidos.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsuarioDTO {
	
	private int idUsuario;
	private String nombre;
	private String email;
	private int enabled;
	private String rol;
	private LocalDate fechaRegistro;
	
}
