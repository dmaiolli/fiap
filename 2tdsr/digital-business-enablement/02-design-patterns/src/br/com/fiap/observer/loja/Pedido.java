package br.com.fiap.observer.loja;

import java.math.BigDecimal;

import br.com.fiap.observer.loja.handler.PedidoHandler;
import br.com.fiap.observer.loja.states.Aberto;

public class Pedido {

	/*
	 * Estados
	 * 
	 * - aberto - pago - entregue - cancela
	 */

	// BigDecimal usado principalmente para valor monetário
	public BigDecimal valor;
	private int quantidadeDeItens;
	private Situacao situacao;
	public PedidoHandler handler;

	public void abrirChamado() {
		this.situacao.abrirChamado(this);
	}

	public Pedido(BigDecimal valor) {
		super();
		this.valor = valor;
		this.quantidadeDeItens = 1;
		this.situacao = new Aberto();
		this.handler = new PedidoHandler();
	}

	public Pedido(BigDecimal valor, int quantidadeDeItens) {
		super();
		this.valor = valor;
		this.quantidadeDeItens = quantidadeDeItens;
		this.situacao = new Aberto();
		this.handler = new PedidoHandler();
	}

	public int getQuantidadeDeItens() {
		return quantidadeDeItens;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		handler.notifyAll(this);
		this.situacao = situacao;
	}
	
	public void pagar() {
		this.situacao.pagar(this);
	}
	
	public void cancelar() {
		this.situacao.cancelar(this);
	}
	
	public void entregar() {
		this.situacao.entregar(this);
	}
	
	public void reabrir() {
		this.situacao.reabrir(this);
	}

}
