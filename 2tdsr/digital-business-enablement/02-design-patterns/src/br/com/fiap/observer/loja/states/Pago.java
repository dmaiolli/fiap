package br.com.fiap.observer.loja.states;

import br.com.fiap.observer.loja.Pedido;
import br.com.fiap.observer.loja.Situacao;

public class Pago extends Situacao {

	@Override
	public void abrirChamado(Pedido pedido) {
		System.out.println("Chamando para logistica");

	}

	@Override
	public void entregar(Pedido pedido) {
		pedido.setSituacao(new Entregue());
	}

	@Override
	public void cancelar(Pedido pedido) {
		pedido.setSituacao(new Cancelado());
	}

}
