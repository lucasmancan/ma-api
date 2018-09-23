package br.com.lucasmancan.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity()
@Table(name="usuarios")
@Data
public class Usuario implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="pessoas_id", nullable=false)
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name="instituicoes_id", nullable=false)
	private Instituicao instituicao;
	
	@Column(name="senha", nullable=false)
	private String senha;
	

	@ManyToOne
	@JoinColumn(name="categorias_id", nullable=false)
	private Categoria categoria;
	

	@ManyToOne
	@JoinColumn(name="cursos_id", nullable=false)
	private Curso curso;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy= "criador")
	private Set<Atividade> atividades;
	

	@Column(name="data_criacao", nullable=false)
	private Date dataCriacao;
	

	@Column(name="data_alteracao", nullable=false)
	private Date dataAlteracao;
}
