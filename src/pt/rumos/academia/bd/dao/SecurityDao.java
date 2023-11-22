package pt.rumos.academia.bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

import pt.rumos.academia.bd.entities.Sessao;

public class SecurityDao {
	
	
	public void adicionarToken(String username, String token, LocalDateTime validade) {
			
			String insert = "INSERT INTO sessoes (username, token, data_validade) values (?,?,?)";
			
			try(Connection con = DatabaseConfiguration.obterConnection()){
				
				PreparedStatement stat = con.prepareStatement(insert);
				stat.setString(1, username);
				stat.setString(2, token);
				stat.setTimestamp(3, Timestamp.valueOf(validade));
	
				int nLinhas = stat.executeUpdate();
				if (nLinhas == 0) {
					throw new RuntimeException("Não foi possível inserir o token");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

	public Optional<Sessao> obterSessao(String token) {

		String query = "SELECT username, token, data_validade from sessoes where lower(token) = lower(?)";
		
		try(Connection con = DatabaseConfiguration.obterConnection()) {
			
			PreparedStatement stat = con.prepareStatement(query);
			stat.setString(1, token);
			ResultSet registos = stat.executeQuery();
			if(registos.next()) {
				return Optional.of(new Sessao(registos.getString(1),
						registos.getString(2),
						registos.getTimestamp(3).toLocalDateTime()
						));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return Optional.empty();
		
	}

	public boolean temAutorizacaoPara(String username, String acao) {
		
		String query = "SELECT username, acao from autorizacoesutilizadores where username = ? and acao = ?";
		
		try(Connection con = DatabaseConfiguration.obterConnection()) {
			
			PreparedStatement stat = con.prepareStatement(query);
			stat.setString(1, username);
			stat.setString(2, acao);
			ResultSet registos = stat.executeQuery();
			return registos.next();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		throw new RuntimeException("Problemas a obter a autorização para um utilizador");
		
	}
		

}
