package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GrupoChallengeDao;
import br.com.fiap.entity.GrupoChallenge;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;

public class GrupoChallengeDaoImpl extends GenericDaoImpl<GrupoChallenge, Integer> implements GrupoChallengeDao {

	public GrupoChallengeDaoImpl(EntityManager em) {
		super(em);
	}

}
