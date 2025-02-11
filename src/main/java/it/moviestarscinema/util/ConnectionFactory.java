package it.moviestarscinema.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection conn;
	private static final String URL = "jdbc:postgresql://localhost:5432/moviestars-cinema";
	private static final String USER = "postgres";
	private static final String PASSWORD = "admin";

	public static Connection getConnection() {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if (conn != null)
			return conn;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			System.out.println("Connessione al database stabilita");

		} catch (SQLException ex) {
			System.out.println("Database connection exception");
			ex.printStackTrace();
		}

		return conn;
	}

	public static void closeConnection() {
		if (conn != null)
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
