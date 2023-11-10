package pt.rumos.academia.bd.entities;

import java.time.LocalDateTime;

public class Movimento {

	private int id;
	private double credito;
	private double debito;
	private Entidade entidade;
	private Conta conta;
	private LocalDateTime data;
	private Categoria categoria;
	private String descricao;
	private String tipo;
	
	
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

	
	public String toString() {
		return String.format ("%d,'%.2f','%.2f',[%s],[%s],%s,[%s],'%s',%s", id, credito, debito, entidade, conta, data, categoria, descricao, tipo);
	}
	
}
