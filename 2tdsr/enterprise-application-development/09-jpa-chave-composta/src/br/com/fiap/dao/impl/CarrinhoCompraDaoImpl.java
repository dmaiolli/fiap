package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CarrinhoCompraDao;
import br.com.fiap.entity.CarrinhoCompra;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;

public class CarrinhoCompraDaoImpl extends GenericDaoImpl<Integer, CarrinhoCompra> implements CarrinhoCompraDao{

	public CarrinhoCompraDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
