package br.com.lucasmancan.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
public class Pessoa implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="email_principal_id")
	private Email emailPrincipal;
	
	@ManyToOne
	@JoinColumn(name="telefone_principal_id")
	private Telefone telefonePrincipal;
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Email.class, fetch = FetchType.LAZY) 
	private Set<Email> emails;
	
	
	@OneToMany(cascade = CascadeType.ALL,  targetEntity = Telefone.class, fetch = FetchType.LAZY) 
	private Set<Telefone> telefones;

	@Column(name= "rg",nullable =true)
	private String rg;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_criacao", nullable = false)
	private Date dataCriacao;
	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_alteracao", nullable = false)
	private Date dataAlteracao;
}
