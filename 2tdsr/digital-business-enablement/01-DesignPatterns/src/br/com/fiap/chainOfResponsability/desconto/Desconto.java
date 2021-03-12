package br.com.fiap.chainOfResponsability.desconto;

import java.math.BigDecimal;

import br.com.fiap.chainOfResponsability.loja.Pedido;

public abstract class Desconto {
	
	protected Desconto proximo;
	
	public Desconto(Desconto proximo) {
		this.proximo = proximo;
	}

	public abstract BigDecimal calcular(Pedido pedido);
	
}
