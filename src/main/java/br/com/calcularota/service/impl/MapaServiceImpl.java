package br.com.calcularota.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.calcularota.dao.MapaDao;
import org.apache.commons.collections.CollectionUtils;

import br.com.calcularota.entities.Mapa;
import br.com.calcularota.service.MapaService;

public class MapaServiceImpl implements MapaService {

	@Inject
	private MapaDao mapaDao;

	@Override
	public void save(Mapa mapa) {
		mapa.setMapa(mapa.getMapa().toUpperCase());
		mapa.setOrigem(mapa.getOrigem().toUpperCase());
		mapa.setDestino(mapa.getDestino().toUpperCase());

		mapaDao.save(mapa);
	}

	@Override
	public void atualizar(Mapa mapa) {

		mapa.setMapa(mapa.getMapa().toUpperCase());
		mapa.setOrigem(mapa.getOrigem().toUpperCase());
		mapa.setDestino(mapa.getDestino().toUpperCase());

		mapaDao.atualizar(mapa);
	}

	@Override
	public void excluir(Mapa mapa) {
		mapaDao.excluir(mapa);
	}

	@Override
	public Mapa findMapa(Mapa mapa) {
		return mapaDao.findMapa(mapa);
	}

	@Override
	public Mapa findMapaById(Integer id) {
		return mapaDao.findMapaById(id);
	}

	@Override
	public List<Mapa> findAllMapas() {
		List<Mapa> mapas = mapaDao.findAllMapas();

		if (CollectionUtils.isEmpty(mapas)) {
			mapas = new ArrayList<>();
		}

		return mapas;
	}

}
