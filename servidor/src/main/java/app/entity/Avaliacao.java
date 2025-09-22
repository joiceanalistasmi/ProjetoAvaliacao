package app.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
public class Avaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	 
	private Date periodo;
	 
	private Date data_avaliacao;
	
	private String observacao;
	
	@NotBlank(message = "Avaliador é obrigatório")
	private String avaliador;
	 
	private double nota_final;
	
	@ManyToOne
	@JoinTable(name="servidor_id")
	private Servidor servidor_id;
	   
	// Relacionamento muitos para muitos com Questao
    @ManyToMany
    @JoinTable(
        name = "avaliacao_questao",
        joinColumns = @JoinColumn(name = "avaliacao_id"),
        inverseJoinColumns = @JoinColumn(name = "questao_id")
    )
    private List<Questao> questoes = new ArrayList<>();
	  
	
}
