package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_aluno")
@SequenceGenerator(sequenceName = "sq_tb_aluno", allocationSize = 1, name = "aluno")
public class Aluno {

	@Id
	@Column(name = "cd_aluno")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno")
	private Integer codigoAluno;

	@Column(name = "nm_aluno", length = 80, nullable = false)
	private String nome;

	@Column(name = "ds_turma", length = 50, nullable = false)
	private String turma;

	public Aluno() {
	}
	
	public Aluno(String nome, String turma) {
		super();
		this.nome = nome;
		this.turma = turma;
	}

	public Aluno(Integer codigoAluno, String nome, String turma) {
		super();
		this.codigoAluno = codigoAluno;
		this.nome = nome;
		this.turma = turma;
	}

	public Integer getCodigoAluno() {
		return codigoAluno;
	}

	public void setCodigoAluno(Integer codigoAluno) {
		this.codigoAluno = codigoAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

}
