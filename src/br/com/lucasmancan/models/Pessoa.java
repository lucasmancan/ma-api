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

@Data
@Entity
@Table(name = "pessoas")
public class Pessoa implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome", nullable = true, length = 255)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "email_principal_id", referencedColumnName = "id", nullable = false)
	private Email emailPrincipal;

	@ManyToOne
	@JoinColumn(name = "telefone_principal_id", referencedColumnName = "id", nullable = false)
	private Telefone telefonePrincipal;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = Email.class, fetch = FetchType.LAZY)
	private Set<Email> emails;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = Telefone.class, fetch = FetchType.LAZY)
	private Set<Telefone> telefones;

	@Column(name = "rg", nullable = true, length = 12)
	private String rg;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_criacao", nullable = false)
	private Date dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_alteracao", nullable = false)
	private Date dataAlteracao;
}
