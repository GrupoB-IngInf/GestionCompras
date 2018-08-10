package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ordendecompra")
public class OrdenCompra implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "fecha_emision")
	@Temporal(TemporalType.DATE)
	private Date fechaEmision;
	
	@Column(name = "fecha_entrega")
	@Temporal(TemporalType.DATE)
	private Date fechaEntrega;
	
	@Column(name = "version")
	private int version;
	
	@Column(name = "moneda")
	@Enumerated(EnumType.STRING)
	private Moneda moneda;
	
	@Column(name = "tipo_pago")
	@Enumerated(EnumType.STRING)
	private Pago pago;
	
	@Column(name = "forma_pago")
	@Enumerated(EnumType.STRING)
	private FormaPago formaPago;
	
	@Column(name = "observaciones")
	private String observaciones;
	
	@Column(name = "estado")
	@Enumerated(EnumType.STRING)
	private Estado estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proveedor_id")
	private Proveedor proveedor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario responsable;
	
	@OneToMany(mappedBy = "ordenCompra", cascade = CascadeType.PERSIST, orphanRemoval = true)
	@JoinColumn(name = "ordencompra_id")
	private List<DetalleOrdenCompra> detalle = new ArrayList<>();

	public OrdenCompra() {
		super();
	}

	public OrdenCompra(String codigo, Date fechaEmision, Date fechaEntrega, int version, Moneda moneda, Pago pago,
			FormaPago formaPago, String observaciones, Estado estado, Proveedor proveedor, Usuario responsable,
			List<DetalleOrdenCompra> detalle) {
		super();
		this.codigo = codigo;
		this.fechaEmision = fechaEmision;
		this.fechaEntrega = fechaEntrega;
		this.version = version;
		this.moneda = moneda;
		this.pago = pago;
		this.formaPago = formaPago;
		this.observaciones = observaciones;
		this.estado = estado;
		this.proveedor = proveedor;
		this.responsable = responsable;
		this.detalle = detalle;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public FormaPago getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(FormaPago formaPago) {
		this.formaPago = formaPago;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Usuario getResponsable() {
		return responsable;
	}

	public void setResponsable(Usuario responsable) {
		this.responsable = responsable;
	}

	public List<DetalleOrdenCompra> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<DetalleOrdenCompra> detalle) {
		this.detalle = detalle;
	}
	
	public void addDetail(DetalleOrdenCompra detalle) {
		this.detalle.add(detalle);
		detalle.setOrdenCompra(this);
		
	}
	
	public void removeDetail(DetalleOrdenCompra detalle) {
		this.detalle.remove(detalle);
		detalle.setOrdenCompra(null);
	}
	
	public double getTotalAmount() {
		double total = 0;
		for (DetalleOrdenCompra item : detalle) {
			total += item.getSubtotal();
		}
		return Math.floor(total * 100) / 100;
	}
	
	public double getIgv() {
		double igv = 0;
		igv = this.getTotalAmount() * 0.18;
		return Math.floor(igv * 100) / 100;
	}
	
	public double getTotal() {
		double total = 0;
		total = this.getTotalAmount() * 1.18;
		return Math.floor(total * 100) / 100;
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
		OrdenCompra other = (OrdenCompra) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
}
