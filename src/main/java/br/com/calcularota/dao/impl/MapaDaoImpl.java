package br.com.calcularota.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.calcularota.dao.ConnectionFactory;
import br.com.calcularota.dao.MapaDao;
import br.com.calcularota.entities.Mapa;

public class MapaDaoImpl implements MapaDao {

	@Inject
	private ConnectionFactory connectionFactory;

	public MapaDaoImpl() {
		super();
	}

	@Override
	public void save(Mapa mapa) {
		EntityManager manager = connectionFactory.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(mapa);
		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public void atualizar(Mapa mapa) {
		EntityManager manager = connectionFactory.getEntityManager();
		manager.getTransaction().begin();

		manager.merge(mapa);

		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public void excluir(Mapa mapa) {
		EntityManager manager = connectionFactory.getEntityManager();
		manager.getTransaction().begin();

		Mapa detached = manager.merge(mapa);
		manager.remove(detached);

		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public Mapa findMapa(Mapa mapa) {
		EntityManager manager = connectionFactory.getEntityManager();
		manager.getTransaction().begin();
		Mapa mapaFind = manager.find(Mapa.class, mapa.getId());
		manager.getTransaction().commit();
		manager.close();
		return mapaFind;
	}

	@Override
	public Mapa findMapaById(Integer id) {
		EntityManager manager = connectionFactory.getEntityManager();
		manager.getTransaction().begin();
		Mapa userFind = manager.find(Mapa.class, id);
		manager.getTransaction().commit();
		manager.close();
		return userFind;
	}

	@Override
	public List<Mapa> findAllMapas() {
		EntityManager manager = connectionFactory.getEntityManager();
		manager.getTransaction().begin();

		Query mapasQuery = manager.createQuery("select m from Mapa m");

		List<Mapa> listaMapas = mapasQuery.getResultList();

		manager.getTransaction().commit();
		manager.close();

		return listaMapas;
	}

}
