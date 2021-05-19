package br.com.fiap.cp02.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.cp02.dao.MotoristaDao;
import br.com.fiap.cp02.entity.Motorista;

public class MotoristaDaoImpl extends GenericDaoImpl<Motorista, Integer> implements MotoristaDao {

	public MotoristaDaoImpl(EntityManager em) {
		super(em);
	}

}