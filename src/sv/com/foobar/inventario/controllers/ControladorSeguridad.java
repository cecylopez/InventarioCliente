package sv.com.foobar.inventario.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import sv.com.foobar.inventario.entities.Rol;

public class ControladorSeguridad {
	
	public List<Rol> getRoles(){
		EntityManager em= Persistence.createEntityManagerFactory("InvetarioClient").createEntityManager();
		TypedQuery<Rol> query= em.createQuery("SELECT r FROM Rol r", Rol.class);
		
		return query.getResultList();
	}
	
	public void addRol(Rol r){
		EntityManager em=Persistence.createEntityManagerFactory("InvetarioClient").createEntityManager();
		if(r.getId()>0){
			em.merge(r);
		}else{
			int id= em.createQuery("SELECT COALESCE(MAX(r.id), 0) FROM Rol r").getFirstResult();
			r.setId(id+1);
			em.persist(r);
		}
	}
		
}
