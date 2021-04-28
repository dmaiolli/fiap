package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
	private Integer codigo;

	@Column(name = "nm_sistema", length = 80, nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "sistema", cascade = CascadeType.ALL)
	private List<CasoTeste> casosTeste;
	
	public void addCasoTeste(CasoTeste casoTeste) {
		if(casosTeste == null) {
			casosTeste = new ArrayList<CasoTeste>();
		}
		
		casosTeste.add(casoTeste);
		casoTeste.setSistema(this);
	}

	public Integer getCdSistema() {
		return codigo;
	}

	public void setCdSistema(Integer cdSistema) {
		this.codigo = cdSistema;
	}

	public String getNomeSistema() {
		return nome;
	}

	public void setNomeSistema(String nomeSistema) {
		this.nome = nomeSistema;
	}

	public List<CasoTeste> getCasosTeste() {
		return casosTeste;
	}

	public void setCasosTeste(List<CasoTeste> casosTeste) {
		this.casosTeste = casosTeste;
	}

}
