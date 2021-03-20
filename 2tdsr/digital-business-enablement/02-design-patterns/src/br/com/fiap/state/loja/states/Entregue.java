package br.com.fiap.state.loja.states;

import br.com.fiap.state.loja.Pedido;
import br.com.fiap.state.loja.Situacao;

public class Entregue extends Situacao {

	@Override
	public void abrirChamado(Pedido pedido) {
		System.out.println("Chamando pós venda");
	}

}
