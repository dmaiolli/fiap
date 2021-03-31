package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tb_curso")
@SequenceGenerator(sequenceName = "sq_tb_curso", name = "curso", allocationSize = 1)
public class Curso {

	@Id
	@Column(name = "cd_curso")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso")
	private Integer codigo;

	@Column(name = "nm_curso", length = 50, nullable = false)
	private String nomeCurso;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_cadastro", updatable = false)
	private Calendar dtCadastro;

	@Column(name = "vl_curso")
	private Double valorCurso;

	public Curso() {
	}

	public Curso(String nomeCurso, Double valorCurso) {
		super();
		this.nomeCurso = nomeCurso;
		this.valorCurso = valorCurso;
	}

	public Curso(Integer codigo, String nomeCurso, Double valorCurso) {
		super();
		this.codigo = codigo;
		this.nomeCurso = nomeCurso;
		this.valorCurso = valorCurso;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Calendar getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Calendar dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Double getValorCurso() {
		return valorCurso;
	}

	public void setValorCurso(Double valorCurso) {
		this.valorCurso = valorCurso;
	}

}
