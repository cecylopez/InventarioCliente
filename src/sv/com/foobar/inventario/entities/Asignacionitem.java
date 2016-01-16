package sv.com.foobar.inventario.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the asignacionitem database table.
 * 
 */
@Entity
@NamedQuery(name="Asignacionitem.findAll", query="SELECT a FROM Asignacionitem a")
public class Asignacionitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int cantidad;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="DepartamentoID")
	private Departamento departamento;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="ItemID")
	private Item item;

	//bi-directional many-to-one association to Solicitudasignacion
	@OneToMany(mappedBy="asignacionitem")
	private List<Solicitudasignacion> solicitudasignacions;

	public Asignacionitem() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public List<Solicitudasignacion> getSolicitudasignacions() {
		return this.solicitudasignacions;
	}

	public void setSolicitudasignacions(List<Solicitudasignacion> solicitudasignacions) {
		this.solicitudasignacions = solicitudasignacions;
	}

	public Solicitudasignacion addSolicitudasignacion(Solicitudasignacion solicitudasignacion) {
		getSolicitudasignacions().add(solicitudasignacion);
		solicitudasignacion.setAsignacionitem(this);

		return solicitudasignacion;
	}

	public Solicitudasignacion removeSolicitudasignacion(Solicitudasignacion solicitudasignacion) {
		getSolicitudasignacions().remove(solicitudasignacion);
		solicitudasignacion.setAsignacionitem(null);

		return solicitudasignacion;
	}

}