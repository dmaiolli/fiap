package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.entity.Usuario;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;

public class UsuarioDaoImpl extends GenericDaoImpl<Usuario, Integer> implements UsuarioDao{

	public UsuarioDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
