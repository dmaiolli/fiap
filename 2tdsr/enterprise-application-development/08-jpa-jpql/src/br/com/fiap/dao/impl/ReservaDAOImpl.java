package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.entity.Reserva;

public class ReservaDAOImpl extends GenericDAOImpl<Reserva, Integer> implements ReservaDAO {

	public ReservaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Reserva> buscaPorReserva(String nome) {
		return em.createNamedQuery("Reserva.porNomeCliente", Reserva.class).setParameter("pNome", "%" + nome + "%")
				.getResultList();
	}

	@Override
	public List<Reserva> buscarPorPrecoPacote(float preco1, float preco2) {
		return em.createNamedQuery("Reserva.PorPorPrecoPacoteEntreDoisValores", Reserva.class)
				.setParameter("vlInicial", preco1).setParameter("vlFinal", preco2).getResultList();
	}

}
