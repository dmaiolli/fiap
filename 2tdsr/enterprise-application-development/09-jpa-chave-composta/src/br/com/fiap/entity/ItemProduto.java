package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//Define qual classe que mapeia a chave composta da tabela
@IdClass(ItemProdutoPK.class)

@Entity
@Table(name = "TB_ITEM_PRODUTO")
@SequenceGenerator(name = "seqItem", sequenceName = "SQ_TB_ITEM_PRODUTO", allocationSize = 1)
public class ItemProduto {

	@Id
	@Column(name = "cd_item_produto")
	@GeneratedValue(generator = "seqItem", strategy = GenerationType.SEQUENCE)
	private Integer codigo;

	@Id
	@ManyToOne
	@JoinColumn(name = "cd_carrinho")
	private CarrinhoCompra carrinho;

	@Id
	@ManyToOne
	@JoinColumn(name = "cd_carrinho")
	private Produto produto;

	@Column(name = "vl_carrinho", nullable = false)
	private Double valor;

	@Column(name = "qt_item")
	private Integer quantidade;

	public ItemProduto(Produto produto, Double valor, Integer quantidade) {
		super();
		this.produto = produto;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public ItemProduto(Double valor, Integer quantidade, CarrinhoCompra carrinho, Produto produto) {
		super();
		this.valor = valor;
		this.quantidade = quantidade;
		this.carrinho = carrinho;
		this.produto = produto;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public CarrinhoCompra getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(CarrinhoCompra carrinho) {
		this.carrinho = carrinho;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
