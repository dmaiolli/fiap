package br.com.fiap.proxy.desconto;

import java.math.BigDecimal;

import br.com.fiap.proxy.loja.PedidoInterface;

public class DescontoPorQuantidade extends Desconto {

	public DescontoPorQuantidade(Desconto proximo) {
		super(proximo);
	}

	@Override
	public BigDecimal aplicar(PedidoInterface pedido) {
		return pedido.getValor().multiply(new BigDecimal("0.05")); 
	}

	@Override
	protected boolean deveAplicar(PedidoInterface pedido) {
		return pedido.getQuantidadeDeItens() > 10;
	}

}
