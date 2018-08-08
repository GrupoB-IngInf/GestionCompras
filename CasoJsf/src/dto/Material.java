package dto;

import java.io.*;
import javax.persistence.*;

@Entity
@Table(name = "material")
public class Material implements Serializable {

	private static final long serialVersionUID = 1L;

	public Material() {
		super();
		grupo = new Grupo();
		unidadMedida=new UnidadMedida();
	}

	@Id
	@Basic(optional = false)
	@Column(name = "id")
	private Long id;

	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "estado")
	private String estado;

	@ManyToOne
	@JoinColumn(name = "Grupo_id")
	private Grupo  grupo;
	
	@ManyToOne
	@JoinColumn(name = "UnidadMedida_id")
	private UnidadMedida  unidadMedida;

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
	
	

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	public UnidadMedida getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	@Override
	public String toString() {
		return "Material [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estado=" + estado
				+ ", grupo=" + grupo + ", unidadMedida=" + unidadMedida + "]";
	}
	
	

}