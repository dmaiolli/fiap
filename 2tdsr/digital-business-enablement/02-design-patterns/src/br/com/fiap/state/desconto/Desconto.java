package br.com.fiap.state.desconto;

import java.math.BigDecimal;

import br.com.fiap.templateMethod.loja.Pedido;

public abstract class Desconto {
	
	protected Desconto proximo;
	
	public Desconto(Desconto proximo) {
		this.proximo = proximo;
	}

	public BigDecimal calcular(Pedido pedido) {
		if(deveAplicar(pedido)) {
			return aplicar(pedido);
		}
		
		return proximo.calcular(pedido);
	}

	protected abstract BigDecimal aplicar(Pedido pedido);

	protected abstract boolean deveAplicar(Pedido pedido);
	
}
