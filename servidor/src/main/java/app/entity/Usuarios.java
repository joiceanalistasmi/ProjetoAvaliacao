package app.entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuarios {

	@Id
	private Long id;
	
	@NotNull(message = "Nome completo é obrigatário")
	private String nomeCompleto;
	
	@NotNull(message = "Username obrigatório")
	private String username;
		
	@NotNull(message = "Senha é obrigatório")
	private String password;
	
	@NotNull(message= "Seleção Obrigatória")
	private String role;
	
	

}
