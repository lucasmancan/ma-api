package br.com.lucasmancan.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "telefones")
public class Telefone implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="telefone", nullable=false)
	private String telefone;
	
	@ManyToOne
	@JoinColumn(name="pessoas_id", referencedColumnName="id", nullable=false)
	private Pessoa pessoa;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_criacao", nullable = false)
	private Date dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_alteracao", nullable = false)
	private Date dataAlteracao;
}
