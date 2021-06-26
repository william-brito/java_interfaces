package model.services;

public class TaxaBrasilService {

public double taxa(double quantidade) {
		
		if (quantidade <= 100.0) {
			return quantidade * 0.2;
		}else  {
			return quantidade * 0.15;
		}
		
	}
	
}
