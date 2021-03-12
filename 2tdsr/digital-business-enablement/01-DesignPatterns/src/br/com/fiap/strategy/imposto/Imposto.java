package br.com.fiap.strategy.imposto;

import java.math.BigDecimal;

import br.com.fiap.chainOfResponsability.loja.Pedido;

public interface Imposto {
	
	public BigDecimal calcular(Pedido pedido);

}
