package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connessione {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/agenziaviaggi";
	public static final String USER = "root";
	public static final String PASSWORD = "root12";
	
	
	public Connection connetti () throws SQLException {
		Connection conn = null ;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return conn ;
				
	}
	
	
	
}
