package br.com.fiap.revisao.dao;

import java.util.List;
import br.com.fiap.revisao.bean.Funcionario;

public interface FuncionarioDAO {

	void cadastrar(Funcionario funcionario);
	
	List<Funcionario> listar();
	
}