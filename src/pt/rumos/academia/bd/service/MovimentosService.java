package pt.rumos.academia.bd.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
		
		return credito - debito;
	}
	
	public double calcularSaldoByEntidadeID(int entidade_id) {
	
		List <Movimento> listamovimentos = listarMovimentos();
		List <Movimento> finalList = new ArrayList<Movimento>();
		
		double credito = 0;
		double debito = 0;
		
		for (Movimento movimento : listamovimentos) {
			if (movimento.getEntidade().getId() == entidade_id) {
				finalList.add(movimento);
			}
		}
		
		for (Movimento movimento : finalList) {
			credito += movimento.getCredito();
			debito += movimento.getDebito();
		}
		
		return credito - debito;
		}
	
	public double calcularSaldoByEntidadeIDList(List <Integer> entidades_ids) {
		
		List <Movimento> listamovimentos = listarMovimentos();
		List <Movimento> finalList = new ArrayList<Movimento>();
		
		double credito = 0;
		double debito = 0;
		
		for (Movimento movimento : listamovimentos) {
			if (entidades_ids.contains(movimento.getEntidade().getId())) {
				finalList.add(movimento);
			}
		}
		
		for (Movimento movimento : finalList) {
			credito += movimento.getCredito();
			debito += movimento.getDebito();
		}
		
		return credito - debito;
	}
	
	
	public double calcularSaldoByCategoriaID(int categoria_id) {
		
		List <Movimento> listamovimentos = listarMovimentos();
		List <Movimento> finalList = new ArrayList<Movimento>();
		
		double credito = 0;
		double debito = 0;
		
		for (Movimento movimento : listamovimentos) {
			if (movimento.getCategoria().getId() == categoria_id) {
				finalList.add(movimento);
			}
		}
		
		for (Movimento movimento : finalList) {
			credito += movimento.getCredito();
			debito += movimento.getDebito();
		}
		
		return credito - debito;
	}
	
public double calcularSaldoByContaID(int conta_id) {
		
		List <Movimento> listamovimentos = listarMovimentos();
		List <Movimento> finalList = new ArrayList<Movimento>();
		
		double credito = 0;
		double debito = 0;
		
		for (Movimento movimento : listamovimentos) {
			if (movimento.getCategoria().getId() == conta_id) {
				finalList.add(movimento);
			}
		}
		
		for (Movimento movimento : finalList) {
			credito += movimento.getCredito();
			debito += movimento.getDebito();
		}
		
		return credito - debito;
	}
	
	
	
	}
	
	
