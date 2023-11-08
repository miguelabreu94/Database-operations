package pt.rumos.academia.bd.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import pt.rumos.academia.bd.dao.RegistoDao;
import pt.rumos.academia.bd.entities.Registo;

public class RegistoService {
	
	private RegistoDao rDao = new RegistoDao();

	public List<Registo> listarRegisto() {
		var listaDeRegistos = rDao.obter();
		return listaDeRegistos;
	}
	
	public Optional<Registo> listarRegistoByEmail(String curEmail) {
		return rDao.obterByEmail(curEmail);
}

	public void criarRegisto(String email, String data, String username, String password) {

	    try {
	    	rDao.criar(new Registo(email, new SimpleDateFormat("yyyy-MM-dd").parse(data) , username, password));
	    } catch (ParseException e) {
			e.printStackTrace();
		}
	      
	}
	public void removerRegisto(String email) {
		rDao.remover(email);
	}
	
	public void atualizarRegisto(String email, String data) {
		rDao.atualizar(email, data);
	}
	
	public void alterarPassword(String email, String password, String novapassword, String confirmacaopassword) {		
		if(novapassword.equals(confirmacaopassword)) 
			rDao.atualizarpw(email, password, novapassword);
		
		else 
			System.out.println("Passwords incorretas!!");
	}
}
