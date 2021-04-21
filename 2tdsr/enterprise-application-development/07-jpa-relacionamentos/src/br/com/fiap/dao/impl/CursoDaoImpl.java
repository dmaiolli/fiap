package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CursoDao;
import br.com.fiap.entity.NanoCourses;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;

public class CursoDaoImpl extends GenericDaoImpl<NanoCourses, Integer> implements CursoDao{

	public CursoDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
