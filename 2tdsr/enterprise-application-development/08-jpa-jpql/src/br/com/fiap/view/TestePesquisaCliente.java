package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class TestePesquisaCliente {

	public static void main(String[] args) {

		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		ClienteDAO clienteDao = new ClienteDAOImpl(em);

		List<Cliente> clientes = clienteDao.listar();
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());
		}

		List<Cliente> clientesPorParteNome = clienteDao.pesquisaClientePorParteNome("a");
		clientesPorParteNome.forEach(c -> System.out.println(c.getNome()));

		List<Cliente> clientesDeUmEstado = clienteDao.todosClientesDeUmEstado("SP");
		for (Cliente cliente : clientesDeUmEstado) {
			System.out.println(cliente.getNome());
		}

		List<Cliente> clientesPorReserva = clienteDao.buscarPorDiasReserva(5);
		for (Cliente cliente : clientesPorReserva) {
			System.out.println(cliente.getNome());
		}

		em.close();
		EntityManagerFactorySingleton.getInstance().close();

	}

}
