package br.com.fiap.exercicio.bean;

import java.util.Calendar;

import br.com.fiap.exercicio.exception.SaldoInsuficienteException;

public class ContaCorrente extends Conta {

	private TipoConta tipo;

	@Override
	public void retirar(Double valor) throws SaldoInsuficienteException {
		if (this.tipo == TipoConta.COMUM && super.saldo - valor < 0) {
			throw new SaldoInsuficienteException("Saldo insuficiente");
		}
		saldo -= valor;
	}

	public ContaCorrente() {
	}

	public ContaCorrente(Integer agencia, Integer numero, Calendar dataAbertura, Double saldo, TipoConta tipo) {
		super(agencia, numero, dataAbertura, saldo);
		this.tipo = tipo;
	}

	public TipoConta getTipoConta() {
		return tipo;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipo = tipoConta;
	}

}
