package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_USUARIO")
@SequenceGenerator(name = "usuario", sequenceName = "SQ_TB_USARIO", allocationSize = 1)
public class Usuario {

	@Id
	@Column(name = "cd_usuario")
	@GeneratedValue(generator = "usuario", strategy = GenerationType.SEQUENCE)
	private Integer cdUsuario;

	@Column(name = "nm_usuario", length = 50, nullable = false)
	private String nomeUsuario;

	public Usuario() {

	}

	public Usuario(String nomeUsuario) {
		super();
		this.nomeUsuario = nomeUsuario;
	}

	public Usuario(Integer cdUsuario, String nomeUsuario) {
		super();
		this.cdUsuario = cdUsuario;
		this.nomeUsuario = nomeUsuario;
	}

	public Integer getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(Integer cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

}
