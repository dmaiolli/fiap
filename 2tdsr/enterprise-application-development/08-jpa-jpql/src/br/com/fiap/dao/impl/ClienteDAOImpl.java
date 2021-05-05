package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente, Integer> implements ClienteDAO {

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> todosClientesDeUmEstado(String estado) {
		TypedQuery<Cliente> query = em.createQuery("from Cliente c where c.endereco.cidade.uf = :endereco",
				Cliente.class);
		query.setParameter("endereco", estado);
		return query.getResultList();
	}

	@Override
	public List<Cliente> pesquisaClientePorParteNome(String nome) {
		TypedQuery<Cliente> query = em.createQuery("from Cliente c where c.nome like :ptNome", Cliente.class);
		query.setParameter("ptNome", "%" + nome + "%");
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorDiasReserva(Integer dias) {
		TypedQuery<Cliente> query = em.createQuery("select r.cliente from Reserva r where r.numeroDias = :d",
				Cliente.class);
		query.setParameter("d", dias);
		return query.getResultList();
	}

}
