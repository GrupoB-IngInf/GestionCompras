package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "requerimientodetalle")
public class RequerimientoDetalle implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "cantidad")
	private int cantidad;
	
	@Column(name = "cantidad_atendida")
	private int cantidadAtendida;
	
	@Column(name = "atendido")
	private boolean atendido;
	
	@Column(name = "observaciones")
	private String observaciones;
	
	@ManyToOne
	private Requerimiento requerimiento;
	
	@ManyToOne
	@JoinColumn(name = "Etapa_id")
	private Etapa etapa;
		
	@ManyToOne
	@JoinColumn(name = "Material_id")
	private Material material;
		
	public RequerimientoDetalle() {
		super();
		this.cantidadAtendida = 0;
		this.atendido = false;
	}
	
	public RequerimientoDetalle(int cantidad, String observaciones,
			Requerimiento requerimiento, Etapa etapa,  Material material) {
		super();
		this.cantidad = cantidad;
		this.cantidadAtendida = 0;
		this.atendido = false;
		this.observaciones = observaciones;
		this.requerimiento = requerimiento;
		this.etapa = etapa;
		this.material = material;
	}

	
	public RequerimientoDetalle(int cantidad, int cantidadAtendida, boolean atendido, String observaciones,
			Requerimiento requerimiento, Etapa etapa,  Material material) {
		super();
		this.cantidad = cantidad;
		this.cantidadAtendida = cantidadAtendida;
		this.atendido = atendido;
		this.observaciones = observaciones;
		this.requerimiento = requerimiento;
		this.etapa = etapa;
		this.material = material;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Requerimiento getRequerimiento() {
		return requerimiento;
	}
	public void setRequerimiento(Requerimiento requerimiento) {
		this.requerimiento = requerimiento;
	}
	public Etapa getEtapa() {
		return etapa;
	}
	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public int getCantidadAtendida() {
		return cantidadAtendida;
	}	
	
	public void setCantidadAtendida(int cantidadAtendida) {
		this.cantidadAtendida = cantidadAtendida;
	}
	public boolean isAtendido() {
		return atendido;
	}
	public void setAtendido(boolean atendido) {
		this.atendido = atendido;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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
		RequerimientoDetalle other = (RequerimientoDetalle) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "RequerimientoDetalle [id=" + id + ", cantidad=" + cantidad + ", cantidadAtendida=" + cantidadAtendida
				+ ", atendido=" + atendido + ", observaciones=" + observaciones + ", requerimiento=" + requerimiento
				+ ", etapa=" + etapa + ", material=" + material + "]";
	}
	
}
