package br.com.fiap.observer.loja.states;

import br.com.fiap.observer.loja.Pedido;
import br.com.fiap.observer.loja.Situacao;

public class Entregue extends Situacao {

	@Override
	public void abrirChamado(Pedido pedido) {
		System.out.println("Chamando pós venda");
	}

}
