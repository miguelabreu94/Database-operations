package pt.rumos.academia.bd.controller;

import pt.rumos.academia.bd.entities.Registo;
import pt.rumos.academia.bd.service.RegistoService;

public class MainController {

	public static void main(String[] args) {
		
		if(args.length == 0) {
			System.out.println("Por favor indique um comando válido.");
			System.out.println("listar-registo");
			System.out.println("listar-registo-by-email");
			System.out.println("criar-registo");
			System.out.println("remover-by-registo");
			System.out.println("atualizar-by-registo");
			System.out.println("alterar-password");
			return;
		}
		
		var registoService = new RegistoService();
		
		switch(args[0]) {
	
			case "listar-registo":
				var listaDeRegistos = registoService.listarRegisto();
				for(Registo reg: listaDeRegistos) {
					System.out.println(reg);
				}
				break;
			case "listar-registo-by-email":
				var registo = registoService.listarRegistoByEmail(args[1]);
				if(registo == null) {
					System.out.println("Nenhum registo foi encontrado com o email fornecido");
					return;
				}
				System.out.println(registo);
				break;
			case "criar-registo":
				registoService.criarRegisto(args[1], args[2], args[3], args[4]);
				break;
			case "remover-by-registo":
				registoService.removerRegisto(args[1]);
				break;
			case "atualizar-by-registo":
				registoService.atualizarRegisto(args[1], args[2]);
				break;
			case "alterar-password":
				registoService.alterarPassword(args[1], args[2], args[3], args[4]);
				break;
			default:
			System.out.println("Não entendi o teu comando");
		}
	}
			
}
