package pt.rumos.academia.bd.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import pt.rumos.academia.bd.entities.Registo;

public class RegistoDao {

	public List<Registo> obter() {
		
		String query = "SELECT email, data, username, password from Registo";
		
		try(Connection con = PostgresConfiguration.obterConnection()){
			
			Statement stat = con.createStatement();
			ResultSet registos = stat.executeQuery(query);
			
			var listaRegistos = new ArrayList<Registo>();
			
			while(registos.next()) {
				var registo = new Registo(registos.getString(1),
				registos.getDate(2),
				registos.getString(3),
				registos.getString(4));
				
				listaRegistos.add(registo);
			}
		
			
		return listaRegistos;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	
	}
	
public Optional<Registo> obterByEmail(String curEmail) {
		
		String query = "SELECT email, data, username, password from Registo where lower(email) = lower(?)";
		
		try(Connection con = PostgresConfiguration.obterConnection()) {
			
			PreparedStatement stat = con.prepareStatement(query);
			stat.setString(1, curEmail);
			ResultSet registos = stat.executeQuery();
			if(registos.next()) {
				return Optional.of(new Registo(registos.getString(1),
						registos.getDate(2),
						registos.getString(3),
						registos.getString(4)
						));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return Optional.empty();
	}
	public void criar(Registo registo) {
		
		String insert = "INSERT INTO Registo (email, data, username, password) values (?,?,?,?)";
		
		try(Connection con = PostgresConfiguration.obterConnection()){
			
			PreparedStatement stat = con.prepareStatement(insert);
			stat.setString(1, registo.getEmail());
			stat.setDate(2, new java.sql.Date(registo.getData().getTime()));
			stat.setString(3, registo.getUsername());
			stat.setString(4, registo.getPassword());
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
