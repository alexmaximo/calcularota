package br.com.calcularota.service;

import java.math.BigDecimal;

import br.com.calcularota.entities.Grafo;
import br.com.calcularota.entities.Mapa;

public class Calcular {

	private static final Mapa[] GRAPH = { new Mapa("SP", "a", "b", new BigDecimal("7.00")),
			new Mapa("SP", "a", "c", new BigDecimal("9.00")),
			new Mapa("SP", "a", "f", new BigDecimal("14.00")),
			new Mapa("SP", "b", "c", new BigDecimal("10.00")),
			new Mapa("SP", "b", "d", new BigDecimal("15.00")),
			new Mapa("SP", "c", "d", new BigDecimal("11.00")),
			new Mapa("SP", "c", "f", new BigDecimal("2.00")),
			new Mapa("SP", "d", "e", new BigDecimal("6.00")),
			new Mapa("SP", "e", "f", new BigDecimal("9.00")) };

	private static final String START = "a";
	private static final String END = "e";

	public static void main(String[] args) {
		Grafo g = new Grafo(GRAPH);
		 g.dijkstra(START);
		 System.out.println(g.distanciaTotal(END));
	}

}
