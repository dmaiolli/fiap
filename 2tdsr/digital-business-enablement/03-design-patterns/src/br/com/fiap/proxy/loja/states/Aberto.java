package br.com.fiap.proxy.loja.states;

import br.com.fiap.facade.loja.ChamadoFacade;
import br.com.fiap.facade.loja.PedidoInterface;
import br.com.fiap.facade.loja.Situacao;

public class Aberto extends Situacao {

	@Override
	public void abrirChamado(PedidoInterface pedido) {
		new ChamadoFacade().abrir(pedido);
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
