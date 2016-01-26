package sv.com.foobar.inventario.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import sv.com.foobar.inventario.controllers.ControladorSeguridad;
import sv.com.foobar.inventario.dao.AdminConexiones;
import sv.com.foobar.inventario.entities.Rol;

public class Program {

	public static void main(String[] args) throws SQLException {
//		ControladorSeguridad cs = new ControladorSeguridad();
//		List<Rol> roles = cs.getRoles();
//		System.out.println("Hay " + roles.size() + " roles en la base de datos");
//		System.out.println("Rol: " + roles.get(0));
		Map<String,String> datos=new AdminConexiones().getDatosConexion();
		System.out.println("url:" + datos.get("url"));
		System.out.println("user:" + datos.get("user"));
		System.out.println("password: "+ datos.get("password"));
		
		Connection cxn= new AdminConexiones().getConexion();
		
		System.out.println("Estado conexion " + cxn.isClosed());
	}

}
