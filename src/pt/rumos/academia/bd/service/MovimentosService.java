package pt.rumos.academia.bd.service;

import java.time.LocalDateTime;
import java.util.List;

import pt.rumos.academia.bd.dao.MovimentoDao;
import pt.rumos.academia.bd.entities.Categoria;
import pt.rumos.academia.bd.entities.Conta;
import pt.rumos.academia.bd.entities.Entidade;
import pt.rumos.academia.bd.entities.Movimento;

public class MovimentosService {
	
	private MovimentoDao movimentoDao = new MovimentoDao();
	
	public List <Movimento> listarMovimentos(){	
		return movimentoDao.obter();
	}

	public void criarMovimento(double credito, double debito, int entidade_id, int conta_id, 
			LocalDateTime data, int categoria_id, String descricao, String tipo ) {
		
		var entidade = new Entidade();
		entidade.setId(entidade_id);
		
		var conta = new Conta();
		conta.setId(conta_id);
		
		var categoria = new Categoria();
		categoria.setId(categoria_id);
		
		movimentoDao.criar(new Movimento(0,credito,debito,entidade,conta,data,categoria,descricao,tipo));
	}
	
	public double calcularSaldo() {
		
		List <Movimento> listamovimentos = listarMovimentos();
		double credito = 0;
		double debito = 0;
		
		for (Movimento movimento : listamovimentos) {
			credito += movimento.getCredito();
			debito += movimento.getDebito();
		}
		
		double saldo = credito - debito;
		
		return saldo;
	}
	
	
	
}
