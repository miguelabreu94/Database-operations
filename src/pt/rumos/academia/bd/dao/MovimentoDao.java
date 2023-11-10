package pt.rumos.academia.bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pt.rumos.academia.bd.entities.Categoria;
import pt.rumos.academia.bd.entities.Conta;
import pt.rumos.academia.bd.entities.Entidade;
import pt.rumos.academia.bd.entities.Movimento;

public class MovimentoDao {
	
	public List<Movimento> obter(){
		
		String query = """
				select m.id , Credito, Debito, e.id ,e.nome , c.id ,c.nome ,data, ct.id , ct.nome ,Descricao, tipo
			from movimentos m left join entidades e on m.entidade = e.id
				inner join Contas c on m.conta = c.id
				left join Categorias ct on m.categoria = ct.id """;
		
		try(Connection con = PostgresConfiguration.obterConnection()){
			
			Statement stat = con.createStatement();
			ResultSet movimentos = stat.executeQuery(query);

			var listaMovimentos = new ArrayList<Movimento>();
			
			while(movimentos.next()) {
				var movimento = new Movimento();
				movimento.setId(movimentos.getInt(1));
				movimento.setCredito(movimentos.getDouble(2));
				movimento.setDebito(movimentos.getDouble(3));
				
				
				var entidade = new Entidade();
				entidade.setId(movimentos.getInt(4));
				entidade.setNome(movimentos.getString(5));
				movimento.setEntidade(entidade);
				
				var conta = new Conta();
				conta.setId(movimentos.getInt(6));
				conta.setNome(movimentos.getString(7));
				movimento.setConta(conta);
			
				movimento.setData(movimentos.getTimestamp(8).toLocalDateTime());
				
				var categoria = new Categoria();
				categoria.setId(movimentos.getInt(9));
				categoria.setNome(movimentos.getString(10));
				movimento.setCategoria(categoria);
				
				movimento.setDescricao(movimentos.getString(11));
				movimento.setTipo(movimentos.getString(12));
				
				listaMovimentos.add(movimento);
				
			}
			
			return listaMovimentos;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
		}
	
	public void criar(Movimento movimento) {
		
		String insert = "INSERT INTO movimentos (Credito,Debito,Entidade,Conta,data,Categoria,Descricao,tipo) values (?,?,?,?,?,?,?,?,?,?,?,?";
		
		
			try(Connection con = PostgresConfiguration.obterConnection()){
			
			PreparedStatement stat = con.prepareStatement(insert);
			
			stat.setDouble(1, movimento.getCredito());
			stat.setDouble(2, movimento.getDebito());
			
			var entidade = new Entidade();
			stat.setString(3, movimento.getEntidade().getNome());

			// TODO Completar este bloco 
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
		
	}

