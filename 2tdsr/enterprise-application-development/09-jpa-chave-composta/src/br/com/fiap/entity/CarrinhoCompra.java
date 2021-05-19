package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_CARRINHO_COMPRA")
@SequenceGenerator(name = "seqCarrinhCompra", sequenceName = "SEQ_TB_CARRINHO_COMPRA", allocationSize = 1)
public class CarrinhoCompra {

	@Id
	@Column(name = "cd_carrinho")
	@GeneratedValue(generator = "seqCarrinhoCompra", strategy = GenerationType.SEQUENCE)
	private Integer codigo;

	@Column(name = "dt_carrinho")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	@OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL)
	private List<ItemProduto> items;
	
	public void addItem(ItemProduto item) {
		if( items == null) {
			items = new ArrayList<ItemProduto>();
		}
		
		items.add(item);
		item.setCarrinho(this);
	}

	public CarrinhoCompra() {
		super();
	}

	public CarrinhoCompra(Calendar data) {
		super();
		this.data = data;
	}

	public CarrinhoCompra(Integer codigo, Calendar data) {
		super();
		this.codigo = codigo;
		this.data = data;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

}
