package app.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
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
public class Servidor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Matricula é obrigatório")
	private String matricula;
	
	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	
	@NotBlank(message = "CPF é obrigatório")
	private String cpf;
	
	@NotBlank(message = "Cargo é obrigatório")
	private String cargo;
	
	@NotNull(message = "Data de admissão é obrigatório")
	@JsonProperty("data_admissao")
	private LocalDate data_admissao;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "status_servidor")
	private StatusServidor statusServidor;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "vinculo_funcional")
	private vinculo_funcional vinculo_funcional;

	public enum StatusServidor {
	    	ATIVO, INATIVO;
	}
	
	public enum vinculo_funcional{
		CONCURSADO, PROBATORIO;
	}
	
	 


}
