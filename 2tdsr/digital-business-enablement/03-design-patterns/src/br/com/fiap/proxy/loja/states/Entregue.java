package br.com.fiap.proxy.loja.states;

import br.com.fiap.proxy.loja.PedidoInterface;
import br.com.fiap.proxy.loja.Situacao;

public class Entregue extends Situacao {

	@Override
	public void abrirChamado(PedidoInterface pedido) {
		System.out.println("Chamando pós venda");
	}

}
