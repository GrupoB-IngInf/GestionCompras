package dto;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name ="usuarios")

public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	public Usuario() {
		super();
		rol = new Rol();
	}
	@Id
	@Basic(optional = false)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombres")
	private String nombres;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "contraseña")
	private String contraseña;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "estado")
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "id_rol")
	private Rol rol;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return contraseña;
	}

	public void setPassword(String password) {
		this.contraseña = password;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
