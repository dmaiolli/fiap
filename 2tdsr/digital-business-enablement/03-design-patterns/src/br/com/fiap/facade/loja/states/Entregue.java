package br.com.fiap.facade.loja.states;

import br.com.fiap.facade.loja.PedidoInterface;
import br.com.fiap.facade.loja.Situacao;

public class Entregue extends Situacao {

	@Override
	public void abrirChamado(PedidoInterface pedido) {
		System.out.println("Chamando pós venda");
	}

}
