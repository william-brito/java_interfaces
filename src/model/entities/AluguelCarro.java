package model.entities;

import java.util.Date;

public class AluguelCarro {
	private Date inicioPrazo;
	private Date fimPrazo;
	
	private Veiculo veiculoAssoc;
	private NotaPagamento notaPagamentoAssoc;

	public AluguelCarro() {
	}
	
	public AluguelCarro(Date inicioPrazo, Date fimPrazo, Veiculo veiculoAssoc) {
		this.inicioPrazo = inicioPrazo;
		this.fimPrazo = fimPrazo;
		this.veiculoAssoc = veiculoAssoc;
	}

	public Date getInicioPrazo() {
		return inicioPrazo;
	}

	public void setInicioPrazo(Date inicioPrazo) {
		this.inicioPrazo = inicioPrazo;
	}

	public Date getFimPrazo() {
		return fimPrazo;
	}

	public void setFimPrazo(Date fimPrazo) {
		this.fimPrazo = fimPrazo;
	}

	public Veiculo getVeiculoAssoc() {
		return veiculoAssoc;
	}

	public void setVeiculoAssoc(Veiculo veiculoAssoc) {
		this.veiculoAssoc = veiculoAssoc;
	}

	public NotaPagamento getNotaPagamentoAssoc() {
		return notaPagamentoAssoc;
	}

	public void setNotaPagamentoAssoc(NotaPagamento notaPagamentoAssoc) {
		this.notaPagamentoAssoc = notaPagamentoAssoc;
	}
	
	
	
}
