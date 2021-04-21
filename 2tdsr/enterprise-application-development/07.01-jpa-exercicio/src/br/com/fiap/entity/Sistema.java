package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_SISTEMA")
@SequenceGenerator(name = "sistema", sequenceName = "SQ_TB_SISTEMA", allocationSize = 1)
public class Sistema {

	@Id
	@Column(name = "cd_sistema")
	@GeneratedValue(generator = "sistema", strategy = GenerationType.SEQUENCE)
	private Integer cdSistema;

	@Column(name = "nm_sistema", length = 80, nullable = false)
	private String nomeSistema;
	
	@OneToMany(mappedBy = "")
	private CasoTeste casoTeste;

	public Sistema() {

	}

	public Sistema(String nomeSistema) {
		super();
		this.nomeSistema = nomeSistema;
	}

	public Sistema(Integer cdSistema, String nomeSistema) {
		super();
		this.cdSistema = cdSistema;
		this.nomeSistema = nomeSistema;
	}

	public Integer getCdSistema() {
		return cdSistema;
	}

	public void setCdSistema(Integer cdSistema) {
		this.cdSistema = cdSistema;
	}

	public String getNomeSistema() {
		return nomeSistema;
	}

	public void setNomeSistema(String nomeSistema) {
		this.nomeSistema = nomeSistema;
	}

}
