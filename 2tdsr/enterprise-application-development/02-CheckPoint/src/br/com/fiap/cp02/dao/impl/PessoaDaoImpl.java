package br.com.fiap.cp02.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.cp02.dao.PessoaDao;
import br.com.fiap.cp02.entity.Pessoa;

public class PessoaDaoImpl extends GenericDaoImpl<Pessoa, Integer> implements PessoaDao {

	public PessoaDaoImpl(EntityManager em) {
		super(em);
	}

}