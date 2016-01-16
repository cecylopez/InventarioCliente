package sv.com.foobar.inventario.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the solicitudmovimiento database table.
 * 
 */
@Entity
@NamedQuery(name="Solicitudmovimiento.findAll", query="SELECT s FROM Solicitudmovimiento s")
public class Solicitudmovimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaSolicitud;

	//bi-directional many-to-one association to Movimientoitem
	@ManyToOne
	@JoinColumn(name="MovimientoItemID")
	private Movimientoitem movimientoitem;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="RolAutorizadorID")
	private Rol rol;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="UsuarioAutorizadorID")
	private Usuario usuario;

	public Solicitudmovimiento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaSolicitud() {
		return this.fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Movimientoitem getMovimientoitem() {
		return this.movimientoitem;
	}

	public void setMovimientoitem(Movimientoitem movimientoitem) {
		this.movimientoitem = movimientoitem;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}