package br.com.fiap.decorator.loja.states;

import br.com.fiap.decorator.loja.PedidoInterface;
import br.com.fiap.decorator.loja.Situacao;

public class Entregue extends Situacao {

	@Override
	public void abrirChamado(PedidoInterface pedido) {
		System.out.println("Chamando pós venda");
	}

}
