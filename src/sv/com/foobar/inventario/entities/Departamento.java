package sv.com.foobar.inventario.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the departamento database table.
 * 
 */
@Entity
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descripcion;

	private String estado;

	private String nombre;

	//bi-directional many-to-one association to Asignacionitem
	@OneToMany(mappedBy="departamento")
	private List<Asignacionitem> asignacionitems;

	//bi-directional many-to-one association to Movimientoitem
	@OneToMany(mappedBy="departamento")
	private List<Movimientoitem> movimientoitems;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="departamento")
	private List<Usuario> usuarios;

	public Departamento() {
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Asignacionitem> getAsignacionitems() {
		return this.asignacionitems;
	}

	public void setAsignacionitems(List<Asignacionitem> asignacionitems) {
		this.asignacionitems = asignacionitems;
	}

	public Asignacionitem addAsignacionitem(Asignacionitem asignacionitem) {
		getAsignacionitems().add(asignacionitem);
		asignacionitem.setDepartamento(this);

		return asignacionitem;
	}

	public Asignacionitem removeAsignacionitem(Asignacionitem asignacionitem) {
		getAsignacionitems().remove(asignacionitem);
		asignacionitem.setDepartamento(null);

		return asignacionitem;
	}

	public List<Movimientoitem> getMovimientoitems() {
		return this.movimientoitems;
	}

	public void setMovimientoitems(List<Movimientoitem> movimientoitems) {
		this.movimientoitems = movimientoitems;
	}

	public Movimientoitem addMovimientoitem(Movimientoitem movimientoitem) {
		getMovimientoitems().add(movimientoitem);
		movimientoitem.setDepartamento(this);

		return movimientoitem;
	}

	public Movimientoitem removeMovimientoitem(Movimientoitem movimientoitem) {
		getMovimientoitems().remove(movimientoitem);
		movimientoitem.setDepartamento(null);

		return movimientoitem;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setDepartamento(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setDepartamento(null);

		return usuario;
	}

}