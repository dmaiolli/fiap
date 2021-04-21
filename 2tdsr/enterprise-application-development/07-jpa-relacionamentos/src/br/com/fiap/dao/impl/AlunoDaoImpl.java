package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.AlunoDao;
import br.com.fiap.entity.Aluno;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;

public class AlunoDaoImpl extends GenericDaoImpl<Aluno, Integer> implements AlunoDao{

	public AlunoDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
