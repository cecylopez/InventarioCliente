package sv.com.foobar.inventario.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the solicitudasignacion database table.
 * 
 */
@Entity
@NamedQuery(name="Solicitudasignacion.findAll", query="SELECT s FROM Solicitudasignacion s")
public class Solicitudasignacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAutorizacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaSolicitud;

	//bi-directional many-to-one association to Asignacionitem
	@ManyToOne
	@JoinColumn(name="AsignacionItemID")
	private Asignacionitem asignacionitem;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="RolAutorizadorID")
	private Rol rol;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="UsuarioID")
	private Usuario usuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="UsuarioAutorizadorID")
	private Usuario usuario2;

	public Solicitudasignacion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaAutorizacion() {
		return this.fechaAutorizacion;
	}

	public void setFechaAutorizacion(Date fechaAutorizacion) {
		this.fechaAutorizacion = fechaAutorizacion;
	}

	public Date getFechaSolicitud() {
		return this.fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Asignacionitem getAsignacionitem() {
		return this.asignacionitem;
	}

	public void setAsignacionitem(Asignacionitem asignacionitem) {
		this.asignacionitem = asignacionitem;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Usuario getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public Usuario getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

}