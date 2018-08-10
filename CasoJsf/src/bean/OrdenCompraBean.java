package bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import dao.impl.OrdenCompraImpl;
import dao.impl.ProveedorImpl;
import dao.impl.RequerimientoImpl;
import dao.impl.UsuarioImpl;
import dto.DetalleOrdenCompra;
import dto.FormaPago;
import dto.Moneda;
import dto.OrdenCompra;
import dto.Pago;
import dto.RequerimientoDetalle;

@ManagedBean(name = "ordenCompraBean")
@SessionScoped
public class OrdenCompraBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// Model
	private OrdenCompra orden;
	private Long proveedor;
	private List<RequerimientoDetalle> aprobados;

	// DAO Implementation
	private OrdenCompraImpl ordenImpl = new OrdenCompraImpl();
	private RequerimientoImpl reqImpl = new RequerimientoImpl();
	private UsuarioImpl userImpl = new UsuarioImpl();
	private ProveedorImpl provImpl = new ProveedorImpl();

	// Bean Inyectado
	@ManagedProperty(value = "#{mUsuarioBean}")
	private UsuarioBean usuarioBean;

	@ManagedProperty(value = "#{mProveedorBean}")
	private ProveedorBean proveedorBean;
	
	@ManagedProperty(value = "#{mRequerimientoBean}")
	private RequerimientoBean requerimientoBean;
	
	// Getters & Setters

	public Moneda[] getMonedas() {
		return Moneda.values();
	}

	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	public ProveedorBean getProveedorBean() {
		return proveedorBean;
	}

	public void setProveedorBean(ProveedorBean proveedorBean) {
		this.proveedorBean = proveedorBean;
	}

	public OrdenCompra getOrden() {
		return orden;
	}

	public void setOrden(OrdenCompra orden) {
		this.orden = orden;
	}

	public Pago[] getPagos() {
		return Pago.values();
	}

	public FormaPago[] getFormaPagos() {
		return FormaPago.values();
	}
	
	public List<RequerimientoDetalle> getAprobados() {
		return aprobados;
	}

	public void setAprobados(List<RequerimientoDetalle> aprobados) {
		this.aprobados = aprobados;
	}
	
	

	public Long getProveedor() {
		return proveedor;
	}

	public void setProveedor(Long proveedor) {
		this.proveedor = proveedor;
	}

	public void add(RequerimientoDetalle requerimiento) {
		DetalleOrdenCompra itemOrden = new DetalleOrdenCompra();
		itemOrden.setRequerimiento(requerimiento);
		itemOrden.setCantidad(requerimiento.getCantidad());
		requerimiento.setAtendido(true);
		reqImpl.update(requerimiento.getRequerimiento());
		aprobados.remove(requerimiento);
		orden.addDetail(itemOrden);
	}
	
	public void remove(DetalleOrdenCompra itemOrden) {
		orden.removeDetail(itemOrden);
		aprobados.add(itemOrden.getRequerimiento());
	}

	// CRUD
	public List<OrdenCompra> getAll() {
		try {
			List<OrdenCompra> list = ordenImpl.getAll();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String create() {
		orden.setProveedor(provImpl.getById(proveedor));
		ordenImpl.create(orden);
		return "index";
	}

	public String update() {
		ordenImpl.update(orden);
		return "index";
	}

	public String delete() {
		Long deleteId = this.orden.getId();
		this.orden = new OrdenCompra();
		ordenImpl.delete(deleteId);
		return "/pages/ordencompra/index.xhtml?faces-redirect=true";
	}

	public String unsuscribe() {
		Long unsuscribeId = this.orden.getId();
		this.orden = new OrdenCompra();
		this.orden = (OrdenCompra) ordenImpl.getById(unsuscribeId);
		ordenImpl.unSuscribe(orden);

		return "/pages/ordencompra/index.xhtml?faces-redirect=true";
	}

	// Redirecciones
	public String add() {
		this.orden = new OrdenCompra();
		long max = ordenImpl.getMaxId();
		this.orden.setId(max);
		this.orden.setResponsable(userImpl.getById(1L));
		this.aprobados = reqImpl.getAllApproved(); 
		return "add";
	}

	public String edit() {
		Long editId = this.orden.getId();
		this.orden = new OrdenCompra();
		this.orden = (OrdenCompra) ordenImpl.getById(editId);
		return "edit";
	}

	public String show() {
		Long id = this.orden.getId();
		this.orden = new OrdenCompra();
		this.orden = (OrdenCompra) ordenImpl.getById(id);
		return "show";
	}

	// Routes
	public String index() {
		return "/pages/ordencompra/index";
	}

}
