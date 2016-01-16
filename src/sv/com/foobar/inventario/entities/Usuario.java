package sv.com.foobar.inventario.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String clave;

	private String estado;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaUltimaActualizacion;

	private String nombre;

	private String usuarioUltimaActualizacion;

	//bi-directional many-to-one association to Solicitudasignacion
	@OneToMany(mappedBy="usuario1")
	private List<Solicitudasignacion> solicitudasignacions1;

	//bi-directional many-to-one association to Solicitudasignacion
	@OneToMany(mappedBy="usuario2")
	private List<Solicitudasignacion> solicitudasignacions2;

	//bi-directional many-to-one association to Solicitudmovimiento
	@OneToMany(mappedBy="usuario")
	private List<Solicitudmovimiento> solicitudmovimientos;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="DepartamentoID")
	private Departamento departamento;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="RolID")
	private Rol rol;

	public Usuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
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

	public List<Solicitudasignacion> getSolicitudasignacions1() {
		return this.solicitudasignacions1;
	}

	public void setSolicitudasignacions1(List<Solicitudasignacion> solicitudasignacions1) {
		this.solicitudasignacions1 = solicitudasignacions1;
	}

	public Solicitudasignacion addSolicitudasignacions1(Solicitudasignacion solicitudasignacions1) {
		getSolicitudasignacions1().add(solicitudasignacions1);
		solicitudasignacions1.setUsuario1(this);

		return solicitudasignacions1;
	}

	public Solicitudasignacion removeSolicitudasignacions1(Solicitudasignacion solicitudasignacions1) {
		getSolicitudasignacions1().remove(solicitudasignacions1);
		solicitudasignacions1.setUsuario1(null);

		return solicitudasignacions1;
	}

	public List<Solicitudasignacion> getSolicitudasignacions2() {
		return this.solicitudasignacions2;
	}

	public void setSolicitudasignacions2(List<Solicitudasignacion> solicitudasignacions2) {
		this.solicitudasignacions2 = solicitudasignacions2;
	}

	public Solicitudasignacion addSolicitudasignacions2(Solicitudasignacion solicitudasignacions2) {
		getSolicitudasignacions2().add(solicitudasignacions2);
		solicitudasignacions2.setUsuario2(this);

		return solicitudasignacions2;
	}

	public Solicitudasignacion removeSolicitudasignacions2(Solicitudasignacion solicitudasignacions2) {
		getSolicitudasignacions2().remove(solicitudasignacions2);
		solicitudasignacions2.setUsuario2(null);

		return solicitudasignacions2;
	}

	public List<Solicitudmovimiento> getSolicitudmovimientos() {
		return this.solicitudmovimientos;
	}

	public void setSolicitudmovimientos(List<Solicitudmovimiento> solicitudmovimientos) {
		this.solicitudmovimientos = solicitudmovimientos;
	}

	public Solicitudmovimiento addSolicitudmovimiento(Solicitudmovimiento solicitudmovimiento) {
		getSolicitudmovimientos().add(solicitudmovimiento);
		solicitudmovimiento.setUsuario(this);

		return solicitudmovimiento;
	}

	public Solicitudmovimiento removeSolicitudmovimiento(Solicitudmovimiento solicitudmovimiento) {
		getSolicitudmovimientos().remove(solicitudmovimiento);
		solicitudmovimiento.setUsuario(null);

		return solicitudmovimiento;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}