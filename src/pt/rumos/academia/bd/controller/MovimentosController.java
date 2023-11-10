package pt.rumos.academia.bd.controller;

import pt.rumos.academia.bd.entities.Movimento;
import pt.rumos.academia.bd.service.MovimentosService;

public class MovimentosController {

	public static void main(String[] args) {
		
		if(args.length == 0) {
			System.out.println("Por favor indique um comando válido.");
			System.out.println("listar-movimentos");
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
			break;
		case "remover-movimento":
			break;
		case "atualizar-by-id":
			break;
		
		default:
		System.out.println("Não entendi o teu comando");
	}

}
}
