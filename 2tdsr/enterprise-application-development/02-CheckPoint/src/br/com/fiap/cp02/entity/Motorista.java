package br.com.fiap.cp02.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_MOTORISTA")
@SequenceGenerator(name="motorista", sequenceName ="SQ_MOTORISTA", allocationSize = 1)
public class Motorista {
	
	@Id
	@Column(name = "cd_motorista")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "motorista")
	private Integer codigo;

	@Column(name="nm_motorista", nullable = false)
	private String nome;
	
	@Column(name="nr_cpf", updatable = false, nullable = false)
	private Long cpf;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_habilitacao")
	private Habilitacao habilitacao;
	
	@OneToMany(mappedBy = "motorista", cascade = CascadeType.ALL)
	private List<Corrida> corridas;
	
	public Motorista() {
	}

	public Motorista(String nome, Long cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public Motorista(String nome, Long cpf, Habilitacao habilitacao) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.habilitacao = habilitacao;
	}

	public Motorista(Integer codigo, String nome, Long cpf) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public void addCorrida(Corrida corrida) {
		if (corridas == null)
			corridas = new ArrayList<>();
		corridas.add(corrida);
		corrida.setMotorista(this);
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Habilitacao getHabilitacao() {
		return habilitacao;
	}

	public void setHabilitacao(Habilitacao habilitacao) {
		this.habilitacao = habilitacao;
	}

	public List<Corrida> getCorridas() {
		return corridas;
	}

	public void setCorridas(List<Corrida> corridas) {
		this.corridas = corridas;
	}

	@Override
	public String toString() {
		return "Motorista [codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf + ", habilitacao=" + habilitacao
				+ ", corridas=" + corridas + "]";
	}

}