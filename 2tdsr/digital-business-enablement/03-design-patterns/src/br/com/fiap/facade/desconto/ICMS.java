package br.com.fiap.facade.desconto;

import java.math.BigDecimal;

import br.com.fiap.facade.loja.PedidoInterface;

public class ICMS extends Imposto {

	public ICMS(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public BigDecimal calcularImposto(PedidoInterface pedido) {
		return pedido.getValor().multiply(new BigDecimal("0.1"));
	}

}
