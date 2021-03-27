package br.com.fiap.proxy.loja.handler;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.proxy.loja.PedidoInterface;
import br.com.fiap.proxy.loja.listeners.PedidoListeners;

public class PedidoHandler {

	private List<PedidoListeners> listeners;

	public PedidoHandler() {
		super();
	}

	public PedidoHandler(List<PedidoListeners> listeners) {
		super();
		this.listeners = new ArrayList<PedidoListeners>();
	}

	public void subscribe(PedidoListeners listener) {
		listeners.add(listener);
	}

	public void unsubscribe(PedidoListeners listener) {
		listeners.remove(listener);
	}

	public void notifyAll(PedidoInterface pedido) {
		listeners.forEach(listener -> listener.update(pedido));
	}

}
