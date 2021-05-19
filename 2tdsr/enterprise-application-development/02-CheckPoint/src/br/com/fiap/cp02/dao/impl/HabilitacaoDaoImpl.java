package br.com.fiap.cp02.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.cp02.dao.HabilitacaoDao;
import br.com.fiap.cp02.entity.Habilitacao;

public class HabilitacaoDaoImpl extends GenericDaoImpl<Habilitacao, Integer> implements HabilitacaoDao {

	public HabilitacaoDaoImpl(EntityManager em) {
		super(em);
	}

}