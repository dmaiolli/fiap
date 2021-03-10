package br.com.fiap.revisao.main;

import br.com.fiap.revisao.bean.Funcionario;
import br.com.fiap.revisao.dao.FuncionarioDAO;
import br.com.fiap.revisao.dao.FuncionarioMySqlDAO;

public class TesteInterfaces {

	public static void main(String[] args) {
		//Instanciar um objeto do tipo FuncionarioDao
		FuncionarioDAO dao = new FuncionarioMySqlDAO();
		dao.cadastrar(new Funcionario());
	}
	
}