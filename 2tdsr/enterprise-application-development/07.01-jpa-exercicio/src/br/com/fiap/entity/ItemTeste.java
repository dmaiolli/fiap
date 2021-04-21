package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ITEM_TESTE")
@SequenceGenerator(name = "itemTeste", sequenceName = "SQ_TB_ITEM_TESTE", allocationSize = 1)
public class ItemTeste {

	@Id
	@Column(name = "cd_item_teste")
	@GeneratedValue(generator = "itemTeste", strategy = GenerationType.SEQUENCE)
	private Integer cdItemTeste;

	@Column(name = "ds_item_teste", length = 150, nullable = false)
	private String descItemTeste;

	public ItemTeste() {

	}

	public ItemTeste(String descItemTeste) {
		super();
		this.descItemTeste = descItemTeste;
	}

	public ItemTeste(Integer cdItemTeste, String descItemTeste) {
		super();
		this.cdItemTeste = cdItemTeste;
		this.descItemTeste = descItemTeste;
	}

	public Integer getCdItemTeste() {
		return cdItemTeste;
	}

	public void setCdItemTeste(Integer cdItemTeste) {
		this.cdItemTeste = cdItemTeste;
	}

	public String getDescItemTeste() {
		return descItemTeste;
	}

	public void setDescItemTeste(String descItemTeste) {
		this.descItemTeste = descItemTeste;
	}

}
