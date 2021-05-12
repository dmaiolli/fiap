package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public interface PacoteDAO extends GenericDAO<Pacote,Integer>{

	List<Pacote> todosPacotesPorUmTransporte(Transporte transporte);
	

	// Buscar pacotes por preço menor, retornando a descricao e a qtd dias ( List<Object[]>)
	List<Object[]> buscarPorPrecoMenor(float preco);
	
	// Buscar pacotes por preço menor, retornando a descricao e a qtd dias ( List<Pacote>)
	List<Pacote> buscarPorPrecoMenor2(float preco);
	
	// Buscar por preço menor, retornando somente a descrição (List<String>)
	List<String> buscarPorPrecoMenor3(float preco);
	
	List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim);
	
}
