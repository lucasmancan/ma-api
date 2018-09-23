package br.com.lucasmancan.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity()
@Table(name="usuarios")
@Data
public class Usuario implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="pessoas_id", referencedColumnName="id", nullable=false)
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name="instituicoes_id", nullable=false)
	private Instituicao instituicao;
	
	@Column(name="senha", nullable=false)
	private String senha;
	

	@ManyToOne
	@JoinColumn(name="categorias_id", referencedColumnName="id", nullable=false)
	private Categoria categoria;
	

	@ManyToOne
	@JoinColumn(name="cursos_id",referencedColumnName="id", nullable=false)
	private Curso curso;
	
	@OneToMany(cascade = CascadeType.ALL,targetEntity=Atividade.class, fetch=FetchType.LAZY)
	private Set<Atividade> atividades;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_criacao", nullable=false)
	private Date dataCriacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_alteracao", nullable=false)
	private Date dataAlteracao;
}
