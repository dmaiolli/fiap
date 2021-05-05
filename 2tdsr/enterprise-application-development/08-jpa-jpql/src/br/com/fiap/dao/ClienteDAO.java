package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{
	
	List<Cliente> pesquisaClientePorParteNome(String nome);

	List<Cliente> todosClientesDeUmEstado(String estado);
	
	List<Cliente> buscarPorDiasReserva(Integer dias);

}
