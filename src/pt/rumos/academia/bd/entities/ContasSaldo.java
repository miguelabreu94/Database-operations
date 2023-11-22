package pt.rumos.academia.bd.entities;

import java.time.LocalDateTime;

public record ContasSaldo (int id, String nome, LocalDateTime data, double credito,double debito,double saldo) {
	
	@Override
	public String toString() {return String.format("%d ,%s ,%s , %.2f , %.2f , %.2f ", id, nome, data, credito, debito, saldo);}
}
	


