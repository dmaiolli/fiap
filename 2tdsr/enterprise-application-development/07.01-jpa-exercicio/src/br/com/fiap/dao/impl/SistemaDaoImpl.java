package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.SistemaDao;
import br.com.fiap.entity.Sistema;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;

public class SistemaDaoImpl extends GenericDaoImpl<Sistema, Integer> implements SistemaDao{

	public SistemaDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
