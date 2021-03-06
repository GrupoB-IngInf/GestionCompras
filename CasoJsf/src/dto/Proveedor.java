package dto;

import java.io.*;
import javax.persistence.*;

@Entity
@Table(name = "proveedor")
public class Proveedor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	public Proveedor() {
		super();
	}

	@Id
	@Basic(optional = false)
	@Column(name = "id")
	private Long id;

	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "ruc")
	private String ruc;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "contacto")
	private String contacto;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "cuenta_corriente")
	private String cuenta_corriente;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "estado")
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "id_banco")
	private Banco banco;

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

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCuenta_corriente() {
		return cuenta_corriente;
	}

	public void setCuenta_corriente(String cuenta_corriente) {
		this.cuenta_corriente = cuenta_corriente;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proveedor other = (Proveedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", nombre=" + nombre + ", ruc=" + ruc + ", direccion=" + direccion
				+ ", contacto=" + contacto + ", correo=" + correo + ", cuenta_corriente=" + cuenta_corriente
				+ ", telefono=" + telefono + ", estado=" + estado + ", banco=" + banco + "]";
	}	

}
