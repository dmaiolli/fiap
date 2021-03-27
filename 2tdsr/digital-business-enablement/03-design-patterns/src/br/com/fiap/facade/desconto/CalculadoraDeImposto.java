package br.com.fiap.facade.desconto;

import java.math.BigDecimal;

import br.com.fiap.facade.loja.Pedido;

public class CalculadoraDeImposto {
	
	private Imposto imposto;
	
	public CalculadoraDeImposto(Imposto imposto) {
		super();
		this.imposto = imposto;
	}

	public BigDecimal calcular(Pedido pedido) {
		return imposto.calcular(pedido);
	}
	
	public Imposto getImposto() {
		return imposto;
	}

	public void setImposto(Imposto imposto) {
		this.imposto = imposto;
	}
	
}
