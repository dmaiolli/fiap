package br.com.fiap.exercicio.main;

import br.com.fiap.exercicio.bean.Aluno;
import br.com.fiap.exercicio.orm.Orm;

public class Teste {

	public static void main(String[] args) {

		Aluno aluno = new Aluno();

		Orm orm = new Orm();
		
		System.out.println(orm.gerarPesquisa(aluno));
	}

}
