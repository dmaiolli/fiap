package br.com.fiap.decorator.loja.states;

import br.com.fiap.decorator.loja.PedidoInterface;
import br.com.fiap.decorator.loja.Situacao;

public class Cancelado extends Situacao {

	@Override
	public void abrirChamado(PedidoInterface pedido) {
		System.out.println("Chamando para comercial");

	}

	@Override
	public void reabrir(PedidoInterface pedido) {
		pedido.setSituacao(new Aberto());
	}

}
