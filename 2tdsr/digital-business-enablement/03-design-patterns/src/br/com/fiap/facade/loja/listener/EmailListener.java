package br.com.fiap.facade.loja.listener;

import br.com.fiap.facade.loja.PedidoInterface;
import br.com.fiap.facade.loja.listeners.PedidoListeners;

public class EmailListener implements PedidoListeners {

	@Override
	public void update(PedidoInterface pedido) {
		System.out.println("Mandando email");
	}

}
