package br.com.fiap.mapeando.main;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.mapeando.annotation.Coluna;
import br.com.fiap.mapeando.bean.Pedido;

public class Teste {

	public static void main(String[] args) {
		// Instanciar um pedido
		Pedido pedido = new Pedido();

		// API de Reflection para obter a estrutura da classe
		String nome = pedido.getClass().getName();
		System.out.println(nome);

		// Obter os métodos da classe
		Method[] metodos = pedido.getClass().getMethods();
		System.out.println(metodos);

		// Exibir o nome dos métodos
		for (Method m : metodos) {
			System.out.println(m.getName());
		}

		// Obter os atributos
		Field[] fields = pedido.getClass().getDeclaredFields();

		// Exibir o nome dos atributos
		for (Field f : fields) {
			System.out.println(f.getName() + " - " + f.getType());

			// Obter a a anotação @Coluna
			Coluna anotacao = f.getAnnotation(Coluna.class);

			// Exibir os parâmetoros da anotação
			System.out.println(anotacao);
		}

	}

}
