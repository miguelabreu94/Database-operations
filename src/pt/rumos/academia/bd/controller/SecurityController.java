package pt.rumos.academia.bd.controller;

import pt.rumos.academia.bd.service.SecurityService;

public class SecurityController {

	public static void main(String[] args) {
		
		if(args.length < 1) {
			return;
		}

		if("login".equals(args[0])) {
			
			var username = args[1];
			var password = args[2];
			
			var securityService = new SecurityService();
			var token = securityService.login(username,password);
			System.out.println(token.orElse("Não foi possivel autenticar"));
		}
		
	}

}
