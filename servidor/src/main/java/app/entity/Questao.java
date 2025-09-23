package app.entity;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Questao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Enunciado é obrigatório")
	private String enunciado;

	private String observacao;

	@Enumerated(EnumType.STRING)
	@Column(name = "questionAtiva")
	private QuestionAtiva questionAtiva;

	public enum QuestionAtiva {
	    	ATIVO, INATIVO;
	}
	
	//@ManyToMany(mappedBy = "questoes")
	//private List<Avaliacao> avaliacoes = new ArrayList<>();

}
