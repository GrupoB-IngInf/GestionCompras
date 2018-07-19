package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name = "roles")

public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	public Rol() {
		super();
		permisos = new ArrayList<Permiso>();
	}
	
	@Id
	@Basic
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@ManyToMany(mappedBy = "roles")
	private List<Permiso> permisos;
	
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

	public List<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}
		
}
