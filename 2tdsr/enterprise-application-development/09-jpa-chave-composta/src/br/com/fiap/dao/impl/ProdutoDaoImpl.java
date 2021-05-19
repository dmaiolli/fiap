package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ProdutoDao;
import br.com.fiap.entity.Produto;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;

public class ProdutoDaoImpl extends GenericDaoImpl<Integer, Produto> implements ProdutoDao {

	public ProdutoDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
