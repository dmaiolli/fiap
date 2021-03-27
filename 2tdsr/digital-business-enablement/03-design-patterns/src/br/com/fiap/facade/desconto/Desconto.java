package br.com.fiap.facade.desconto;

import java.math.BigDecimal;

import br.com.fiap.proxy.loja.Pedido;
import br.com.fiap.proxy.loja.PedidoInterface;

public abstract class Desconto {
	
	protected Desconto proximo;
	
	public Desconto(Desconto proximo) {
		this.proximo = proximo;
	}

	public BigDecimal calcular(PedidoInterface pedido) {
		if(deveAplicar(pedido)) {
			return aplicar(pedido);
		}
		
		return proximo.calcular(pedido);
	}

	protected abstract BigDecimal aplicar(PedidoInterface pedido);

	protected abstract boolean deveAplicar(PedidoInterface pedido);

	protected BigDecimal aplicar(Pedido pedido) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
