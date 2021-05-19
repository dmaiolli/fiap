package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_PRODUTO")
@SequenceGenerator(name = "seqProduto", sequenceName = "SEQ_TB_PRODUTO", allocationSize = 1)
public class Produto {

	@Id
	@Column(name = "cd_produto")
	@GeneratedValue(generator = "seqProduto", strategy = GenerationType.SEQUENCE)
	private Integer codigo;

	@Column(name = "nm_produto", length = 80, nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "produto")
	private List<ItemProduto> items;

	public Produto() {
		super();
	}

	public Produto(String nome) {
		super();
		this.nome = nome;
	}

	public Produto(Integer codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
