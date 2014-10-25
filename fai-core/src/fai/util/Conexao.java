
package fai.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexao {

	public static Connection conectar() 
			throws ClassNotFoundException, SQLException{		
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/fai";
		String user = "postgres";
		String password = "postgres";
		Class.forName( driver );
		Connection conn = 
				DriverManager.getConnection( url, user, password);

		return conn;
		
	}	
	
}
