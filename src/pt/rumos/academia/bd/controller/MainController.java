package pt.rumos.academia.bd.controller;

import pt.rumos.academia.bd.dao.EntidadesDao;
import pt.rumos.academia.bd.dao.RegistoDao;

public class MainController {

	public static void main(String[] args) {
		
		if(args.length == 0) {
			System.out.println("Por favor indique um comando válido.");
			System.out.println("listar-registo");
			return;
		}
		
		switch(args[0]) {
	
			case "listar-registo":
				listarRegisto();
				break;
			case "criar-registo":
				criarRegisto(args[1], args[2], args[3], args[4]);
				break;
			case "remover-by-registo":
				removerRegisto(args[1]);
				break;
			case "atualizar-by-registo":
				atualizarRegisto(args[1], args[2]);
				break;
			case "alterar-password":
				alterarPassword(args[1], args[2], args[3], args[4]);
				break;
			case "listar-entidade":
				listarEntidade();
				break;	
			case "criar-entidade":
				criarEntidade(Integer.parseInt(args[1]), args[2]);
				break;
			case "atualizar-entidade":
				atualizarEntidade(Integer.parseInt(args[1]),args[2]);
				break;
			case "remover-entidade":
				removerEntidade(Integer.parseInt(args[1]));
				break;
			default:
			System.out.println("Não entendi o teu comando");
		}
	}
		

	private static void listarRegisto() {
		RegistoDao rDao = new RegistoDao();
		rDao.obter();
	}

	private static void criarRegisto(String email, String data, String username, String password) {
		RegistoDao rDao = new RegistoDao();
		rDao.criar(email, data, username, password);	
	}
	
	private static void removerRegisto(String email) {
		RegistoDao rDao = new RegistoDao();
		rDao.remover(email);
	}
	
	private static void atualizarRegisto(String email, String data) {
		RegistoDao rDao = new RegistoDao();
		rDao.atualizar(email, data);
	}
	
	private static void alterarPassword(String email, String password, String novapassword, String confirmacaopassword) {
		RegistoDao rDao = new RegistoDao();
		
		if(novapassword.equals(confirmacaopassword)) 
			rDao.atualizarpw(email, password, novapassword);
		
		else 
			System.out.println("Passwords incorretas!!");
	}
	
	private static void listarEntidade() {
		EntidadesDao rDao = new EntidadesDao();
		rDao.obter();
	}
	
	private static void criarEntidade(int id, String nome) {
		EntidadesDao rDao = new EntidadesDao();
		rDao.criar(id, nome);
	}
	
	private static void atualizarEntidade(int id, String nome) {
		EntidadesDao rDao = new EntidadesDao();
		rDao.atualizar(id, nome);
	}
	
	private static void removerEntidade(int id) {
		EntidadesDao rDao = new EntidadesDao();
		rDao.remover(id);
	}
	
}
