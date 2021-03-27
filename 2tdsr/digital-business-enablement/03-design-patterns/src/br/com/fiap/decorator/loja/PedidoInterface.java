package br.com.fiap.decorator.loja;

import java.math.BigDecimal;

public interface PedidoInterface {

	void abrirChamado();

	String getEndereco();

	int getQuantidadeDeItens();

	BigDecimal getValor();

	Situacao getSituacao();

	void setSituacao(Situacao situacao);

	void pagar();

	void cancelar();

	void entregar();

	void reabrir();

}