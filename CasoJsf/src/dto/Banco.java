package dto;
import java.io.*;
import javax.persistence.*;


@Entity
@Table(name = "banco")
public class Banco implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Banco() {
		super();
	}

	@Id
	@Basic
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "estado")
	private String estado;

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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
