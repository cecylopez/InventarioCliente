package sv.com.foobar.inventario.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the movimientoitem database table.
 * 
 */
@Entity
@NamedQuery(name="Movimientoitem.findAll", query="SELECT m FROM Movimientoitem m")
public class Movimientoitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int cantidad;

	private String estado;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	private int usuarioID;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="DepartamentoID")
	private Departamento departamento;

	//bi-directional many-to-one association to Tipomovimiento
	@ManyToOne
	@JoinColumn(name="TipoMovimientoID")
	private Tipomovimiento tipomovimiento;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="ItemID")
	private Item item;

	//bi-directional many-to-one association to Solicitudmovimiento
	@OneToMany(mappedBy="movimientoitem")
	private List<Solicitudmovimiento> solicitudmovimientos;

	public Movimientoitem() {
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

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getUsuarioID() {
		return this.usuarioID;
	}

	public void setUsuarioID(int usuarioID) {
		this.usuarioID = usuarioID;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Tipomovimiento getTipomovimiento() {
		return this.tipomovimiento;
	}

	public void setTipomovimiento(Tipomovimiento tipomovimiento) {
		this.tipomovimiento = tipomovimiento;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public List<Solicitudmovimiento> getSolicitudmovimientos() {
		return this.solicitudmovimientos;
	}

	public void setSolicitudmovimientos(List<Solicitudmovimiento> solicitudmovimientos) {
		this.solicitudmovimientos = solicitudmovimientos;
	}

	public Solicitudmovimiento addSolicitudmovimiento(Solicitudmovimiento solicitudmovimiento) {
		getSolicitudmovimientos().add(solicitudmovimiento);
		solicitudmovimiento.setMovimientoitem(this);

		return solicitudmovimiento;
	}

	public Solicitudmovimiento removeSolicitudmovimiento(Solicitudmovimiento solicitudmovimiento) {
		getSolicitudmovimientos().remove(solicitudmovimiento);
		solicitudmovimiento.setMovimientoitem(null);

		return solicitudmovimiento;
	}

}