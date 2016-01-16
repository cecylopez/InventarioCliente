package sv.com.foobar.inventario.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the item database table.
 * 
 */
@Entity
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int cantidad;

	private int cantidadMinima;

	private String codigoBarras;

	private String descripcion;

	private String estado;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaUltimaActualizacion;

	@Lob
	private byte[] imagen;

	private String nombre;

	private String usuarioUltimaActualizacion;

	//bi-directional many-to-one association to Asignacionitem
	@OneToMany(mappedBy="item")
	private List<Asignacionitem> asignacionitems;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="CategoriaID")
	private Categoria categoria;

	//bi-directional many-to-one association to Movimientoitem
	@OneToMany(mappedBy="item")
	private List<Movimientoitem> movimientoitems;

	public Item() {
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

	public int getCantidadMinima() {
		return this.cantidadMinima;
	}

	public void setCantidadMinima(int cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}

	public String getCodigoBarras() {
		return this.codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
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

	public byte[] getImagen() {
		return this.imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
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

	public List<Asignacionitem> getAsignacionitems() {
		return this.asignacionitems;
	}

	public void setAsignacionitems(List<Asignacionitem> asignacionitems) {
		this.asignacionitems = asignacionitems;
	}

	public Asignacionitem addAsignacionitem(Asignacionitem asignacionitem) {
		getAsignacionitems().add(asignacionitem);
		asignacionitem.setItem(this);

		return asignacionitem;
	}

	public Asignacionitem removeAsignacionitem(Asignacionitem asignacionitem) {
		getAsignacionitems().remove(asignacionitem);
		asignacionitem.setItem(null);

		return asignacionitem;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Movimientoitem> getMovimientoitems() {
		return this.movimientoitems;
	}

	public void setMovimientoitems(List<Movimientoitem> movimientoitems) {
		this.movimientoitems = movimientoitems;
	}

	public Movimientoitem addMovimientoitem(Movimientoitem movimientoitem) {
		getMovimientoitems().add(movimientoitem);
		movimientoitem.setItem(this);

		return movimientoitem;
	}

	public Movimientoitem removeMovimientoitem(Movimientoitem movimientoitem) {
		getMovimientoitems().remove(movimientoitem);
		movimientoitem.setItem(null);

		return movimientoitem;
	}

}