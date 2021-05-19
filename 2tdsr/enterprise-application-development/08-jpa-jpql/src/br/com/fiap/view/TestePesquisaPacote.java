package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;
import br.com.fiap.singleton.EntityManagerFactorySingleton;
import br.com.fiap.util.DataUtil;

public class TestePesquisaPacote {

	public static void main(String[] args) {

		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		PacoteDAO pacoteDao = new PacoteDAOImpl(em);
		TransporteDAO transporteDao = new TransporteDAOImpl(em);

		List<Pacote> pacotes = pacoteDao.todosPacotesPorUmTransporte(transporteDao.pesquisar(1));

		for (Pacote pacote : pacotes) {
			System.out.println(pacote.getDescricao());
		}

		List<Object[]> listaObjetos = pacoteDao.buscarPorPrecoMenor(1000);
		listaObjetos.forEach(vetor -> System.out.println(vetor[0] + " " + vetor[1]));

		List<Pacote> listaPacotes = pacoteDao.buscarPorPrecoMenor2(1000);
		listaPacotes.forEach(pac -> System.out.println(pac.getDescricao() + " " + pac.getQtdDias()));

		List<String> listaString = pacoteDao.buscarPorPrecoMenor3(1000);
		listaString.forEach(str -> System.out.println(str));

		Calendar inicio = new GregorianCalendar(2020, Calendar.JANUARY, 1);
		Calendar fim = new GregorianCalendar(2020, Calendar.DECEMBER, 1);
		pacotes = pacoteDao.buscarPorDatas(inicio, fim);
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " " + DataUtil.formatar(p.getDataSaida())));

		Transporte transporte = transporteDao.pesquisar(1);
		double soma = pacoteDao.somarPrecosPorTransporte(transporte);
		System.out.println(soma);

		listaPacotes = pacoteDao.buscarPorQtdDiasMaiorEPrecoMenor(15, 100);
		pacotes.forEach(p -> System.out
				.println(p.getDescricao() + " " + p.getQtdDias() + " " + DataUtil.formatar(p.getDataSaida())));

		em.close();
		EntityManagerFactorySingleton.getInstance().close();

	}

}
