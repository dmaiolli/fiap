package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "TAB_PRODUTO")
@SequenceGenerator(sequenceName = "SEQ_TAB_PRODUTO", name = "produto", allocationSize = 1)
// sequenceName -> nome da sequence no banco de dados
// name -> nome da sequence no java utilizado no "generator"
// allocationSize -> Incremento
public class Produto {

	@Id
	@Column(name = "cd_produto")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
	private int codigo;

	@Column(name = "nm_produto", length = 80, nullable = false)
	private String nome;

	@Column(name = "vl_produto", nullable = false)
	private double valor;

	@Temporal(value = TemporalType.DATE) // Determina oque será persistido (data, hora, dia...)
	@Column(name = "dt_entrada", nullable = false)
	private Calendar dataEntrada;

	// Atributo que não é uma coluna no banco de dados
	@Transient
	private int tempo;

	@Column(name = "fl_foto")
	@Lob // Camp BLOB no oracle, para armazenar arquivos
	private byte[] foto;

	@Column(name = "ds_status")
	// Por padrão, enums serão salvos com sua posição 0, 1, 2...
	// String -> será salvo como Varchar, o próprio nome que está no Enum
	@Enumerated(EnumType.STRING)
	private Status status;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Calendar getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
