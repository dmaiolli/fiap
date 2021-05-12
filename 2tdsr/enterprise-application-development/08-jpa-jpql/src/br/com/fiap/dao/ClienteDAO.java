package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente, Integer> {

	List<Cliente> pesquisaClientePorParteNome(String nome);

	List<Cliente> todosClientesDeUmEstado(String estado);

	List<Cliente> buscarPorDiasReserva(Integer dias);

	// retorna os clientes que possuam parte do nome o texto informado como
	// parâmetro e que tenham algum endereço por parte do nome de cidade informado;
	List<Cliente> buscar(String nome, String cidade);
	
	List<Cliente> buscarPorEstados(List<String> estados);
	
	List<Cliente> buscarPorNome2(String nome);
	
	long contarPorEstado(String estado);

}
