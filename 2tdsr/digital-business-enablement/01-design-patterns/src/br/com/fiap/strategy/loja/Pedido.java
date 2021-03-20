package br.com.fiap.strategy.loja;

import java.math.BigDecimal;

public class Pedido {
	
	// BigDecimal usado principalmente para valor monetário
	public BigDecimal valor;

	public Pedido(BigDecimal valor) {
		super();
		this.valor = valor;
	}

	public BigDecimal getValor() {
		return valor;
	}
	
}
