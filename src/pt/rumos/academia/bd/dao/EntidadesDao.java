package pt.rumos.academia.bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EntidadesDao {
	
	public void obter() {
		
	String query = "SELECT id, nome from Entidades ORDER BY id";
		
	try(Connection con = PostgresConfiguration.obterConnection()){
			
			Statement stat = con.createStatement();
			ResultSet entidades = stat.executeQuery(query);
			while(entidades.next()) {
				int id = entidades.getInt(1);
				String nome = entidades.getString(2);
				System.out.println(String.format("%d - %s", id, nome));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void criar(int id, String name) {
		
		String insert = "INSERT INTO Entidades (id, nome) values (?,?)";
		
	try(Connection con = PostgresConfiguration.obterConnection()){
			
		PreparedStatement stat = con.prepareStatement(insert);
		stat.setInt(1, id);
		stat.setString(2, name);
		int nLinhas = stat.executeUpdate();
		if(nLinhas == 0) {
			throw new RuntimeException("Não foi possível inserir a entidade");
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void atualizar(int id, String name) {
		
		String update = "UPDATE Entidades SET Nome = ? WHERE ID = ?";
		
		try(Connection con = PostgresConfiguration.obterConnection()){
			
			PreparedStatement stat = con.prepareStatement(update);
			stat.setString(1, name);
			stat.setInt(2, id);
			stat.executeUpdate();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void remover(int id) {
		
		String delete = "DELETE FROM Entidades WHERE ID = ?";
		
		try(Connection con = PostgresConfiguration.obterConnection()){
			
			PreparedStatement stat = con.prepareStatement(delete);
			stat.setInt(1, id);
			stat.executeUpdate();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	
	
}
