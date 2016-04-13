package br.com.calcularota.service;

import java.util.List;

import br.com.calcularota.entities.Mapa;

public interface RotaService {

	List<Mapa> calcularRota(Mapa mapa);

}
