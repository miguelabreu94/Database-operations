package pt.rumos.academia.bd.entities;

import java.time.LocalDateTime;
import java.util.Comparator;

public class Movimento implements Comparable<Movimento>{

	private int id;
	private double credito;
	private double debito;
	private Entidade entidade;
	private Conta conta;
	private LocalDateTime data;
	private Categoria categoria;
	private String descricao;
	private String tipo;
	
	public Movimento () {
		
	}
	
	public Movimento(int id, double credito, double debito, Entidade entidade, Conta conta, LocalDateTime data,
			Categoria categoria, String descricao, String tipo) {
		super();
		this.id = id;
		this.credito = credito;
		this.debito = debito;
		this.entidade = entidade;
		this.conta = conta;
		this.data = data;
		this.categoria = categoria;
		this.descricao = descricao;
		this.tipo = tipo;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getCredito() {
		return credito;
	}
	public void setCredito(double credito) {
		this.credito = credito;
	}
	public double getDebito() {
		return debito;
	}
	public void setDebito(double debito) {
		this.debito = debito;
	}
	public Entidade getEntidade() {
		return entidade;
	}
	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return String.format ("%d,'%.2f','%.2f',[%s],[%s],%s,[%s],'%s',%s", id, credito, debito, entidade, conta, data, categoria, descricao, tipo);
	}
	
	@Override
	public boolean equals(Object movimento) {
		
		if(this == movimento) {
			return true;
		}
		
		if (movimento == null || getClass() != movimento.getClass()) {
			return false;
		}
		
		if(movimento instanceof Movimento mov) {
			return this.id == mov.id
					&& this.credito == mov.credito
					&& this.debito == mov.debito
					&& this.entidade.equals(mov.entidade)
					&& this.conta.equals(mov.conta)
					&& this.data.equals(mov.data)
					&& this.categoria.equals(mov.categoria)
					&& this.descricao.equals(mov.descricao)
					&& this.tipo.equals(mov.tipo);
		}
		
		return true;
	}

	@Override
	public int compareTo(Movimento o) {
		
		return this.data.compareTo(o.data);
		
	}
	
	
	public static class CompareDescricao implements Comparator<Movimento>{

		@Override
		public int compare(Movimento o1, Movimento o2) {
			
			return o1.descricao.compareTo(o2.descricao);
		}
		
	}
	
	public static class CompareSaldo implements Comparator<Movimento>{

		@Override
		public int compare(Movimento o1, Movimento o2) {
			
			if((o1.credito - o1.debito) - (o2.credito - o2.debito) > 0) {
				return 1;
			
			}
			else return -1;
		}
		
	}
	
	
	
}
