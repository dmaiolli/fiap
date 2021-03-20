package br.com.fiap.observer.loja.listeners;

import br.com.fiap.observer.loja.Pedido;

public interface PedidoListeners {
	public abstract void update(Pedido pedido);
}
