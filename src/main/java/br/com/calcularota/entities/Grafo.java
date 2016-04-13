package br.com.calcularota.entities;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Grafo {

	private final Map<String, Vertice> grafos;

	public Grafo(Mapa[] mapas) {
		grafos = new HashMap<>(mapas.length);

		for (Mapa mapa : mapas) {
			if (!grafos.containsKey(mapa.getOrigem()))
				grafos.put(mapa.getOrigem(), new Vertice(mapa.getOrigem()));
			if (!grafos.containsKey(mapa.getDestino()))
				grafos.put(mapa.getDestino(), new Vertice(mapa.getDestino()));
		}

		for (Mapa mapa : mapas) {
			grafos.get(mapa.getOrigem()).vizinhos.put(grafos.get(mapa.getDestino()), mapa.getDistancia());
		}
	}

	public void dijkstra(String origem) {
		if (!grafos.containsKey(origem)) {
			System.err.printf("Grafo não contém o vértice inicial \"%s\"\n", origem);
			return;
		}

		final Vertice source = grafos.get(origem);
		NavigableSet<Vertice> q = new TreeSet<>();

		for (Vertice v : grafos.values()) {
			v.anterior = v == source ? source : null;
			v.distanciaTotal = v == source ? new BigDecimal(0) : BigDecimal.valueOf(Double.MAX_VALUE);
			q.add(v);
		}

		dijkstra(q);
	}

	public void dijkstra(final NavigableSet<Vertice> q) {
		Vertice u, v;

		while (!q.isEmpty()) {

			u = q.pollFirst();

			if (u.distanciaTotal == BigDecimal.valueOf(Double.MAX_VALUE))
				break;

			for (Map.Entry<Vertice, BigDecimal> a : u.vizinhos.entrySet()) {
				v = a.getKey();

				final BigDecimal alternateDist = u.distanciaTotal.add(a.getValue());

				int resultado = alternateDist.compareTo(v.distanciaTotal);

				if (resultado == -1) {
					q.remove(v);
					v.distanciaTotal = alternateDist;
					v.anterior = u;
					q.add(v);
				}
			}
		}
	}

	public BigDecimal distanciaTotal(String destino) {
		if (!grafos.containsKey(destino)) {
			return new BigDecimal(0);
		}
		return grafos.get(destino).printPath();
	}

}