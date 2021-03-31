package br.com.fiap.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "TB_VEICULO")
@SequenceGenerator(sequenceName = "SQ_TB_VEICULO", name = "veiculo", allocationSize = 1)
public class Veiculo {

	@Id
	@Column(name = "cd_veiculo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "veiculo")
	private int codigoVeiculo;

	@Column(name = "ds_marca", nullable = false, length = 60)
	private String marca;

	@Column(name = "ds_cor", length = 20)
	private String cor;

	@Column(name = "dt_venda", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dtVenda;

	@Enumerated(EnumType.STRING)
	@Column(name = "ds_combustivel", nullable = false, length = 40)
	private Combustivel combustivel;

	@CreationTimestamp // Atribuir a data de nascimento automaticamente
	@Column(name = "dt_cadastro", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dtCadastro;

	@Column(name = "st_novo")
	private Boolean isNovo;

	public Veiculo() {
	}

	public Veiculo(String marca, String cor, Calendar dtVenda, Combustivel combustivel, Boolean isNovo) {
		super();
		this.marca = marca;
		this.cor = cor;
		this.dtVenda = dtVenda;
		this.combustivel = combustivel;
		this.isNovo = isNovo;
	}

	public Veiculo(int codigoVeiculo, String marca, String cor, Calendar dtVenda, Combustivel combustivel,
			Boolean isNovo) {
		super();
		this.codigoVeiculo = codigoVeiculo;
		this.marca = marca;
		this.cor = cor;
		this.dtVenda = dtVenda;
		this.combustivel = combustivel;
		this.isNovo = isNovo;
	}

	@PrePersist // Antes de cadastrar
	public void testeAntes() {
		System.out.println("Antes de cadastrar...");
	}
	
	@PostPersist // Antes de cadastrar
	public void testeDepos() {
		System.out.println("Depois de cadastrar...");
	}
	
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		return "Código: " + codigoVeiculo + "\nMarca: " + marca + "\nCor: " + cor + "\nCombustivel: " + combustivel
				+ "\nNovo: " + true + "\nData venda: " + sdf.format(dtVenda.getTime()) + "\nData Cadastro: "
				+ sdf.format(dtCadastro.getTime());
	}

	public int getCodigoVeiculo() {
		return codigoVeiculo;
	}

	public void setCodigoVeiculo(int codigoVeiculo) {
		this.codigoVeiculo = codigoVeiculo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Calendar getDtVenda() {
		return dtVenda;
	}

	public void setDtVenda(Calendar dtVenda) {
		this.dtVenda = dtVenda;
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}

	public Calendar getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Calendar dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Boolean getIsNovo() {
		return isNovo;
	}

	public void setIsNovo(Boolean isNovo) {
		this.isNovo = isNovo;
	}

}
