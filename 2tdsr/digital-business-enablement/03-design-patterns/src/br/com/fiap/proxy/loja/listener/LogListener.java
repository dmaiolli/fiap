package br.com.fiap.proxy.loja.listener;

import br.com.fiap.proxy.loja.PedidoInterface;
import br.com.fiap.proxy.loja.listeners.PedidoListeners;

public class LogListener implements PedidoListeners{

	@Override
	public void update(PedidoInterface pedido) {
		System.out.println("Registrando logs");
	}

}
