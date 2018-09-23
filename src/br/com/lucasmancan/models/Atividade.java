package br.com.lucasmancan.models;

import java.io.Serializable;
import java.math.BigDecimal;
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
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="atividades")
public class Atividade implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "criador_id",referencedColumnName="id", nullable=false) 
	private Usuario criador;
	
	@OneToMany(cascade = CascadeType.ALL,  targetEntity = Usuario.class, fetch = FetchType.LAZY)
	private Set<Usuario> usuarios;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_criacao", nullable= false)
	private Date dataCriacao;
	

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_alteracao", nullable= false)
	private Date dataAlteracao;
	

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_fim", nullable= false)
	private Date dataFim;
	

	@Column(name = "relatorio", nullable= false)
	private String relatorio;
	
	@ManyToOne
	@JoinColumn(name = "enderecos_id", referencedColumnName="id", nullable=false)
	private Endereco endereco;
	
	@Column(name = "total_horas", precision=7, scale=2, nullable= false)
	private BigDecimal totalHoras;
}
