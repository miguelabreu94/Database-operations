package pt.rumos.academia.bd.service;

import java.util.List;

import pt.rumos.academia.bd.dao.MovimentoDao;
import pt.rumos.academia.bd.entities.Movimento;

public class MovimentosService {
	
	private MovimentoDao movimentoDao = new MovimentoDao();
	
	public List <Movimento> listarMovimentos(){
		var listaDeMovimentos = movimentoDao.obter();
		return listaDeMovimentos;
	}

}
