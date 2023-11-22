package pt.rumos.academia.bd.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class GenericDao<T> {
	
	public List<T> todos(String query, Function<ResultSet, T> mapperBean)
	{
		var results = new ArrayList<T>();
		try(Connection con = DatabaseConfiguration.obterConnection()) {
			
			Statement stat = con.createStatement();
			ResultSet registos = stat.executeQuery(query);
			
			while(registos.next()) {
				results.add(mapperBean.apply(registos));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return results;
		
	}

}
