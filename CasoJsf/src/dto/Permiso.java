package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "permisos")

public class Permiso implements Serializable{
	private static final long serialVersionUID = 1L;

	public Permiso() {
		super();
		roles = new ArrayList<Rol>();
	}
	
	@Id
	@Basic
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@ManyToMany
	@JoinTable(name = "roles_permisos",
	joinColumns = @JoinColumn(name="id_rol"),
	inverseJoinColumns = 
	@JoinColumn(name = "id_permiso"))
	
	private List<Rol> roles;
	
	
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

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	
	
}
