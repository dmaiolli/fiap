package br.com.fiap.proxy.desconto;

import java.math.BigDecimal;

import br.com.fiap.proxy.loja.PedidoInterface;

public class SemDesconto extends Desconto {

	public SemDesconto() {
		super(null);
	}

	@Override
	public BigDecimal aplicar(PedidoInterface pedido) {
		return BigDecimal.ZERO;
	}

	@Override
	protected boolean deveAplicar(PedidoInterface pedido) {
		return true;
	}

}
