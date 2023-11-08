package pt.rumos.academia.bd.dao;

import java.sql.*;

public class RegistoDao {

	public void obter() {
		
		String query = "SELECT email, data, username, password from Registo";
		
		try(Connection con = PostgresConfiguration.obterConnection()){
			
			Statement stat = con.createStatement();
			ResultSet registos = stat.executeQuery(query);
			while(registos.next()) {
				String email = registos.getString(1);
				Date data = registos.getDate(2);
				String username = registos.getString(3);
				String password = registos.getString(4);
				
				System.out.println(String.format("%s, %s, %s, %s", email, data, username, password));
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public void criar2(String email, String data, String username, String password) {
		
		String parameters = String.format("'%s','%s','%s','%s'", email, data, username, password);
		String insert = "INSERT INTO Registo (email, data, username, password) values ("+parameters+")";
		
		try(Connection con = PostgresConfiguration.obterConnection()){
			
			Statement stat = con.createStatement();
			int nLinhas = stat.executeUpdate(insert);
			if (nLinhas == 0) {
				throw new RuntimeException("Não foi possível inserir o registo");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void criar(String email, String data, String username, String password) {
		
		String insert = "INSERT INTO Registo (email, data, username, password) values (?,?,?,?)";
		
		try(Connection con = PostgresConfiguration.obterConnection()){
			
			PreparedStatement stat = con.prepareStatement(insert);
			stat.setString(1, email);
			stat.setDate(2, Date.valueOf(data));
			stat.setString(3, username);
			stat.setString(4, password);
			int nLinhas = stat.executeUpdate();
			if (nLinhas == 0) {
				throw new RuntimeException("Não foi possível inserir o registo");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void remover(String email) {
		
		String delete = "DELETE FROM Registo WHERE email = ?";
		
		try(Connection con = PostgresConfiguration.obterConnection()){
			
			PreparedStatement stat = con.prepareStatement(delete);
			stat.setString(1, email);
			stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void atualizar(String email, String data) {
		
		String update = "UPDATE Registo SET data = ? WHERE email = ?";
		
		try(Connection con = PostgresConfiguration.obterConnection()){
			
			PreparedStatement stat = con.prepareStatement(update);
			stat.setDate(1, Date.valueOf(data));
			stat.setString(2, email);
			stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
public void atualizarpw(String email, String password, String novapassword) {
		
		String updatepw = "UPDATE Registo SET password = ? WHERE email = ? AND password = ?";
		
		try(Connection con = PostgresConfiguration.obterConnection()){
			
			PreparedStatement stat = con.prepareStatement(updatepw);
			stat.setString(1, novapassword);
			stat.setString(2, email);
			stat.setString(3, password);
			stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
