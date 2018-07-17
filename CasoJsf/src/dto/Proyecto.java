package dto;

import java.io.*;


import javax.persistence.*;

@Entity
@Table(name = "Proyecto")
public class Proyecto implements Serializable {

	private static final long serialVersionUID = 1L;

	public Proyecto() {
		super();
	}

	@Id
	@Basic(optional = false)
	@Column(name = "id")
	private Long id;

	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "ubicacion")
	private String descripcion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	


}
