package br.com.fiap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CASO_TESTE")
@SequenceGenerator(name = "casoTeste", sequenceName = "SQ_TB_CASO_TESTE", initialValue = 1)
public class CasoTeste {

	@Id
	@Column(name = "cd_caso_teste")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "casoTeste")
	private Integer cdCasoTeste;

	@Column(name = "nm_caso_teste", length = 80, nullable = false)
	private String nomeCasoTeste;

	@Column(name = "ds_caso_teste", length = 150)
	private String descCasoTeste;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private List<Sistema> codigoSistema;

	public CasoTeste() {
	}

	public CasoTeste(String nomeCasoTeste) {
		super();
		this.nomeCasoTeste = nomeCasoTeste;
	}

	public CasoTeste(String nomeCasoTeste, String descCasoTeste) {
		super();
		this.nomeCasoTeste = nomeCasoTeste;
		this.descCasoTeste = descCasoTeste;
	}

	public CasoTeste(Integer cdCasoTeste, String nomeCasoTeste, String descCasoTeste) {
		super();
		this.cdCasoTeste = cdCasoTeste;
		this.nomeCasoTeste = nomeCasoTeste;
		this.descCasoTeste = descCasoTeste;
	}

	public Integer getCdCasoTeste() {
		return cdCasoTeste;
	}

	public void setCdCasoTeste(Integer cdCasoTeste) {
		this.cdCasoTeste = cdCasoTeste;
	}

	public String getNomeCasoTeste() {
		return nomeCasoTeste;
	}

	public void setNomeCasoTeste(String nomeCasoTeste) {
		this.nomeCasoTeste = nomeCasoTeste;
	}

	public String getDescCasoTeste() {
		return descCasoTeste;
	}

	public void setDescCasoTeste(String descCasoTeste) {
		this.descCasoTeste = descCasoTeste;
	}

}
