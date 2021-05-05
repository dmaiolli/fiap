package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.entity.Cidade;

public class CidadeDAOImpl extends GenericDAOImpl<Cidade, Integer> implements CidadeDAO {

	public CidadeDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cidade> listar() {
		TypedQuery<Cidade> query = em.createQuery("from Cidade c", Cidade.class);

		return query.getResultList();
	}

	@Override
	public List<Cidade> buscaPorNumeroHabitantesMaior(int numeroHabitantes) {
		TypedQuery<Cidade> query = em.createQuery("from Cidade c where c.nrHabitantes > :nr",
				Cidade.class);
		
		query.setParameter("nr", numeroHabitantes);
		return query.getResultList();
	}

}
