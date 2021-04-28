package br.com.fiap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ITEM_TESTE")
@SequenceGenerator(name = "itemTeste", sequenceName = "SQ_TB_ITEM_TESTE", allocationSize = 1)
public class ItemTeste {

	@Id
	@Column(name = "cd_item_teste")
	@GeneratedValue(generator = "itemTeste", strategy = GenerationType.SEQUENCE)
	private Integer codigo;

	@Column(name = "ds_item_teste", length = 150, nullable = false)
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "cd_caso_teste")
	private CasoTeste casoTeste;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "TB_ITEM_TESTE_USUARIO", 
		joinColumns = @JoinColumn(name = "cd_item_teste"), 
		inverseJoinColumns = @JoinColumn(name = "cd_usuario"))
	private List<Usuario> usuarios;
	
	public Integer getCdItemTeste() {
		return codigo;
	}

	public void setCdItemTeste(Integer cdItemTeste) {
		this.codigo = cdItemTeste;
	}

	public String getDescItemTeste() {
		return descricao;
	}

	public void setDescItemTeste(String descItemTeste) {
		this.descricao = descItemTeste;
	}

	public CasoTeste getCasoTeste() {
		return casoTeste;
	}

	public void setCasoTeste(CasoTeste casoTeste) {
		this.casoTeste = casoTeste;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
