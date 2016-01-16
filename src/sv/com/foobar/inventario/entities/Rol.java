package sv.com.foobar.inventario.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descripcion;

	private String estado;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaUltimaActualizacion;

	private String nombre;

	private String usuarioUltimaActualizacion;

	//bi-directional many-to-one association to Solicitudasignacion
	@OneToMany(mappedBy="rol")
	private List<Solicitudasignacion> solicitudasignacions;

	//bi-directional many-to-one association to Solicitudmovimiento
	@OneToMany(mappedBy="rol")
	private List<Solicitudmovimiento> solicitudmovimientos;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="rol")
	private List<Usuario> usuarios;

	public Rol() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaUltimaActualizacion() {
		return this.fechaUltimaActualizacion;
	}

	public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuarioUltimaActualizacion() {
		return this.usuarioUltimaActualizacion;
	}

	public void setUsuarioUltimaActualizacion(String usuarioUltimaActualizacion) {
		this.usuarioUltimaActualizacion = usuarioUltimaActualizacion;
	}

	public List<Solicitudasignacion> getSolicitudasignacions() {
		return this.solicitudasignacions;
	}

	public void setSolicitudasignacions(List<Solicitudasignacion> solicitudasignacions) {
		this.solicitudasignacions = solicitudasignacions;
	}

	public Solicitudasignacion addSolicitudasignacion(Solicitudasignacion solicitudasignacion) {
		getSolicitudasignacions().add(solicitudasignacion);
		solicitudasignacion.setRol(this);

		return solicitudasignacion;
	}

	public Solicitudasignacion removeSolicitudasignacion(Solicitudasignacion solicitudasignacion) {
		getSolicitudasignacions().remove(solicitudasignacion);
		solicitudasignacion.setRol(null);

		return solicitudasignacion;
	}

	public List<Solicitudmovimiento> getSolicitudmovimientos() {
		return this.solicitudmovimientos;
	}

	public void setSolicitudmovimientos(List<Solicitudmovimiento> solicitudmovimientos) {
		this.solicitudmovimientos = solicitudmovimientos;
	}

	public Solicitudmovimiento addSolicitudmovimiento(Solicitudmovimiento solicitudmovimiento) {
		getSolicitudmovimientos().add(solicitudmovimiento);
		solicitudmovimiento.setRol(this);

		return solicitudmovimiento;
	}

	public Solicitudmovimiento removeSolicitudmovimiento(Solicitudmovimiento solicitudmovimiento) {
		getSolicitudmovimientos().remove(solicitudmovimiento);
		solicitudmovimiento.setRol(null);

		return solicitudmovimiento;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setRol(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setRol(null);

		return usuario;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", descripcion=" + descripcion + ", estado=" + estado + ", fechaUltimaActualizacion="
				+ fechaUltimaActualizacion + ", nombre=" + nombre + ", usuarioUltimaActualizacion="
				+ usuarioUltimaActualizacion + ", solicitudasignacions=" + solicitudasignacions
				+ ", solicitudmovimientos=" + solicitudmovimientos + ", usuarios=" + usuarios + "]";
	}

}