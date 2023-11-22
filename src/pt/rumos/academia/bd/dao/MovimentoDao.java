package pt.rumos.academia.bd.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import pt.rumos.academia.bd.entities.Categoria;
import pt.rumos.academia.bd.entities.Conta;
import pt.rumos.academia.bd.entities.Entidade;
import pt.rumos.academia.bd.entities.Movimento;

public class MovimentoDao {
	
	public List <Movimento> obter(){
		
		String query = """
				select m.id , Credito, Debito, e.id ,e.nome , c.id ,c.nome ,data, ct.id , ct.nome ,Descricao, tipo
			from movimentos m left join entidades e on m.entidade = e.id
				inner join Contas c on m.conta = c.id
				left join Categorias ct on m.categoria = ct.id """;
		
		try(Connection con = DatabaseConfiguration.obterConnection()){
			
			Statement stat = con.createStatement();
			ResultSet movimentos = stat.executeQuery(query);

			var listaMovimentos = new ArrayList<Movimento>();
			
			while(movimentos.next()) {
				var movimento = new Movimento();
				preencherMovimento(movimentos, movimento);
				
				listaMovimentos.add(movimento);
				
			}
			
			return listaMovimentos;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
		}

	private void preencherMovimento(ResultSet movimentos, Movimento movimento) throws SQLException {
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
	}
	
	public void criar(Movimento movimento) {
		
		String insert = "INSERT INTO movimentos (credito,debito,entidade,conta,data,categoria,descricao,tipo) values (?,?,?,?,?,?,?,?)";
		
			try(Connection con = DatabaseConfiguration.obterConnection()){
			
			PreparedStatement stat = con.prepareStatement(insert);
			
			stat.setDouble(1, movimento.getCredito());
			stat.setDouble(2, movimento.getDebito());
			stat.setInt(3, movimento.getEntidade().getId());
			stat.setInt(4, movimento.getConta().getId());
			stat.setTimestamp(5, Timestamp.valueOf(movimento.getData()));
			stat.setInt(6, movimento.getCategoria().getId());
			stat.setString(7, movimento.getDescricao());
			stat.setString(8, movimento.getTipo());
			
			int nLinhas = stat.executeUpdate();
			if (nLinhas == 0) {
				throw new RuntimeException("Não foi possível inserir o movimento");
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}		
	
	public List <Movimento> obterMovByType(int id, String query) {
		
		try(Connection con = DatabaseConfiguration.obterConnection()){
			
			PreparedStatement stat = con.prepareStatement(query);
			stat.setInt(1, id);
			
			ResultSet movimentos = stat.executeQuery();

			var listaMovimentos = new ArrayList<Movimento>();
			
			while(movimentos.next()) {
				var movimento = new Movimento();
				preencherMovimento(movimentos, movimento);
				
				listaMovimentos.add(movimento);
				
			}
			
			return listaMovimentos;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
	}
	
	public List <Movimento> obterMovByEntidadeID(int id){
		
		String query = """
				select m.id , Credito, Debito, e.id ,e.nome , c.id ,c.nome ,data, ct.id , ct.nome ,Descricao, tipo
			from movimentos m left join entidades e on m.entidade = e.id
				inner join Contas c on m.conta = c.id
				left join Categorias ct on m.categoria = ct.id 
				where entidade = ? """;
		
		return obterMovByType(id,query);	
	}
	
	public List <Movimento> obterMovByCategoriaID(int id){
		
		String query = """
				select m.id , Credito, Debito, e.id ,e.nome , c.id ,c.nome ,data, ct.id , ct.nome ,Descricao, tipo
			from movimentos m left join entidades e on m.entidade = e.id
				inner join Contas c on m.conta = c.id
				left join Categorias ct on m.categoria = ct.id 
				where categoria = ? """;
		
		return obterMovByType(id,query);
	}
	
	public List <Movimento> obterMovByContaID(int id){
		
		String query = """
				select m.id , Credito, Debito, e.id ,e.nome , c.id ,c.nome ,data, ct.id , ct.nome ,Descricao, tipo
			from movimentos m left join entidades e on m.entidade = e.id
				inner join Contas c on m.conta = c.id
				left join Categorias ct on m.categoria = ct.id 
				where categoria = ? """;
		
		return obterMovByType(id,query);
	}
	
}

