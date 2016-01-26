package sv.com.foobar.inventario.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class AdminConexiones {
	public static final String PROPS_FILE="datosConexion.properties";
	
	
	public Map<String,String> getDatosConexion(){
		Map<String,String> datos= new HashMap<>();
		Properties props= new Properties();
		try{
			props.load(getClass().getResourceAsStream(PROPS_FILE));
			datos.put("url", props.getProperty("url"));
			datos.put("user", props.getProperty("user"));
			datos.put("password", props.getProperty("password", ""));
			
		}catch(IOException eio ){
			System.out.println("Tipo de error"+ eio.getMessage());
			eio.printStackTrace();
		}
		return datos;
	}
	
	public Connection getConexion(){
		Connection cxn=null;
		Map<String, String> datos= getDatosConexion();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			cxn= DriverManager.getConnection(datos.get("url"), datos.get("user"), datos.get("password"));
		}catch(ClassNotFoundException cne){
			System.out.println("eror: " + cne.getMessage());
			cne.getStackTrace();
		}catch(SQLException sqe){
			System.out.println(" Sql error" + sqe.getMessage());
			sqe.getStackTrace();
		}
		return cxn;
		
	}
}
