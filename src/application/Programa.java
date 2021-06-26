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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		
		
		System.out.println("---.:| Dados do Aluguel |:.---");
		
		System.out.println("Entre com o modelo do carro:");
		String modeloCarroIn = sc.next();
		Veiculo veiculo = new Veiculo(modeloCarroIn);

		System.out.println("Data e Hora da locação: ");
		Date inicioPrazoIn = sdf.parse(sc.next());
			
		System.out.println("Data e Hora do retorno: ");
		Date fimPrazoIn = sdf.parse(sc.next());
		
		AluguelCarro aluguelCarro = new AluguelCarro(inicioPrazoIn, fimPrazoIn, veiculo);

		
		System.out.println("Entre com o preço por hora: ");
		Double precoPorHora = sc.nextDouble();
		System.out.println("Entre com o preço por dia: ");
		Double precoPorDia = sc.nextDouble();
		
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
