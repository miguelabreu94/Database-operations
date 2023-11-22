package pt.rumos.academia.bd.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import pt.rumos.academia.bd.entities.ContasSaldo;

public class ContasDao {

public List<ContasSaldo> obterEstatisticasSaldos() {
		
		var contasSaldo = new ArrayList<ContasSaldo>();
		
		String querySp = "call geraSaldosContas()";
		
		try(Connection con = DatabaseConfiguration.obterConnection()) {
			
			// geração dos saldos
			CallableStatement stat = con.prepareCall(querySp);
			stat.execute();
			
			// ler os saldos gerados
			var queryStmt = con.createStatement();
			var contas = queryStmt.executeQuery("select * from contas_saldos");
			
			while(contas.next()) {
				contasSaldo.add(new ContasSaldo(
						contas.getInt(1),
						contas.getString(2),
						contas.getTimestamp(3).toLocalDateTime(),
						contas.getDouble(4),
						contas.getDouble(5),
						contas.getDouble(6)
						));
			}
			
			return contasSaldo;
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
	}

}
