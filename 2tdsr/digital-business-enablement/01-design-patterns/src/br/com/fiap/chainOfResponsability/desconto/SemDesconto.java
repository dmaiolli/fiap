package br.com.fiap.chainOfResponsability.desconto;

import java.math.BigDecimal;

import br.com.fiap.chainOfResponsability.loja.Pedido;

public class SemDesconto extends Desconto {

	public SemDesconto() {
		super(null);
	}

	@Override
	public BigDecimal calcular(Pedido pedido) {
		return BigDecimal.ZERO;
	}

}
