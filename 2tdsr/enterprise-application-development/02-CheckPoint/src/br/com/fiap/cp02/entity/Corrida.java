package br.com.fiap.cp02.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="T_CORRIDA")
@SequenceGenerator(name="corrida", sequenceName = "SQ_CORRIDA", allocationSize = 1)
public class Corrida {

	@Id
	@Column(name="cd_corrida")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "corrida")
	private Integer codigo;
	
	@Column(name="vl_corrida", nullable = false)
	private Double preco;
	
	@Column(name="dt_corrida", nullable = false, updatable = false)
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private Calendar dataCorrida;
	
	@ManyToOne
	@JoinColumn(name = "cd_motorista")
	private Motorista motorista;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "T_CORRIDA_PESSOA", joinColumns = @JoinColumn(name="cd_corrida"), inverseJoinColumns = @JoinColumn(name="cd_pessoa"))
	private List<Pessoa> pessoas;
	
	public Corrida() {
	}

	public Corrida(Double preco) {
		this.preco = preco;
	}

	public Corrida(Integer codigo, Double preco) {
		super();
		this.codigo = codigo;
		this.preco = preco;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Calendar getDataCorrida() {
		return dataCorrida;
	}

	public void setDataCorrida(Calendar dataCorrida) {
		this.dataCorrida = dataCorrida;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	@Override
	public String toString() {
		return "Corrida [codigo=" + codigo + ", preco=" + preco + ", dataCorrida=" + dataCorrida + ", motorista="
				+ motorista + ", pessoas=" + pessoas + "]";
	}
}