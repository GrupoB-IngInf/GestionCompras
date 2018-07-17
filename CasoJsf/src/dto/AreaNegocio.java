package dto;

import java.io.*;

import javax.persistence.*;

@Entity
@Table(name = "areanegocio")
public class AreaNegocio implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public AreaNegocio() {
		super();
	}

	@Id
	@Basic
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name="prefijo")
	private String prefijo;
	
	public String getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}

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
	
}