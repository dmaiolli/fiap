package br.com.fiap.entity;

import java.io.Serializable;

// Classe que mapeia a chave composta da tabela TB_ITEM_PRODUTO
// Possui os atributos que formam a chave (possuem o mesmo nome dos atributos da classe)
public class ItemProdutoPK implements Serializable {

	private Integer codigo;

	private Integer produto;

	private Integer carrinho;

	public ItemProdutoPK() {
		super();
	}

	public ItemProdutoPK(Integer codigo, Integer produto, Integer carrinho) {
		super();
		this.codigo = codigo;
		this.produto = produto;
		this.carrinho = carrinho;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carrinho == null) ? 0 : carrinho.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemProdutoPK other = (ItemProdutoPK) obj;
		if (carrinho == null) {
			if (other.carrinho != null)
				return false;
		} else if (!carrinho.equals(other.carrinho))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}

	public Integer getProduto() {
		return produto;
	}

	public void setProduto(Integer produto) {
		this.produto = produto;
	}

	public Integer getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Integer carrinho) {
		this.carrinho = carrinho;
	}

}
