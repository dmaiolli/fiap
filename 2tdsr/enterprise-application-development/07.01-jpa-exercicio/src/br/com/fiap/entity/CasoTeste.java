package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CASO_TESTE")
@SequenceGenerator(name = "casoTeste", sequenceName = "SQ_TB_CASO_TESTE", initialValue = 1)
public class CasoTeste {

	@Id
	@Column(name = "cd_caso_teste")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "casoTeste")
	private Integer codigo;

	@Column(name = "nm_caso_teste", length = 80, nullable = false)
	private String nome;

	@Column(name = "ds_caso_teste", length = 150)
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "cd_sistema")
	private Sistema sistema;

	@OneToMany(mappedBy = "casoTeste", cascade = CascadeType.ALL)
	private List<ItemTeste> itensTeste;

	public void addItemTeste(ItemTeste itemTeste) {
		if(itensTeste == null) {
			itensTeste = new ArrayList<ItemTeste>();
		}
		
		itemTeste.setCasoTeste(this);
		itensTeste.add(itemTeste);
	}

	public Integer getCdCasoTeste() {
		return codigo;
	}

	public void setCdCasoTeste(Integer cdCasoTeste) {
		this.codigo = cdCasoTeste;
	}

	public String getNomeCasoTeste() {
		return nome;
	}

	public void setNomeCasoTeste(String nomeCasoTeste) {
		this.nome = nomeCasoTeste;
	}

	public String getDescCasoTeste() {
		return descricao;
	}

	public void setDescCasoTeste(String descCasoTeste) {
		this.descricao = descCasoTeste;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public List<ItemTeste> getItensTeste() {
		return itensTeste;
	}

	public void setItensTeste(List<ItemTeste> itensTeste) {
		this.itensTeste = itensTeste;
	}

}
