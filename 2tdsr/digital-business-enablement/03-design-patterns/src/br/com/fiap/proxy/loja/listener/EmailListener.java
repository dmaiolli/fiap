package br.com.fiap.proxy.loja.listener;

import br.com.fiap.proxy.loja.PedidoInterface;
import br.com.fiap.proxy.loja.listeners.PedidoListeners;

public class EmailListener implements PedidoListeners {

	@Override
	public void update(PedidoInterface pedido) {
		System.out.println("Mandando email");
	}

}
