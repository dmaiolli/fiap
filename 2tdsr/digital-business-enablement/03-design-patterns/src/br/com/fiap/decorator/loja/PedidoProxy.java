package br.com.fiap.decorator.loja;

import java.math.BigDecimal;

public class PedidoProxy implements PedidoInterface {
	
	private Pedido pedido;
	private String endereco;
	
	public PedidoProxy(Pedido pedido) {
		super();
		this.pedido = pedido;
	}

	public String getEndereco() {
		if(endereco == null) {
			endereco = pedido.getEndereco();
		}
		return endereco;
	}

	public void abrirChamado() {
		pedido.abrirChamado();
	}

	public int getQuantidadeDeItens() {
		return pedido.getQuantidadeDeItens();
	}

	public BigDecimal getValor() {
		return pedido.getValor();
	}

	public Situacao getSituacao() {
		return pedido.getSituacao();
	}

	public void setSituacao(Situacao situacao) {
		pedido.setSituacao(situacao);
	}

	public void pagar() {
		pedido.pagar();
	}

	public void cancelar() {
		pedido.cancelar();
	}

	public void entregar() {
		pedido.entregar();
	}

	public void reabrir() {
		pedido.reabrir();
	}	
	
	
	
}