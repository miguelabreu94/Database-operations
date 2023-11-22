package pt.rumos.academia.bd.service;

import java.util.List;

import pt.rumos.academia.bd.dao.ContasDao;
import pt.rumos.academia.bd.entities.ContasSaldo;

public class ContasService {
	
	private static ContasDao contasDao = new ContasDao();
	
	public static List<ContasSaldo> estatisticasSaldos() {
		
		return contasDao.obterEstatisticasSaldos();
		
	}

}
