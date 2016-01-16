package sv.com.foobar.inventario.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipomovimiento database table.
 * 
 */
@Entity
@NamedQuery(name="Tipomovimiento.findAll", query="SELECT t FROM Tipomovimiento t")
public class Tipomovimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Movimientoitem
	@OneToMany(mappedBy="tipomovimiento")
	private List<Movimientoitem> movimientoitems;

	public Tipomovimiento() {
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Movimientoitem> getMovimientoitems() {
		return this.movimientoitems;
	}

	public void setMovimientoitems(List<Movimientoitem> movimientoitems) {
		this.movimientoitems = movimientoitems;
	}

	public Movimientoitem addMovimientoitem(Movimientoitem movimientoitem) {
		getMovimientoitems().add(movimientoitem);
		movimientoitem.setTipomovimiento(this);

		return movimientoitem;
	}

	public Movimientoitem removeMovimientoitem(Movimientoitem movimientoitem) {
		getMovimientoitems().remove(movimientoitem);
		movimientoitem.setTipomovimiento(null);

		return movimientoitem;
	}

}