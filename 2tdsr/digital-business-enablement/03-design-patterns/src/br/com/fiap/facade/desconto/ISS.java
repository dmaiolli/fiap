package br.com.fiap.facade.desconto;

import java.math.BigDecimal;

import br.com.fiap.facade.loja.PedidoInterface;

public class ISS extends Imposto{

	public ISS(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public BigDecimal calcularImposto(PedidoInterface pedido) {
		return pedido.getValor().multiply(new BigDecimal("0.4"));
	}

}
