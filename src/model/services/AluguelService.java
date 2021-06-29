package model.services;

import model.entities.AluguelCarro;
import model.entities.NotaPagamento;

public class AluguelService {
	
	private Double precoPorHora;
	private Double precoPorDia;
	
	private TaxaService taxaService;
	
	public AluguelService() {
	}

	public AluguelService(Double precoPorHora, Double precoPorDia, TaxaService taxaService) {
		this.precoPorHora = precoPorHora;
		this.precoPorDia = precoPorDia;
		this.taxaService = taxaService;
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

	public TaxaService getTaxaBrasil() {
		return taxaService;
	}

	public void setTaxaService(TaxaService taxaService) {
		this.taxaService = taxaService;
	}
	
	public void processarNotaPagamento(AluguelCarro carroAluguel) {
		
		long ini = carroAluguel.getInicioPrazo().getTime(); //milisegundos
		long fini = carroAluguel.getFimPrazo().getTime(); //milisegundos
		
		double diffHoras = (double)(fini-ini) / 1000 / 60 / 60; //Casting para Double a fim de se arredondar
		//milisegundos para segundos = dividir por 1000
		//segundos para minutos = dividir por 60
		//minutos para horas = dividir por 60
				
		double pagamentoBasicoVar;
		
		if(diffHoras<12.0) {
			pagamentoBasicoVar = this.getPrecoPorHora()*Math.ceil(diffHoras);
		}else {
			pagamentoBasicoVar = this.getPrecoPorDia()*Math.ceil(diffHoras / 24);
			//horas para dias = dividir por 24
		}
		
		double taxa = taxaService.taxa(pagamentoBasicoVar);
		//calcula valor do imposto a partir do pagamento básico
		
		NotaPagamento np = new NotaPagamento(pagamentoBasicoVar, taxa);
		carroAluguel.setNotaPagamentoAssoc(np);
		
	}
	
}
