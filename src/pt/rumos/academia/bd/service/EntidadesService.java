package pt.rumos.academia.bd.service;

import java.util.List;

import pt.rumos.academia.bd.dao.EntidadesDao;
import pt.rumos.academia.bd.entities.Entidade;

public class EntidadesService {

	private EntidadesDao rDao = new EntidadesDao();
	
	public List <Entidade> listarEntidade(){
		return null;
	}
	
	public void listarEntidadebyID(int id) {
		EntidadesDao rDao = new EntidadesDao();
		rDao.obterByID(id);
	}
	
	public void criarEntidade(int id, String nome) {
		EntidadesDao rDao = new EntidadesDao();
		rDao.criar(id, nome);
	}
	
	public void atualizarEntidade(int id, String nome) {
		EntidadesDao rDao = new EntidadesDao();
		rDao.atualizar(id, nome);
	}
	
	public void removerEntidade(int id) {
		EntidadesDao rDao = new EntidadesDao();
		rDao.remover(id);
	}
	
	
}
