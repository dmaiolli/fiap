package br.com.fiap.observer.desconto;

import java.math.BigDecimal;

import br.com.fiap.templateMethod.loja.Pedido;

public class TestaDesconto {

	public static void main(String[] args) {

		CalculadoraDeDesconto calcDesconto = new CalculadoraDeDesconto();
		Pedido ped = new Pedido(new BigDecimal("100"));
		Pedido pedido = new Pedido(new BigDecimal("600"), 20);

		BigDecimal desconto = calcDesconto.calcular(ped);
		BigDecimal descontoo = calcDesconto.calcular(pedido);

		System.out.println(desconto);
		System.out.println(descontoo);

	}
}
