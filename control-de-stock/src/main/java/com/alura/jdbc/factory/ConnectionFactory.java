package com.alura.jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	private DataSource datasource;
	
	public ConnectionFactory() {
		var pooledDataSource = new ComboPooledDataSource(); 
		pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/control_de_stock?useTimeZone=true&serverTimeZone=UTC");
		pooledDataSource.setUser("root");                      // el pool de conexiones es para aumentar las conexiones que nuestra base de datos puede hacer
		pooledDataSource.setPassword("D3m0N668¡_**");          // basicamente es como si pudieramos hacer más querrys mas rapido 
		                                                       // Este metodo sustituye al public Connection de más abajo
		pooledDataSource.setMaxPoolSize(10);          // cantidad maxima de conexiones permitidas al mismo tiempo
		this.datasource = pooledDataSource;
		
	}
	
	
	public Connection Conecta(){
		try {
		return  this.datasource.getConnection(); // Este meto hace la conexion con la base de datos 
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	/*public Connection Conecta() throws SQLException{
		return  DriverManager.getConnection(
				"jdbc:mysql://localhost/control_de_stock?useTimeZone=true&serverTimeZone=UTC",
				"root",
				"D3m0N668¡_**"); // Este meto hace la conexion con la base de datos 
		
	}*/

}
