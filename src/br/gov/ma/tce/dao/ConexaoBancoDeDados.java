package br.gov.ma.tce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDeDados {
	
	  private final String url = "jdbc:postgresql://localhost:5432/tce";
	  private final String user = "postgres"; 
	  private final String password = "postgres";
	 
	
	public Connection getConnection() {
		
		Connection connection = null;
		System.out.println("Chamando Conexão");
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Conexão realizada com sucesso");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
