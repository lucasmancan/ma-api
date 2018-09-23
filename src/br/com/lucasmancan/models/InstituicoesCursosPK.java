package br.com.lucasmancan.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Embeddable  
@Data
public class InstituicoesCursosPK implements Serializable {
	@ManyToOne
	@JoinColumn(name="instituicoes_id", referencedColumnName="id", nullable=false)
	private Instituicao instituicao;
	@ManyToOne
	@JoinColumn(name="cursos_id", referencedColumnName="id", nullable=false)
    private Curso curso;  
}

