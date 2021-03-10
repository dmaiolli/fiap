package br.com.fiap.exercicio.bean;

import java.util.Calendar;

import br.com.fiap.exercicio.exception.SaldoInsuficienteException;

public class ContaPoupanca extends Conta implements ContaInvestimento {

	public Float taxa;
	public static final Float RENDIMENTO = 0.04f;

	@Override
	public final double calculaRetornoInvestimento() {
		return saldo * RENDIMENTO;
	}

	@Override
	public void retirar(Double valor) throws SaldoInsuficienteException {
		if (valor + taxa > saldo) {
			throw new SaldoInsuficienteException("Saldo insuficiente");
		}

		saldo -= valor + taxa;
	}

	public ContaPoupanca() {
	}

	public ContaPoupanca(Integer agencia, Integer numero, Calendar dataAbertura, Double saldo, Float taxa) {
		super(agencia, numero, dataAbertura, saldo);
		this.taxa = taxa;
	}

}
