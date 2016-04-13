package br.com.calcularota.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.calcularota.dao.ConnectionFactory;
import br.com.calcularota.dao.RotaDao;
import br.com.calcularota.entities.Mapa;

public class RotaDaoImpl implements RotaDao {

	@Inject
	private ConnectionFactory connectionFactory;

	@Override
	public List<Mapa> calcularRota(Mapa mapa) {
		EntityManager manager = connectionFactory.getEntityManager();

		StringBuilder sql = new StringBuilder("select m from Mapa m where m.mapa = :mapa");
		
		Query query = manager.createQuery(sql.toString());
		query.setParameter("mapa", mapa.getMapa().toUpperCase());
		
		return query.getResultList();
	}

}
