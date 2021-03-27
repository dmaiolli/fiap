package br.com.fiap.proxy.desconto;

import java.math.BigDecimal;

import br.com.fiap.proxy.loja.Pedido;
import br.com.fiap.proxy.loja.PedidoInterface;
import br.com.fiap.proxy.loja.PedidoProxy;

public class TestaSituacao {
	
	public static void main(String[] args) {
		
		PedidoInterface pedido = new PedidoProxy(new Pedido(new BigDecimal("10")));
		
		
		System.out.println(pedido.getEndereco());
	}

}
