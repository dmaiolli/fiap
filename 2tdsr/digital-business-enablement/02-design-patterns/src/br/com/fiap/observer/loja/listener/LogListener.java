package br.com.fiap.observer.loja.listener;

import br.com.fiap.observer.loja.Pedido;
import br.com.fiap.observer.loja.listeners.PedidoListeners;

public class LogListener implements PedidoListeners{

	@Override
	public void update(Pedido pedido) {
		System.out.println("Registrando logs");
	}

}
