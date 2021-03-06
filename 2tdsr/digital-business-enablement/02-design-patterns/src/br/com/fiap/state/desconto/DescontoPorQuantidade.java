package br.com.fiap.state.desconto;

import java.math.BigDecimal;

import br.com.fiap.templateMethod.loja.Pedido;

public class DescontoPorQuantidade extends Desconto {

	public DescontoPorQuantidade(Desconto proximo) {
		super(proximo);
	}

	@Override
	public BigDecimal aplicar(Pedido pedido) {
		return pedido.getValor().multiply(new BigDecimal("0.05")); 
	}

	@Override
	protected boolean deveAplicar(Pedido pedido) {
		return pedido.getQuantidadeDeItens() > 10;
	}

}
