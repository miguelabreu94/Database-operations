package pt.rumos.academia.bd.controller;

import java.util.Collections;

import pt.rumos.academia.bd.entities.ContasSaldo;
import pt.rumos.academia.bd.service.ContasService;
import pt.rumos.academia.bd.service.SecurityService;

public class ContasController {

	public static void main(String[] args) {
		/*
		if(!SecurityService.isAutenthicated() ) {
			System.out.println("O utilizador não está autenticado");
			System.exit(-1);
		}
		
		if(!SecurityService.temAutorizacaoPara(args[0])) {
			System.out.println("O utilizador não está autorizado para essa ação");
			System.exit(-2);
		}
*/
		switch(args[0]) {
		
		case "saldos-contas":
		var saldos = ContasService.estatisticasSaldos();
		
		
		if("sort".equals(args[1])) Collections.sort(saldos);
		
		if("sort-nome".equals(args[1])) Collections.sort(saldos, new ContasSaldo.CompareNome());
		if("sort-saldo".equals(args[1])) Collections.sort(saldos, new ContasSaldo.CompareSaldo());
		
		
		// Collections.sort(saldos);
		// Collections.sort(saldos, new ContasSaldo.CompareNome());
		Collections.sort(saldos, new ContasSaldo.CompareSaldo());

		
		ContasService.estatisticasSaldos().forEach(contaSaldo -> System.out.println(contaSaldo));
	}
	
}
	
}