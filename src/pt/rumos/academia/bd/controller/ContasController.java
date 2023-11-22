package pt.rumos.academia.bd.controller;

import pt.rumos.academia.bd.service.ContasService;
import pt.rumos.academia.bd.service.SecurityService;

public class ContasController {

	public static void main(String[] args) {
		
		if(!SecurityService.isAutenthicated() ) {
			System.out.println("O utilizador não está autenticado");
			System.exit(-1);
		}
		
		if(!SecurityService.temAutorizacaoPara(args[0])) {
			System.out.println("O utilizador não está autorizado para essa ação");
			System.exit(-2);
		}

		switch(args[0]) {
		
		case "saldos-contas":
		ContasService.estatisticasSaldos().forEach(contaSaldo -> System.out.println(contaSaldo));
	}
	
}
	
}