package br.com.fiap.facade.loja.listener;

import br.com.fiap.facade.loja.PedidoInterface;
import br.com.fiap.facade.loja.listeners.PedidoListeners;

public class LogListener implements PedidoListeners{

	@Override
	public void update(PedidoInterface pedido) {
		System.out.println("Registrando logs");
	}

}
