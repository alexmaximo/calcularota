package br.com.calcularota.service;

import java.util.List;

import br.com.calcularota.entities.Mapa;

public interface MapaService {

	void save(Mapa mapa);

	void atualizar(Mapa mapa);

	void excluir(Mapa mapa);

	Mapa findMapa(Mapa mapa);

	Mapa findMapaById(Integer id);

	List<Mapa> findAllMapas();

}
