package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_USUARIO")
@SequenceGenerator(name = "usuario", sequenceName = "SQ_TB_USUARIO", allocationSize = 1)
public class Usuario {

	@Id
	@Column(name = "cd_usuario")
	@GeneratedValue(generator = "usuario", strategy = GenerationType.SEQUENCE)
	private Integer codigo;

	@Column(name = "nm_usuario", length = 50, nullable = false)
	private String nome;
	
	@ManyToMany(mappedBy = "usuarios")
	private List<ItemTeste> itensTeste;

	public Integer getCdUsuario() {
		return codigo;
	}

	public void setCdUsuario(Integer cdUsuario) {
		this.codigo = cdUsuario;
	}

	public String getNomeUsuario() {
		return nome;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nome = nomeUsuario;
	}

	public List<ItemTeste> getItensTeste() {
		return itensTeste;
	}

	public void setItensTeste(List<ItemTeste> itensTeste) {
		this.itensTeste = itensTeste;
	}

}
