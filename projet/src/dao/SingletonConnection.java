package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
	
	private static Connection conn;

	private SingletonConnection() {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/bookLibrary","root","");
			System.out.println("Connected Successfull");
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getInstance() {
		if(conn == null)
			new SingletonConnection();
		return conn;
	}
	
}
