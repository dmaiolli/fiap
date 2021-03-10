package br.com.fiap.revisao.bean;

import java.util.Calendar;

public class Conta {
	
	public Integer agencia;
	public Integer numero;
	public Calendar dataAbertura;
	public Double saldo;
	
	public Conta(Integer agencia, Integer numero, Calendar dataAbertura, Double saldo) {
		super();
		this.agencia = agencia;
		this.numero = numero;
		this.dataAbertura = dataAbertura;
		this.saldo = 0.0;
	}
	
	public void depositar(Double valor) {
		this.saldo += valor;
	}
	
	public void retirar(Double valor) {
		this.saldo -= valor;
	}

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
