package app.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
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
	
	@NotBlank(message = "Setor é obrigatório")
	private String setor;
	
	private Date data_criacao;
	
	@Enumerated(EnumType.STRING)
	private Status status;

	public enum Status {
	    ATIVO, INATIVO;
	}
	
	@OneToMany(mappedBy = "servidor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Avaliacao> avaliacoes = new ArrayList<>();


}
