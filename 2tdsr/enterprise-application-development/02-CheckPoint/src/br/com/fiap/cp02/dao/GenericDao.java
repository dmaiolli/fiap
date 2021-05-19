package br.com.fiap.cp02.dao;

import br.com.fiap.cp02.exception.CommitException;
import br.com.fiap.cp02.exception.EntityNotFoundException;

public interface GenericDao<E, K> {
	
	void inserir(E entidade);
	
	E consultar(K id) throws EntityNotFoundException;

	void atualizar(E entidade);
	
	void excluir(K id) throws EntityNotFoundException;
	
	void commit() throws CommitException;
	
}