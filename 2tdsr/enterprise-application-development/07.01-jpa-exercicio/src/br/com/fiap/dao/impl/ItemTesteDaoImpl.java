package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ItemTesteDao;
import br.com.fiap.entity.ItemTeste;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;

public class ItemTesteDaoImpl extends GenericDaoImpl<ItemTeste, Integer> implements ItemTesteDao {

	public ItemTesteDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
