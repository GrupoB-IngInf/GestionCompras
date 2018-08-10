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
import javax.persistence.Transient;

@Entity
@Table(name = "ordendecompradetalle")
public class DetalleOrdenCompra implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "cantidad")
	private int cantidad;
	
	@Column(name = "familia")
	private int familia;
	
	@Column(name = "precio_unitario")
	private double precioUnitario;
		
	@ManyToOne
	@JoinColumn(name = "ordendecompra_id")
	private OrdenCompra ordenCompra;
	
	@ManyToOne
	@JoinColumn(name = "requerimientodetalle_id")
	private RequerimientoDetalle requerimiento;
	
	public DetalleOrdenCompra() {
		super();
	}

	public DetalleOrdenCompra(int cantidad, int familia, double precioUnitario, OrdenCompra ordenCompra) {
		super();
		this.cantidad = cantidad;
		this.familia = familia;
		this.precioUnitario = precioUnitario;
		this.ordenCompra = ordenCompra;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getFamilia() {
		return familia;
	}

	public void setFamilia(int familia) {
		this.familia = familia;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public OrdenCompra getOrdenCompra() {
		return ordenCompra;
	}

	public void setOrdenCompra(OrdenCompra ordenCompra) {
		this.ordenCompra = ordenCompra;
	}
	
	public double getSubtotal() {
		return precioUnitario * cantidad;
	}

	public RequerimientoDetalle getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(RequerimientoDetalle requerimiento) {
		this.requerimiento = requerimiento;
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
		DetalleOrdenCompra other = (DetalleOrdenCompra) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DetalleOrdenCompra [id=" + id + ", cantidad=" + cantidad + ", familia=" + familia + ", precioUnitario="
				+ precioUnitario + ", ordenCompra=" + ordenCompra + "]";
	}
	
}
