package br.com.fiap.facade.loja;

import java.math.BigDecimal;

import br.com.fiap.facade.loja.handler.PedidoHandler;
import br.com.fiap.facade.loja.states.Aberto;

public class Pedido implements PedidoInterface {

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

	@Override
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
	
	@Override
	public String getEndereco() {
		return "";
	}

	@Override
	public int getQuantidadeDeItens() {
		return quantidadeDeItens;
	}

	@Override
	public BigDecimal getValor() {
		return valor;
	}

	@Override
	public Situacao getSituacao() {
		return situacao;
	}

	@Override
	public void setSituacao(Situacao situacao) {
		handler.notifyAll(this);
		this.situacao = situacao;
	}
	
	@Override
	public void pagar() {
		this.situacao.pagar(this);
	}
	
	@Override
	public void cancelar() {
		this.situacao.cancelar(this);
	}
	
	@Override
	public void entregar() {
		this.situacao.entregar(this);
	}
	
	@Override
	public void reabrir() {
		this.situacao.reabrir(this);
	}

}
