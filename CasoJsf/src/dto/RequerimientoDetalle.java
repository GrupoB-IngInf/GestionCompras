package dto;

import java.io.Serializable;

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
	
	@ManyToOne
	@JoinColumn(name = "Requerimiento_id")
	private Requerimiento requerimiento;
	
	@ManyToOne
	@JoinColumn(name = "Etapa_id")
	private Etapa etapa;
	
	private DetalleOrdenCompra ordenCompraDetalle;
	
	@ManyToOne
	@JoinColumn(name = "Material_id")
	private Material material;
	
	@Column(name = "cantidad")
	private int cantidad;
	
	public RequerimientoDetalle() {
		super();
	}
	public RequerimientoDetalle(Requerimiento requerimiento, Etapa etapa, Material material, int cantidad) {
		super();
		this.requerimiento = requerimiento;
		this.etapa = etapa;
		this.material = material;
		this.cantidad = cantidad;
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
	public DetalleOrdenCompra getOrdenCompraDetalle() {
		return ordenCompraDetalle;
	}
	public void setOrdenCompraDetalle(DetalleOrdenCompra ordenCompraDetalle) {
		this.ordenCompraDetalle = ordenCompraDetalle;
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
		return "RequerimientoDetalle [id=" + id + ", requerimiento=" + requerimiento + ", etapa=" + etapa
				+ ", material=" + material + ", cantidad=" + cantidad + "]";
	}
	
	/*
	 * A�adir a este metodo "orden de compra detalle"
	 */
	
	
	
}
