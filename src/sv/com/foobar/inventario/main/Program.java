package sv.com.foobar.inventario.main;

import java.util.List;

import sv.com.foobar.inventario.controllers.ControladorSeguridad;
import sv.com.foobar.inventario.entities.Rol;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ControladorSeguridad cs= new ControladorSeguridad();
		List<Rol> roles=cs.getRoles();
		System.out.println("Hay "+ roles.size()+ " en la base");
		System.out.println("Mostrandoe el rol"+ roles.get(0));
		

	}

}
