package br.com.fiap.exercicio.orm;

import br.com.fiap.exercicio.annotation.Tabela;

public class Orm {

	public String gerarPesquisa(Object object) {
		Tabela tabela = object.getClass().getAnnotation(Tabela.class);
		
		return "SELECT * FROM " + tabela.nome();
	}

}
