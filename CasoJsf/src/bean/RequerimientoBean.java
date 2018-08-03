package bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedProperty;

import dao.impl.RequerimientoImpl;
import dto.*;

public class RequerimientoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Model
	private Requerimiento requerimiento;
	private RequerimientoDetalle requerimientoDetalle;
	
	//Dao Impl
	private RequerimientoImpl requerimientoImpl = new RequerimientoImpl();
	
	private List<Requerimiento> listaRequerimiento;
	
	//Beans inyectados
	
	@ManagedProperty(value = "#{mMaterialBean}")
	private MaterialBean materialBean;
	
	@ManagedProperty(value = "#{mAreaNegocio}")
	private AreaNegocio areaNegocio;
	
	@ManagedProperty(value = "#{mUsuario}")
	private Usuario usuario;
	
	@ManagedProperty(value = "#{mCentroCosto}")
	private Centrocosto centroCosto;
	
	@ManagedProperty(value = "#{mEtapa}")
	private Etapa etapa;

	public Requerimiento getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(Requerimiento requerimiento) {
		this.requerimiento = requerimiento;
	}

	public RequerimientoDetalle getRequerimientoDetalle() {
		return requerimientoDetalle;
	}

	public void setRequerimientoDetalle(RequerimientoDetalle requerimientoDetalle) {
		this.requerimientoDetalle = requerimientoDetalle;
	}

	public RequerimientoImpl getRequerimientoImpl() {
		return requerimientoImpl;
	}

	public void setRequerimientoImpl(RequerimientoImpl requerimientoImpl) {
		this.requerimientoImpl = requerimientoImpl;
	}

	public List<Requerimiento> getListaRequerimiento() {
		return listaRequerimiento;
	}

	public void setListaRequerimiento(List<Requerimiento> listaRequerimiento) {
		this.listaRequerimiento = listaRequerimiento;
	}

	public MaterialBean getMaterialBean() {
		return materialBean;
	}

	public void setMaterialBean(MaterialBean materialBean) {
		this.materialBean = materialBean;
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

	public Etapa getEtapa() {
		return etapa;
	}

	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}
	
	//@ManagedProperty(value = "#{mOrdenCompraDetalle}")
	//private OrdenCompraDetalle ordenCompraDetalle;
	
	
	
	
	public String additem() {
		RequerimientoDetalle requerimientoDeta = new RequerimientoDetalle(this.requerimientoDetalle.getRequerimiento(),this.requerimientoDetalle.getEtapa(), this.requerimientoDetalle.getMaterial(), this.requerimientoDetalle.getCantidad());
		this.requerimiento.addDetail(requerimientoDeta);
		this.requerimientoDetalle.setCantidad(0.0);
		return null;
	}
	
	public String removeItem(RequerimientoDetalle item) {
	      this.requerimiento.removeDetail(item);
	      return null;
	}
	
	
	//CRUD
	public List<Requerimiento> getAll() {
		try {
			List<Requerimiento> list = requerimientoImpl.getAll();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String create() {
		requerimientoImpl.create(requerimiento);
		return "index";
	}
	
	public String update() {
		requerimientoImpl.update(requerimiento);
		return "index";
	}

	public String delete() {
		Long deleteId = this.requerimiento.getId();
		this.requerimiento = new Requerimiento();
		requerimientoImpl.delete(deleteId);
		return "/pages/requerimiento/index.xhtml?faces-redirect=true";
	}
	
	//Redirecciones
	
	public String add() {
		this.requerimiento = new Requerimiento();
		long max = requerimientoImpl.getMaxId();
		this.requerimiento.setId(max);
		return "add";
	}

	public String edit() {
		Long editId = this.requerimiento.getId();
		this.requerimiento = new Requerimiento();
		this.requerimiento = (Requerimiento) requerimientoImpl.getById(editId);
		return "edit";
	}

	public String show() {
		Long id = this.requerimiento.getId();
		this.requerimiento= new Requerimiento();
		this.requerimiento = (Requerimiento) requerimientoImpl.getById(id);
		return "show";
	}
	
	//Routes
	
	public String index() {
		return "/pages/requerimiento/index";
	}
}
