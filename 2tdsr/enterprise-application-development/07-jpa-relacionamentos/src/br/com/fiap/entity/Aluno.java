package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_ALUNO")
@SequenceGenerator(sequenceName = "SQ_TB_ALUNO", name = "aluno", allocationSize = 1)
public class Aluno {

	@Id
	@Column(name = "nr_rm")
	@GeneratedValue(generator = "aluno", strategy = GenerationType.SEQUENCE)
	private int rm;

	@Column(name = "nm_aluno", length = 120, nullable = false)
	private String nomeAluno;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_nascimento")
	private Calendar dataNascimento;

	@Column(name = "ds_genero")
	@Enumerated(EnumType.STRING)
	private Genero genero;

	// Mapeamento do relacionamento
	@ManyToOne
	@JoinColumn(name = "cd_grupo", nullable = false)
	private GrupoChallenge grupo;

	public Aluno(String nomeAluno, Calendar dataNascimento, Genero genero) {
		super();
		this.nomeAluno = nomeAluno;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
	}

	public int getRm() {
		return rm;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public GrupoChallenge getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoChallenge grupo) {
		this.grupo = grupo;
	}

}
