package br.com.fiap.state.loja.states;

import br.com.fiap.state.loja.Pedido;
import br.com.fiap.state.loja.Situacao;

public class Cancelado extends Situacao {

	@Override
	public void abrirChamado(Pedido pedido) {
		System.out.println("Chamando para comercial");

	}

	@Override
	public void reabrir(Pedido pedido) {
		pedido.setSituacao(new Aberto());
	}

}
