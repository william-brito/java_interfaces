package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.AluguelCarro;
import model.entities.Veiculo;
import model.services.AluguelService;
import model.services.TaxaBrasilService;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		
		
		System.out.println("---.:| Dados do Aluguel |:.---");
		
		System.out.println("Entre com o modelo do carro:");
		String modeloCarroIn = sc.nextLine();
		Veiculo veiculo = new Veiculo(modeloCarroIn);

		System.out.println("Data e Hora da locação (dd/MM/yyyy hh:ss) : ");
		Date inicioPrazoIn = sdf.parse(sc.nextLine());
			
		System.out.println("Data e Hora do retorno (dd/MM/yyyy hh:ss) : ");
		Date fimPrazoIn = sdf.parse(sc.nextLine());
		
		AluguelCarro aluguelCarro = new AluguelCarro(inicioPrazoIn, fimPrazoIn, veiculo);
		
		System.out.println("Entre com o preço por hora: ");
		double precoPorHora = sc.nextDouble();
		System.out.println("Entre com o preço por dia: ");
		double precoPorDia = sc.nextDouble();
		
		TaxaBrasilService taxaBrasilService = new TaxaBrasilService();
		AluguelService aluguelService = new AluguelService(precoPorHora, precoPorDia, taxaBrasilService);
		aluguelService.processarNotaPagamento(aluguelCarro);
				
		System.out.println("---.:| NOTA DE PAGMENTO |:.---");
		
		System.out.println("Pagamento Básico: "+aluguelCarro.getNotaPagamentoAssoc().getPagamentoBasico());
		System.out.println("Taxa: "+aluguelCarro.getNotaPagamentoAssoc().getTaxa());
		System.out.println("Pagamento Total: "+aluguelCarro.getNotaPagamentoAssoc().getPagamentoTotal());

		sc.close();
		
	}

}
