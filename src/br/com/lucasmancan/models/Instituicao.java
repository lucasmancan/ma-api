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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity()
@Table(name="instituicoes")
@Data
public class Instituicao implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="registro_governo", nullable=false)
	private String registroGoverno;
	

	@Column(name="nome", nullable=false, length= 255)
	private String nome;
	
	@OneToMany(cascade = CascadeType.ALL,  targetEntity = Curso.class, fetch = FetchType.LAZY)
	private Set<Curso> cursos;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_criacao", nullable=false)
	private Date dataCriacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAlteracao;
}
