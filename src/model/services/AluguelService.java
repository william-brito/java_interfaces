package model.services;

import model.entities.AluguelCarro;

public class AluguelService {
	
	private Double precoPorHora;
	private Double precoPorDia;
	
	private TaxaBrasilService taxaBrasil;
	
	public AluguelService() {
	}

	public AluguelService(Double precoPorHora, Double precoPorDia, TaxaBrasilService taxaBrasil) {
		this.precoPorHora = precoPorHora;
		this.precoPorDia = precoPorDia;
		this.taxaBrasil = taxaBrasil;
	}

	public Double getPrecoPorHora() {
		return precoPorHora;
	}

	public void setPrecoPorHora(Double precoPorHora) {
		this.precoPorHora = precoPorHora;
	}

	public Double getPrecoPorDia() {
		return precoPorDia;
	}

	public void setPrecoPorDia(Double precoPorDia) {
		this.precoPorDia = precoPorDia;
	}

	public TaxaBrasilService getTaxaBrasil() {
		return taxaBrasil;
	}

	public void setTaxaBrasil(TaxaBrasilService taxaBrasil) {
		this.taxaBrasil = taxaBrasil;
	}
	
	public void processarNotaPagamento(AluguelCarro carro) {
		if() {
			this.getPrecoPorHora();
		}else {
			this.getPrecoPorDia();
		}
	}
	
}
