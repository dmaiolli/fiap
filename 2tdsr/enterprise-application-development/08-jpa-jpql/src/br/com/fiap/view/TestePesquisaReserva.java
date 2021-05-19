package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.dao.impl.ReservaDAOImpl;
import br.com.fiap.entity.Reserva;
import br.com.fiap.singleton.EntityManagerFactorySingleton;
import br.com.fiap.util.DataUtil;

public class TestePesquisaReserva {

	public static void main(String[] args) {

		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		ReservaDAO reservaDao = new ReservaDAOImpl(em);

		List<Reserva> reservas = reservaDao.buscaPorReserva("a");
		for (Reserva reserva : reservas) {
			System.out.println(" desc " + reserva.getPacote().getDescricao() + " nome " + reserva.getCliente().getNome()
					+ " data " + DataUtil.formatar(reserva.getDataReserva()));
		}

		reservas = reservaDao.buscarPorPrecoPacote(10, 1000);
		for (Reserva reserva : reservas) {
			System.out.println(" desc " + reserva.getPacote().getDescricao() + " nome " + reserva.getCliente().getNome()
					+ " data " + DataUtil.formatar(reserva.getDataReserva()));
		}
	}

}
