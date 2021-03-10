package br.com.fiap.exercicio.bean;

import java.util.Calendar;

import br.com.fiap.exercicio.exception.SaldoInsuficienteException;

// Classe abstrata -> não pode ser instanciada e PODE conter métodos abstratos

public abstract class Conta {

	private Integer agencia;
	private Integer numero;
	private Calendar dataAbertura;
	protected Double saldo;

	public Conta(Integer agencia, Integer numero, Calendar dataAbertura, Double saldo) {
		this.agencia = agencia;
		this.numero = numero;
		this.dataAbertura = dataAbertura;
		this.saldo = saldo;
	}

	public Conta() {}

	public void depositar(Double valor) {
		saldo += valor;
	}

	public abstract void retirar(Double valor) throws SaldoInsuficienteException;

	// Getters e setters
	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}
