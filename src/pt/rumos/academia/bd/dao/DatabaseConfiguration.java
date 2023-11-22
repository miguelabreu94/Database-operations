package pt.rumos.academia.bd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfiguration {
	
	static String url = "jdbc:postgresql://localhost:5432/postgres";
	static String dbUsername = "postgres";
	static String dbPassword = "12345";
	
	public static Connection obterConnection() {
		try {
			return DriverManager.getConnection(url, dbUsername,dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public static RegistosDao obterRegistosDao() {

		var ambiente = System.getProperty("env");
		
		if("dev".equals(ambiente)) {
			return new TestarRegistosDao();
		}
		
		if("prod".equals(ambiente)) {
			return new PostgresRegistosDao();
		}
		
		throw new RuntimeException("O valor da propriedade 'env' não é conhecido");
	}

}
