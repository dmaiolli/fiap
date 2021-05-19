package br.com.fiap.cp02.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.cp02.dao.CorridaDao;
import br.com.fiap.cp02.entity.Corrida;

public class CorridaDaoImpl extends GenericDaoImpl<Corrida, Integer> implements CorridaDao {

	public CorridaDaoImpl(EntityManager em) {
		super(em);
	}

}