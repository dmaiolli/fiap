package br.com.fiap.decorator.loja.listener;

import br.com.fiap.decorator.loja.PedidoInterface;
import br.com.fiap.decorator.loja.listeners.PedidoListeners;

public class EmailListener implements PedidoListeners {

	@Override
	public void update(PedidoInterface pedido) {
		System.out.println("Mandando email");
	}

}
