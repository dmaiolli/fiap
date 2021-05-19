package br.com.fiap.cp02.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_HABILITACAO")
@SequenceGenerator(name="habilitacao", sequenceName="SQ_HABILITACAO", allocationSize = 1)
public class Habilitacao {
	
	@Id
	@Column(name = "cd_habilitacao")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "habilitacao")
	private Integer codigo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_validade", updatable = false, nullable = false)
	private Calendar dataValidade;

	@Enumerated(EnumType.STRING)
	@Column(name = "ds_habilitacao", nullable = false)
	private TipoHabilitacao tipo;
	
	@OneToOne(mappedBy = "habilitacao", cascade = CascadeType.ALL)
	private Motorista motorista;

	public Habilitacao() {
	}

	public Habilitacao(Calendar dataValidade, TipoHabilitacao tipo) {
		super();
		this.dataValidade = dataValidade;
		this.tipo = tipo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}

	public TipoHabilitacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoHabilitacao tipo) {
		this.tipo = tipo;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	@Override
	public String toString() {
		return "Habilitacao [codigo=" + codigo + ", dataValidade=" + dataValidade + ", motorista=" + motorista + "]";
	}
}