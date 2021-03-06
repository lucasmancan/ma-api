package br.com.lucasmancan.models;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "instituicoes_cursos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstituicoesCursos {

	@EmbeddedId
	private InstituicoesCursosPK id;
	
	@ManyToOne
	@JoinColumn(name="instituicoes_id", referencedColumnName="id", nullable=false)
	private Instituicao instituicao;
	
	@ManyToOne
	@JoinColumn(name="cursos_id", referencedColumnName="id", nullable=false)
    private Curso curso;  

}


