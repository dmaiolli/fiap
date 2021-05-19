package br.com.fiap.cp02.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_PESSOA")
@SequenceGenerator(name="pessoa", sequenceName ="SQ_PESSOA", allocationSize = 1)
public class Pessoa {
	
	@Id
	@Column(name="cd_pessoa")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa")
	private Integer codigo;
	
	@Column(name="nm_pessoa", length = 50, nullable = false)
	private String nome;
	
	@Column(name="nr_telefone")
	private Long telefone;
	
	@Column(name="ds_email", length = 50)
	private String email;
	
	@ManyToMany(mappedBy = "pessoas")
	private List<Corrida> corridas;
	
	public Pessoa() {
	}

	public Pessoa(String nome, Long telefone, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}

	public Pessoa(Integer codigo, String nome, Long telefone, String email) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
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

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Corrida> getCorridas() {
		return corridas;
	}

	public void setCorridas(List<Corrida> corridas) {
		this.corridas = corridas;
	}

	@Override
	public String toString() {
		return "Pessoa [codigo=" + codigo + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email
				+ ", corridas=" + corridas + "]";
	}
}