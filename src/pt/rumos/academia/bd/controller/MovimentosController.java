package pt.rumos.academia.bd.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import pt.rumos.academia.bd.entities.Movimento;
import pt.rumos.academia.bd.service.MovimentosService;
import pt.rumos.academia.bd.service.SecurityService;

public class MovimentosController {

	public static void main(String[] args) {
		
		if(!SecurityService.isAutenthicated() ) {
			System.out.println("O utilizador não está autenticado");
			System.exit(-1);
		}
		
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
		
		if(!SecurityService.temAutorizacaoPara(args[0])) {
			System.out.println("O utilizador não está autorizado para essa ação");
			System.exit(-2);
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
			System.out.print("O balanço total de todos os movimentos é de ");
			System.out.print(movimentosService.calcularSaldoDeTodosOsMovimentos());
			break;
		case "calcular-balanco-entidade-movimento":
			System.out.print("O balanço da entidade " + args[1] + " é de ");
			System.out.print(movimentosService.calcularSaldoByEntidadeID(Integer.parseInt(args[1])));
			break;
		case "calcular-balanco-entidadelist-movimento":
			List <Integer> entidadeIds = new ArrayList<>();
	        for (int i = 1; i < args.length; i++) {
	        	entidadeIds.add(Integer.parseInt(args[i]));
	        }
            System.out.print("O balanço das entidades indicadas é de ");
            System.out.print(movimentosService.calcularSaldoByEntidadeIDList(entidadeIds));
			break;
		case "calcular-balanco-categoria-movimento":
			System.out.print("O balanço da categoria " + args[1] + " é de ");
			System.out.print(movimentosService.calcularSaldoByCategoriaID(Integer.parseInt(args[1])));
			break;
		case "calcular-balanco-conta-movimento": 
			System.out.print("O balanço da conta " + args[1] + " é de ");
			System.out.print(movimentosService.calcularSaldoByContaID(Integer.parseInt(args[1])));
			break;

		default:
		System.out.println("Não entendi o teu comando");
	}

}
}
