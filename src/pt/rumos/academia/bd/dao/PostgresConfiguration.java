package pt.rumos.academia.bd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConfiguration {
	
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

}
