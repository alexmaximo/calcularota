package br.com.calcularota.dao;

import java.util.List;

import br.com.calcularota.entities.Mapa;

public interface RotaDao {

	List<Mapa> calcularRota(Mapa mapa);

}
