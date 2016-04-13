package br.com.calcularota.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "mapa")
public class Mapa implements Serializable {

	private static final long serialVersionUID = 5423634267339619046L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "mapa")
	private String mapa;

	@Column(name = "origem")
	private String origem;

	@Column(name = "destino")
	private String destino;

	@Column(name = "distancia")
	private BigDecimal distancia;

	@Transient
	private BigDecimal autonomia;

	@Transient
	private BigDecimal valorCombustivel;

	@Transient
	private BigDecimal distanciaTotal;

	@Transient
	private BigDecimal gastoTotal;

	public Mapa(String mapa, String origem, String destino, BigDecimal distancia) {
		super();
		this.mapa = mapa;
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
	}

	public Mapa(Integer id, String mapa, String origem, String destino, BigDecimal distancia, BigDecimal autonomia,
			BigDecimal valorCombustivel) {
		super();
		this.id = id;
		this.mapa = mapa;
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
		this.autonomia = autonomia;
		this.valorCombustivel = valorCombustivel;
	}

	public Mapa() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMapa() {
		return mapa;
	}

	public void setMapa(String mapa) {
		this.mapa = mapa;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public BigDecimal getDistancia() {
		return distancia;
	}

	public void setDistancia(BigDecimal distancia) {
		this.distancia = distancia;
	}

	public BigDecimal getAutonomia() {
		return autonomia;
	}

	public void setAutonomia(BigDecimal autonomia) {
		this.autonomia = autonomia;
	}

	public BigDecimal getValorCombustivel() {
		return valorCombustivel;
	}

	public void setValorCombustivel(BigDecimal valorCombustivel) {
		this.valorCombustivel = valorCombustivel;
	}

	public BigDecimal getDistanciaTotal() {
		return distanciaTotal;
	}

	public void setDistanciaTotal(BigDecimal distanciaTotal) {
		this.distanciaTotal = distanciaTotal;
	}

	public BigDecimal getGastoTotal() {
		return gastoTotal;
	}

	public void setGastoTotal(BigDecimal gastoTotal) {
		this.gastoTotal = gastoTotal;
	}

}