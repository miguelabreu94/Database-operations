package pt.rumos.academia.bd.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import pt.rumos.academia.bd.dao.SecurityDao;
import pt.rumos.academia.bd.utils.HashUtils;

public class SecurityService {

	public static boolean isAutenthicated() {
		
		var token = System.getProperty("cookie-auth");
		return verificarToken(token);
	}

	private static boolean verificarToken(String token) {
		
		var sessao = new SecurityDao().obterSessao(token).orElseThrow();
		return sessao.dataValidade().isAfter(LocalDateTime.now());
		
	}

	public static Optional<String> login(String username, String password) {
	
		var utilizador = new RegistoService().listarRegistoByUsername(username).get();
		var hashPassword = HashUtils.calcularHash(password);
		
		if(utilizador.getPassword().equals(hashPassword)) {
			var token = geraToken();
			var validade = LocalDateTime.now().plusMinutes(1);
			new SecurityDao().adicionarToken(username, token, validade);
			
			return Optional.of(token);
		}
		
		return Optional.empty();
		
	}
	
	public static boolean temAutorizacaoPara(String acao) {
		var token = System.getProperty("cookie-auth");
		var sessao = new SecurityDao().obterSessao(token).orElseThrow();
		return new SecurityDao().temAutorizacaoPara(sessao.username(),acao);
	}
	
	public static String geraToken() {
		return "" + new Random().nextInt(1000);
	}
	
	

}
