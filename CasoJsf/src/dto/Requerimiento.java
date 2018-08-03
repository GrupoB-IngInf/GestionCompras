package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "requerimiento")
public class Requerimiento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_areanegocio")
	private AreaNegocio areaNegocio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_centrocosto")
	private Centrocosto centroCosto;
	
	@OneToMany(mappedBy = "requerimiento", cascade = CascadeType.PERSIST, orphanRemoval = true)
	@JoinColumn(name = "Requerimiento_id")
	private List<RequerimientoDetalle> detalles = new ArrayList<RequerimientoDetalle>();
	
	
	public Requerimiento() {
		super();
	}
	
	public Requerimiento(String nombre, AreaNegocio areaNegocio, Usuario usuario, Centrocosto centroCosto) {
		super();
		this.nombre = nombre;
		this.areaNegocio = areaNegocio;
		this.usuario = usuario;
		this.centroCosto = centroCosto;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public AreaNegocio getAreaNegocio() {
		return areaNegocio;
	}
	public void setAreaNegocio(AreaNegocio areaNegocio) {
		this.areaNegocio = areaNegocio;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Centrocosto getCentroCosto() {
		return centroCosto;
	}
	public void setCentroCosto(Centrocosto centroCosto) {
		this.centroCosto = centroCosto;
	}
		
	public List<RequerimientoDetalle> getDetalle() {
		return detalles;
	}

	public void setDetalle(List<RequerimientoDetalle> detalles) {
		this.detalles = detalles;
	}

	public void addDetail(RequerimientoDetalle rDetalle) {
		this.detalles.add(rDetalle);
		rDetalle.setRequerimiento(this);
	}

	public void removeDetail(RequerimientoDetalle rDetalle) {
		this.detalles.remove(rDetalle);
		rDetalle.setRequerimiento(null);
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Requerimiento other = (Requerimiento) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Requerimiento [id=" + id + ", nombre=" + nombre + ", areaNegocio=" + areaNegocio + ", usuario="
				+ usuario + ", centroCosto=" + centroCosto + "]";
	}
	
}
