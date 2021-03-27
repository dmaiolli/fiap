package br.com.fiap.decorator.loja.states;

import br.com.fiap.decorator.loja.PedidoInterface;
import br.com.fiap.decorator.loja.Situacao;

public class Aberto extends Situacao {

	@Override
	public void abrirChamado(PedidoInterface pedido) {
		System.out.println("Chamando para financeiro");
	}

	@Override
	public void pagar(PedidoInterface pedido) {
		pedido.setSituacao(new Pago());
	}

	@Override
	public void cancelar(PedidoInterface pedido) {
		pedido.setSituacao(new Cancelado());
	}

}
