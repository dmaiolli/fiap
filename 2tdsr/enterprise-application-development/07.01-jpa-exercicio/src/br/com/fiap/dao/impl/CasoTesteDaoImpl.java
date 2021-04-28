package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CasoTesteDao;
import br.com.fiap.entity.CasoTeste;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;

public class CasoTesteDaoImpl extends GenericDaoImpl<CasoTeste, Integer> implements CasoTesteDao{

	public CasoTesteDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
