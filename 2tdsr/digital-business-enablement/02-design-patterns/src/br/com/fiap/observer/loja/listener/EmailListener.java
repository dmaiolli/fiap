package br.com.fiap.observer.loja.listener;

import br.com.fiap.observer.loja.Pedido;
import br.com.fiap.observer.loja.listeners.PedidoListeners;

public class EmailListener implements PedidoListeners {

	@Override
	public void update(Pedido pedido) {
		System.out.println("Mandando email");
	}

}
