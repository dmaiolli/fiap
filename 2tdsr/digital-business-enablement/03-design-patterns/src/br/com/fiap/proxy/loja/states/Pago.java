package br.com.fiap.proxy.loja.states;

import br.com.fiap.proxy.loja.PedidoInterface;
import br.com.fiap.proxy.loja.Situacao;

public class Pago extends Situacao {

	@Override
	public void abrirChamado(PedidoInterface pedido) {
		System.out.println("Chamando para logistica");

	}

	@Override
	public void entregar(PedidoInterface pedido) {
		pedido.setSituacao(new Entregue());
	}

	@Override
	public void cancelar(PedidoInterface pedido) {
		pedido.setSituacao(new Cancelado());
	}

}
