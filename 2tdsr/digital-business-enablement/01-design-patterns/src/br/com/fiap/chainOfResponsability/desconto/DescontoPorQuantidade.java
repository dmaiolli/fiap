package br.com.fiap.chainOfResponsability.desconto;

import java.math.BigDecimal;

import br.com.fiap.chainOfResponsability.loja.Pedido;

public class DescontoPorQuantidade extends Desconto {

	public DescontoPorQuantidade(Desconto proximo) {
		super(proximo);
	}

	@Override
	public BigDecimal calcular(Pedido pedido) {
		if(pedido.getQuantidadeDeItens() > 10) { 
			return pedido.getValor().multiply(new BigDecimal("0.05")); 
		}
		
		return proximo.calcular(pedido);
	}

}
