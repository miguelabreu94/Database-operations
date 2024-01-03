package pt.rumos.academia.bd.entities;

import java.time.LocalDateTime;
import java.util.Comparator;

public record ContasSaldo (int id, String nome, LocalDateTime data, double credito,double debito,double saldo) implements Comparable<ContasSaldo> {
	
	public static class CompareNome implements Comparator <ContasSaldo>{

		@Override
		public int compare(ContasSaldo o1, ContasSaldo o2) {
			
			return o1.nome.compareTo(o2.nome);
		}
	}
	
	public static class CompareSaldo implements Comparator <ContasSaldo>{

			@Override
			public int compare(ContasSaldo o1, ContasSaldo o2) {
				
				return o1.saldo - o2.saldo > 0 ? 1 : -1;
			}	
	}
	
	@Override
	public String toString() {return String.format("%d ,%s ,%s , %.2f , %.2f , %.2f ", id, nome, data, credito, debito, saldo);}

	@Override
	public int compareTo(ContasSaldo o) {
		
		return this.id - o.id;
		
	}
	
}


