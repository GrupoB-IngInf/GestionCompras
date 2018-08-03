package bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import dao.impl.OrdenCompraImpl;
import dto.DetalleOrdenCompra;
import dto.FormaPago;
import dto.Moneda;
import dto.OrdenCompra;
import dto.Pago;

@ManagedBean(name = "ordenCompraBean")
@SessionScoped
public class OrdenCompraBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// Model
	private OrdenCompra orden = new OrdenCompra();
	//private List<DetalleRequerimiento> aprobados;

	// DAO Implementation
	private OrdenCompraImpl ordenImpl = new OrdenCompraImpl();

	// Bean Inyectado
	@ManagedProperty(value = "#{mUsuarioBean}")
	private UsuarioBean usuarioBean;

	@ManagedProperty(value = "#{mProveedorBean}")
	private ProveedorBean proveedorBean;

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
	/*
	public List<DetalleRequerimiento> getAprobados() {
		return aprobados;
	}

	public void setAprobados(List<DetalleRequerimiento> aprobados) {
		this.aprobados = aprobados;
	}

	public void addReq(DetalleRequerimiento requerimiento) {
		DetalleOrdenCompra itemOrden = new DetalleOrdenCompra();
		itemOrden.setDetalleRequerimiento(requerimiento);
		itemOrden.setCantidad(requerimiento.getCantidad());
		
		aprobados.remove(requerimiento);
		orden.addDetail(itemOrden);
	}*/

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
