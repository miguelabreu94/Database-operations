package pt.rumos.academia.bd.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import pt.rumos.academia.bd.entities.Movimento;
import pt.rumos.academia.bd.service.MovimentosService;

public class MovimentosController {

	public static void main(String[] args) {
		
		if(args.length == 0) {
			System.out.println("Por favor indique um comando válido.");
			System.out.println("listar-movimentos");
			System.out.println("criar-movimento");
			System.out.println("calcular-balanco-movimento");
			System.out.println("calcular-balanco-entidade-movimento");
			System.out.println("calcular-balanco-categoria-movimento");
			System.out.println("calcular-balanco-conta-movimento");
			return;
		}
		
		var movimentosService = new MovimentosService();
		
		switch(args[0]) {
		
		case "listar-movimentos":
			var listaDeMovimentos = movimentosService.listarMovimentos(); 
			for (Movimento mov : listaDeMovimentos) {
				System.out.println(mov);
			}
			break;
		case "criar-movimento":
			movimentosService.criarMovimento(Double.parseDouble(args[1]), Double.parseDouble(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]),
					LocalDateTime.parse(args[5]), Integer.parseInt(args[6]), args[7], args[8]);
			break;
		case "calcular-balanco-movimento":
			System.out.println(movimentosService.calcularSaldo());
			break;
		case "calcular-balanco-entidade-movimento":
			System.out.println(movimentosService.calcularSaldoByEntidadeID(Integer.parseInt(args[1])));
			break;
		case "calcular-balanco-entidadelist-movimento":
			// Passar args para lista de Ints
			List <Integer> entidadeIds = new ArrayList<>();
	        for (String arg : args) {
	            entidadeIds.add(Integer.parseInt(arg));
	        }
	        System.out.println(movimentosService.calcularSaldoByEntidadeIDList(entidadeIds));
			break;
		case "calcular-balanco-categoria-movimento":
			System.out.println(movimentosService.calcularSaldoByCategoriaID(Integer.parseInt(args[1])));
			break;
		case "calcular-balanco-conta-movimento":
			System.out.println(movimentosService.calcularSaldoByContaID(Integer.parseInt(args[1])));
			break;


		
		default:
		System.out.println("Não entendi o teu comando");
	}

}
}
