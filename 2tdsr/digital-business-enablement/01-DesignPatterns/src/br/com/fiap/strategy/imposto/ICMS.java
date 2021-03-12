package br.com.fiap.strategy.imposto;

import java.math.BigDecimal;

import br.com.fiap.chainOfResponsability.loja.Pedido;

public class ICMS implements Imposto {

	@Override
	public BigDecimal calcular(Pedido pedido) {
		return pedido.getValor().multiply(new BigDecimal("0.1"));
	}

}
