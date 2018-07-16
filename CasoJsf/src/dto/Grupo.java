package dto;

import java.io.*;

import javax.persistence.*;

@Entity
@Table(name = "grupo")
public class Grupo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public Grupo() {
		super();
	}

	@Id
	@Basic
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	
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
