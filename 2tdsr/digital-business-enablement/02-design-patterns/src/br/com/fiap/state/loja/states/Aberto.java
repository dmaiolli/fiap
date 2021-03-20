package br.com.fiap.state.loja.states;

import br.com.fiap.state.loja.Pedido;
import br.com.fiap.state.loja.Situacao;

public class Aberto extends Situacao {

	@Override
	public void abrirChamado(Pedido pedido) {
		System.out.println("Chamando para financeiro");
	}

	@Override
	public void pagar(Pedido pedido) {
		pedido.setSituacao(new Pago());
	}

	@Override
	public void cancelar(Pedido pedido) {
		pedido.setSituacao(new Cancelado());
	}

}
