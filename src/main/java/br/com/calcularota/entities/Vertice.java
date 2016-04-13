package br.com.calcularota.entities;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Vertice implements Comparable<Vertice> {

	public final String name;
	public BigDecimal distanciaTotal = BigDecimal.valueOf(Double.MAX_VALUE);
	public Vertice anterior = null;
	public final Map<Vertice, BigDecimal> vizinhos = new HashMap<>();

	public Vertice(String name) {
		this.name = name;
	}

	public BigDecimal printPath() {
		return this.distanciaTotal;
	}

	public int compareTo(Vertice other) {
		return distanciaTotal.compareTo(other.distanciaTotal);
	}
}