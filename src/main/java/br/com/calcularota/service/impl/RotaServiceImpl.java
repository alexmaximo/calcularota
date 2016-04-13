package br.com.calcularota.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.calcularota.dao.RotaDao;
import br.com.calcularota.entities.Grafo;
import br.com.calcularota.entities.Mapa;
import br.com.calcularota.service.RotaService;
import org.apache.commons.collections.CollectionUtils;

public class RotaServiceImpl implements RotaService {

	@Inject
	private RotaDao rotaDao;

	@Override
	public List<Mapa> calcularRota(Mapa mapa) {
		List<Mapa> rotas = rotaDao.calcularRota(mapa);
		List<Mapa> rotaCalculada = new ArrayList<>();

		if (CollectionUtils.isEmpty(rotas)) {
			return rotaCalculada;
		}

		Mapa[] mapas = new Mapa[]{};
		
		Grafo grafo = new Grafo(rotas.toArray(mapas));
		grafo.dijkstra(mapa.getOrigem().toUpperCase());
		BigDecimal distanciaTotal = grafo.distanciaTotal(mapa.getDestino().toUpperCase());

		mapa.setDistanciaTotal(distanciaTotal);

		BigDecimal gastoTotal = mapa.getValorCombustivel().multiply(mapa.getDistanciaTotal()).divide(mapa.getAutonomia());

		mapa.setGastoTotal(gastoTotal.setScale(2, RoundingMode.FLOOR));
		
		rotaCalculada.add(mapa);
		
		return rotaCalculada;
	}

}
