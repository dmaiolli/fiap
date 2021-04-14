package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_NANO_COURSES")
@SequenceGenerator(sequenceName = "SQ_TB_NANO_COURSES", name = "nanoCourses", allocationSize = 1)
public class NanoCourses {

	@Id
	@Column(name = "cd_nano_course")
	@GeneratedValue(generator = "nanoCourses", strategy = GenerationType.SEQUENCE)
	private int cdNanoCourse;

	@Column(name = "nm_nano_course", nullable = false)
	private String nomeNanoCourse;

	@Column(name = "nr_creditos", nullable = false)
	private int numeroCreditos;

	@Column(name = "ds_nivel", length = 20)
	@Enumerated(EnumType.STRING)
	private NivelCurso nivel;
	


	public NanoCourses() {
	}

	public NanoCourses(String nomeNanoCourse, int numeroCreditos, NivelCurso descricaoNivel) {
		super();
		this.nomeNanoCourse = nomeNanoCourse;
		this.numeroCreditos = numeroCreditos;
		this.nivel = descricaoNivel;
	}

	public NanoCourses(int cdNanoCourse, String nomeNanoCourse, int numeroCreditos, NivelCurso descricaoNivel) {
		super();
		this.cdNanoCourse = cdNanoCourse;
		this.nomeNanoCourse = nomeNanoCourse;
		this.numeroCreditos = numeroCreditos;
		this.nivel = descricaoNivel;
	}

	public int getCdNanoCourse() {
		return cdNanoCourse;
	}

	public void setCdNanoCourse(int cdNanoCourse) {
		this.cdNanoCourse = cdNanoCourse;
	}

	public String getNomeNanoCourse() {
		return nomeNanoCourse;
	}

	public void setNomeNanoCourse(String nomeNanoCourse) {
		this.nomeNanoCourse = nomeNanoCourse;
	}

	public int getNumeroCreditos() {
		return numeroCreditos;
	}

	public void setNumeroCreditos(int numeroCreditos) {
		this.numeroCreditos = numeroCreditos;
	}

	public NivelCurso getDescricaoNivel() {
		return nivel;
	}

	public void setDescricaoNivel(NivelCurso descricaoNivel) {
		this.nivel = descricaoNivel;
	}

}
