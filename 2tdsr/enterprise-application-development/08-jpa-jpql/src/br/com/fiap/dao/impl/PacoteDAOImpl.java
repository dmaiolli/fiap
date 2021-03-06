package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Reserva;
import br.com.fiap.entity.Transporte;

public class PacoteDAOImpl extends GenericDAOImpl<Pacote, Integer> implements PacoteDAO {

	public PacoteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Pacote> todosPacotesPorUmTransporte(Transporte transporte) {
		TypedQuery<Pacote> query = em.createQuery("from Pacote p where p.transporte = :transporte", Pacote.class);
		query.setParameter("transporte", transporte);
		return query.getResultList();
	}

	@Override
	public List<Object[]> buscarPorPrecoMenor(float preco) {
		return em.createQuery("select p.descricao, p.qtdDias from Pacote p where p.preco < :preco", Object[].class)
				.setParameter("preco", preco).getResultList();
	}

	@Override
	public List<Pacote> buscarPorPrecoMenor2(float preco) {
		return em.createQuery("select new Pacote(p.descricao, p.qtdDias) from Pacote p where p.preco < :preco",
				Pacote.class).setParameter("preco", preco).getResultList();
	}

	@Override
	public List<String> buscarPorPrecoMenor3(float preco) {
		return em.createQuery("select p.descricao from Pacote p where p.preco < :preco", String.class)
				.setParameter("preco", preco).getResultList();
	}

	@Override
	public List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim) {
		return em.createQuery("from Pacote p where p.dataSaida between :dtInicio and :dtFim", Pacote.class)
				.setParameter("dtInicio", inicio).setParameter("dtFim", fim).getResultList();
	}

	@Override
	public double somarPrecosPorTransporte(Transporte transporte) {
		return em.createQuery("select sum(p.preco) from Pacote p where p.transporte = :pTransporte", Double.class)
				.setParameter("pTransporte", transporte).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pacote> buscarPorQtdDiasMaiorEPrecoMenor(int qtd, float preco) {
		return em.createNativeQuery("SELECT * FROM TB_EAD_PACOTE p WHERE p.qt_dias > :qtd AND p.vl_pacote < :preco",
				Pacote.class).setParameter("qtd", qtd).setParameter("preco", preco).getResultList();
	}

}
