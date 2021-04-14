package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "TB_PROJETO_CHALLENGE")
@SequenceGenerator(sequenceName = "SQ_TB_PROJETO_CHALLENGE", name = "projeto", allocationSize = 1, initialValue = 1)
public class ProjetoChallenge {

	@Id
	@Column(name = "cd_projeto")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projeto")
	private int cdProjeto;

	@Column(name = "nm_projeto", length = 80, nullable = false)
	private String nomeProjeto;

	@Column(name = "dt_entrega", nullable = false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataEntrega;

	@Column(name = "vl_nota")
	private Float valorNota;

	@Column(name = "ds_setor", length = 100)
	private String descricaoSetor;

	// Mapear o relacionamento um-para-um
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_grupo", nullable = false, unique = true)
	private GrupoChallenge grupo;

	public ProjetoChallenge() {

	}

	public ProjetoChallenge(String nomeProjeto, Calendar dataEntrega, Float valorNota, String descricaoSetor,
			GrupoChallenge grupo) {
		super();
		this.nomeProjeto = nomeProjeto;
		this.dataEntrega = dataEntrega;
		this.valorNota = valorNota;
		this.descricaoSetor = descricaoSetor;
		this.grupo = grupo;
	}

	public ProjetoChallenge(int cdProjeto, String nomeProjeto, Calendar dataEntrega) {
		super();
		this.cdProjeto = cdProjeto;
		this.nomeProjeto = nomeProjeto;
		this.dataEntrega = dataEntrega;
	}

	public ProjetoChallenge(int cdProjeto, String nomeProjeto, Calendar dataEntrega, Float valorNota,
			String descricaoSetor) {
		super();
		this.cdProjeto = cdProjeto;
		this.nomeProjeto = nomeProjeto;
		this.dataEntrega = dataEntrega;
		this.valorNota = valorNota;
		this.descricaoSetor = descricaoSetor;
	}

	public ProjetoChallenge(String nomeProjeto, Calendar dataEntrega, Float valorNota, String descricaoSetor) {
		super();
		this.nomeProjeto = nomeProjeto;
		this.dataEntrega = dataEntrega;
		this.valorNota = valorNota;
		this.descricaoSetor = descricaoSetor;
	}

	public int getCdProjeto() {
		return cdProjeto;
	}

	public void setCdProjeto(int cdProjeto) {
		this.cdProjeto = cdProjeto;
	}

	public String getNomeProjeto() {
		return nomeProjeto;
	}

	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}

	public Calendar getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Calendar dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Float getValorNota() {
		return valorNota;
	}

	public void setValorNota(Float valorNota) {
		this.valorNota = valorNota;
	}

	public String getDescricaoSetor() {
		return descricaoSetor;
	}

	public void setDescricaoSetor(String descricaoSetor) {
		this.descricaoSetor = descricaoSetor;
	}

	public GrupoChallenge getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoChallenge grupo) {
		this.grupo = grupo;
	}

}
