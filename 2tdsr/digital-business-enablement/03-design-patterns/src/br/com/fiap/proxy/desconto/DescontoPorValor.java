package br.com.fiap.proxy.desconto;

import java.math.BigDecimal;

import br.com.fiap.proxy.loja.Pedido;
import br.com.fiap.proxy.loja.PedidoInterface;

public class DescontoPorValor extends Desconto {

	public DescontoPorValor(Desconto proximo) {
		super(proximo);
	}

	@Override
	protected BigDecimal aplicar(Pedido pedido) {
		return pedido.getValor().multiply(new BigDecimal("0.1"));
	}

	@Override
	protected boolean deveAplicar(PedidoInterface pedido) {
		return pedido.getValor().compareTo(new BigDecimal("500")) > 0;
	}

	@Override
	protected BigDecimal aplicar(PedidoInterface pedido) {
		// TODO Auto-generated method stub
		return null;
	}

}
