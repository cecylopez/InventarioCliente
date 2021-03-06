package sv.com.foobar.inventario.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int categoriaPadreID;

	private String descripcion;

	private String estado;

	private String nombre;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="categoria")
	private List<Item> items;

	public Categoria() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoriaPadreID() {
		return this.categoriaPadreID;
	}

	public void setCategoriaPadreID(int categoriaPadreID) {
		this.categoriaPadreID = categoriaPadreID;
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

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setCategoria(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setCategoria(null);

		return item;
	}

}