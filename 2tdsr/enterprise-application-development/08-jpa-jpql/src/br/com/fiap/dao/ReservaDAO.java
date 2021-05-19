package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Reserva;

public interface ReservaDAO extends GenericDAO<Reserva,Integer>{

	List<Reserva> buscaPorReserva(String nome);
	
	List<Reserva> buscarPorPrecoPacote(float preco1, float preco2);
	
}
